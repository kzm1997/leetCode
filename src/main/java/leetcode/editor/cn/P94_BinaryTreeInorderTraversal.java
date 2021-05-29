//给定一个二叉树的根节点 root ，返回它的 中序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
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
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[2,1]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表 
// 👍 955 👎 0


package leetcode.editor.cn;

//二叉树的中序遍历

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P94_BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P94_BinaryTreeInorderTraversal().new Solution();
    }
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)


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
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> resultList=new LinkedList<Integer>();
            if (root!=null){
                resultList.addAll(inorderTraversal(root.left));
                resultList.add(root.val);
                resultList.addAll(inorderTraversal(root.right));
            }
            return  resultList;
        }

        public List<Integer> inorderTraversalIteration(TreeNode root) {
           List<Integer> resultList=new ArrayList<>();
            LinkedList<TreeNode> stack=new LinkedList<>();
            while (root!=null||!stack.isEmpty()){
                if (root!=null){
                    stack.push(root);
                    root=root.left;
                }else{
                    root=stack.pop();
                    resultList.add(root.val);
                    root=root.right;
                }
            }
            return resultList;
        }

    }

//leetcode submit region end(Prohibit modification and deletion)

}