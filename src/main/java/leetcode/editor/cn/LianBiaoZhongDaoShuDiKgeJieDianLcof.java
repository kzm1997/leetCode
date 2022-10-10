//输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。 
//
// 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。 
//
// 
//
// 示例： 
//
// 
//给定一个链表: 1->2->3->4->5, 和 k = 2.
//
//返回链表 4->5. 
// Related Topics 链表 双指针 👍 388 👎 0


package leetcode.editor.cn;

import java.util.List;

public class LianBiaoZhongDaoShuDiKgeJieDianLcof {
    public static void main(String[] args) {
        Solution solution = new LianBiaoZhongDaoShuDiKgeJieDianLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x){
            val = x;
        }
    }

    class Solution {
        //快慢指针解决
        public ListNode getKthFromEnd(ListNode head, int k) {
            
            ListNode fast=head;
            ListNode low=head;
            
            int i=0;
            while (fast.next!=null){
                i++;
                fast=fast.next;
                if (i>=k){
                    low=low.next;
                }
            }
            return low;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
