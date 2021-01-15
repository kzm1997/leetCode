//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针 
// 👍 817 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//java:回文链表
public class P234PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new P234PalindromeLinkedList().new Solution();
        ListNode node=new ListNode(-129);
        ListNode node2=new ListNode(-129);
        node.next=node2;
        solution.isPalindrome(node);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

     public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public boolean isPalindrome(ListNode head) {
            List<Integer> list=new ArrayList();
            while (head != null) {
                  list.add(head.val);
                  head=head.next;
            }
            int p1=0;
            int p2=list.size()-1;
            while (p1<p2){
                if (list.get(p1).compareTo(list.get(p2))!=0){
                    return false;
                }
                p1++;
                p2--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}