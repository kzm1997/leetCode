//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
// Related Topics 递归 链表 数学 
// 👍 6290 👎 0


package leetcode.editor.cn;

//两数相加

import javax.print.attribute.standard.NumberUp;
import java.util.List;

public class P2_AddTwoNumbers {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P2_AddTwoNumbers().new Solution();
        ListNode l1 = new ListNode();
        ListNode s1 = l1;
        l1.val = 2;
        l1.next = new ListNode();
        l1 = l1.next;
        l1.val = 4;
        l1.next = new ListNode();
        l1 = l1.next;
        l1.val = 3;
        ListNode l2 = new ListNode();
        ListNode s2 = l2;
        l2.val = 5;
        l2.next = new ListNode();
        l2 = l2.next;
        l2.val = 6;
        l2.next = new ListNode();
        l2 = l2.next;
        l2.val = 4;
        ListNode listNode = solution.addTwoNumbers(s1, s2);
        System.out.println(listNode.val);

    }
//力扣代码
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode result = new ListNode();
            ListNode first = result;
            int j = 0;
            while (l1 != null || l2 != null||j!=0) {
                int data1 = l1 == null ? 0 : l1.val;
                int data2 = l2 == null ? 0 : l2.val;
                result.val = (data1 + data2 + j) % 10;
                j = (data1 + data2 + j) >= 10 ? 1 : 0;
                if (l1 != null) {
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2 = l2.next;
                }
                if(l1==null&&l2==null&&j==0){
                    return first;
                }
                result.next = new ListNode();
                result = result.next;
            }
            return first;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}