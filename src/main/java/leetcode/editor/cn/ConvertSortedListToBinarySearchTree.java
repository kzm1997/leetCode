//给定一个单链表的头节点 head ，其中的元素 按升序排序 ，将其转换为高度平衡的二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差不超过 1。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: head = [-10,-3,0,5,9]
//输出: [0,-3,9,-10,null,5]
//解释: 一个可能的答案是[0，-3,9，-10,null,5]，它表示所示的高度平衡的二叉搜索树。
// 
//
// 示例 2: 
//
// 
//输入: head = []
//输出: []
// 
//
// 
//
// 提示: 
//
// 
// head 中的节点数在[0, 2 * 10⁴] 范围内 
// -10⁵ <= Node.val <= 10⁵ 
// 
// Related Topics 树 二叉搜索树 链表 分治 二叉树 👍 776 👎 0


package leetcode.editor.cn;

import com.sun.org.apache.regexp.internal.RE;

public class ConvertSortedListToBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new ConvertSortedListToBinarySearchTree().new Solution();
        
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(5);
        ListNode node6=new ListNode(6);
        
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        
        solution.sortedListToBST(node1);
        
        
        
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    public static  class ListNode {
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

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public TreeNode sortedListToBST(ListNode head) {
            return buildTreeNode(head,null);
            
        }
        
        public TreeNode buildTreeNode(ListNode left,ListNode right){
            if (left==right){
                return null;
            }
            ListNode mid=getMedian(left,right);
            TreeNode root=new TreeNode(mid.val);
            root.left=buildTreeNode(left,mid);
            root.right=buildTreeNode(mid.next,right);
            return root;
        }


        public ListNode getMedian(ListNode left, ListNode right) {
            ListNode fast = left;
            ListNode slow = left;

            while (fast != right && fast.next != right) {
                fast = fast.next;
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
