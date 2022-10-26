//给你二叉树的根结点 root ，请你将它展开为一个单链表： 
//
// 
// 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。 
// 展开后的单链表应该与二叉树 先序遍历 顺序相同。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,5,3,4,null,6]
//输出：[1,null,2,null,3,null,4,null,5,null,6]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 树中结点数在范围 [0, 2000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？ 
// Related Topics 栈 树 深度优先搜索 链表 二叉树 👍 1328 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        Solution solution = new FlattenBinaryTreeToLinkedList().new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode five = new TreeNode(5);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode six = new TreeNode(6);


        root.left = two;
        root.right = five;
        two.left = three;
        two.right = four;
        five.right = six;


    }
    //leetcode submit region begin(Prohibit modification and deletion)

    public static class TreeNode {
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
        public void flatten(TreeNode root) {
            List<TreeNode> list = new ArrayList<>();
            print(root, list);
            for (int i = 1; i < list.size(); i++) {
                TreeNode pre = list.get(i - 1);
                TreeNode cur = list.get(i);
                pre.left = null;
                pre.right = cur;
            }
        }

        public void print(TreeNode root, List<TreeNode> list) {
            if (root != null) {
                return;
            }
            list.add(root);
            list.add(root.left);
            list.add(root.right);
        }


        //迭代方式实现
        public void flattenByIterate(TreeNode root) {
            List<TreeNode> list=new ArrayList<>();
            Stack<TreeNode> stack=new Stack<>();
            while (root!=null||!stack.isEmpty()){
                if (root==null){
                    root=stack.pop();
                    root=root.right;
                    continue;
                }
                list.add(root);
                stack.push(root);
                root=root.left;
            }

            for (int i = 1; i < list.size(); i++) {
                TreeNode pre = list.get(i - 1);
                TreeNode cur = list.get(i);
                pre.left = null;
                pre.right = cur;
            }
        }


//leetcode submit region end(Prohibit modification and deletion)

    }
}
