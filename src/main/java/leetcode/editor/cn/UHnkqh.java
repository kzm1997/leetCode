//给定单链表的头节点 head ，请反转链表，并返回反转后的链表的头节点。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
// 
// 
//
// 
//
// 注意：本题与主站 206 题相同： https://leetcode-cn.com/problems/reverse-linked-list/ 
// Related Topics 递归 链表 👍 83 👎 0


package leetcode.editor.cn;

import java.util.List;

public class UHnkqh {
    public static void main(String[] args) {
        Solution solution = new UHnkqh().new Solution();
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);

        listNode.next = listNode2;
        listNode2.next = listNode3;
        ListNode listNode1 = solution.reverseList(listNode);

        System.out.println(listNode1);


    }
    //leetcode submit region begin(Prohibit modification and deletion)

    public static class ListNode {
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
        public ListNode reverseList(ListNode head) {

            ListNode pre = null;
            ListNode cur = head;
            while (cur != null) {
                 ListNode next=cur.next; //获取下一个节点
                 cur.next=pre; //把下一个节点赋值给前一个节点
                 pre=cur;    //把当前节点给前一个节点
                 cur=next; //把后节点给当前节点
            }
            return pre;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
