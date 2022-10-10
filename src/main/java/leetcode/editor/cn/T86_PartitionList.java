//////给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。 
//////
////// 你应当 保留 两个分区中每个节点的初始相对位置。 
//////
////// 
//////
////// 示例 1： 
//////
////// 
//////输入：head = [1,4,3,2,5,2], x = 3
//////输出：[1,2,2,4,3,5]
////// 
//////
////// 示例 2： 
//////
////// 
//////输入：head = [2,1], x = 2
//////输出：[1,2]
////// 
//////
////// 
//////
////// 提示： 
//////
////// 
////// 链表中节点的数目在范围 [0, 200] 内 
////// -100 <= Node.val <= 100 
////// -200 <= x <= 200 
////// 
////// Related Topics 链表 双指针 👍 630 👎 0
////
//


package leetcode.editor.cn;

//Java：分隔链表
public class T86_PartitionList {
    public static void main(String[] args) {
        Solution solution = new T86_PartitionList().new Solution();
        // TO TEST
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(2);
        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(3);
        ListNode node6=new ListNode(5);
        
       node1.next=node4;
       node4.next=node5;
       node5.next=node2;
       node2.next=node6;
       node6.next=node3;

        ListNode partition = solution.partition2(node1, 3);
        System.out.println(partition);

    }
    //leetcode submit region begin(Prohibit modification and deletion)


    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode smallNode=null;
            ListNode smallNodeTemp=null;
            ListNode bigNode=null;
            ListNode bigNodeTemp=null;
            if (head == null) {
                return null;
            }
            
            while (head!=null){
                if (head.val<x){
                    if (smallNodeTemp==null){
                        smallNode=new ListNode(head.val);
                        smallNodeTemp=smallNode;
                    }else {
                        smallNode.next=new ListNode(head.val);
                    }
                    if (smallNode.next!=null){
                        smallNode=smallNode.next;
                    }
                  
                }else if (head.val>x){
                    if (bigNodeTemp==null){
                        bigNode=new ListNode(head.val);
                        bigNodeTemp=bigNode;
                    }else {
                        bigNode.next=new ListNode(head.val);
                    }
                    if (bigNode.next!=null){
                        bigNode=bigNode.next;
                    }
                }
                head=head.next;
            }
            
            
            if (smallNodeTemp==null){
                ListNode realHead=new ListNode(x);
                realHead.next=bigNodeTemp;
                return realHead;
            }
            if (bigNodeTemp==null){
                ListNode realHead=new ListNode(x);
                realHead.next=smallNodeTemp;
                return realHead;
            }
            smallNode=smallNodeTemp;
            while (smallNode!=null){
                if (smallNode.next==null){
                    break;
                }
                smallNode=smallNode.next;
            }
            ListNode realHead=new ListNode(x);
            smallNode.next=realHead;
            realHead.next=bigNodeTemp;
            
            return smallNodeTemp;
            
        }

        /**
         * 1轮:  small:0    shallHead: 0    large:0     largeHead:0
         * 1轮:  small:1    shallHead:0      large:0     largeHead:0
         * 1轮:  small:1    shallHead:0      large:4     largeHead:0
         * 1轮:  small:1    shallHead:0      large: 3    largeHead:0
         * 1轮:  small:2    shallHead:0      large:3     largeHead:0
         * 1轮:  small:2    shallHead:0      large:5     largeHead:0
         * 1轮:  small:2    shallHead:0      large:5     largeHead:0
         * ---结束循环 0->1->2->2  0->4->3->5>2
         * 0->1->2->2   0->4->3->5
         * 0->1->2->2->4->3->5
         * @param head
         * @param x
         * @return
         */
        public ListNode partition2(ListNode head, int x) {
            ListNode small = new ListNode(0);  
            ListNode smallHead = small;
            ListNode large = new ListNode(0);
            ListNode largeHead = large;
            while (head != null) {
                if (head.val < x) {
                    small.next = head;
                    small = small.next;
                } else {
                    large.next = head;
                    large = large.next;
                }
                head = head.next;
            }
            large.next = null;
            small.next = largeHead.next;
            return smallHead.next;
        }
        
    }
//leetcode submit region end(Prohibit modification and deletion)

}
