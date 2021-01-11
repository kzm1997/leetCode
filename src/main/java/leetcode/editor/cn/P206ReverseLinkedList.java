//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1433 👎 0

package leetcode.editor.cn;

import javax.swing.*;

//java:反转链表
public class P206ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new P206ReverseLinkedList().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode prev=null;
            ListNode cur=head;
            while (cur!=null){
                ListNode nextNode=cur.next;
                cur.next=prev;
                prev=cur;
                cur=nextNode;
            }
            return  prev;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}