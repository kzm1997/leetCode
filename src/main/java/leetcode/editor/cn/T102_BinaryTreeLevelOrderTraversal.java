//给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[9,20],[15,7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 广度优先搜索 二叉树 👍 1482 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.dataStruct.BinaryTree;

import java.util.*;

//Java：二叉树的层序遍历
public class T102_BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new T102_BinaryTreeLevelOrderTraversal().new Solution();

        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(3, 2, 9, null, null, 10, null, null, 8, null, 4));

        TreeNode binaryTree = createBinaryTree(list);

        // TO TEST
        List<List<Integer>> lists = solution.levelOrder(binaryTree);

        System.out.println(lists);
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

    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;

        if (inputList == null || inputList.isEmpty()) {
            return null;
        }

        Integer data = inputList.removeFirst();

        if (data != null) {
            node = new TreeNode(data);
            node.left = createBinaryTree(inputList);
            node.right = createBinaryTree(inputList);
        }
        return node;
    }

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
         
            Queue<TreeNode> queue = new ArrayDeque<>();

            Map<TreeNode, Integer> map = new LinkedHashMap<>();

            if (root == null) {
                return null;
            }
            queue.add(root);
            map.put(root, 0);
            int size = 0;
            while (!queue.isEmpty()) {
                TreeNode poll = queue.poll();
                System.out.println(poll.val);
                if (poll.left != null) {
                    map.put(poll.left, map.get(poll) + 1);
                    size= map.get(poll) + 1;
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    map.put(poll.right, map.get(poll) + 1);
                    size= map.get(poll) + 1;
                    queue.add(poll.right);
                }
            }
            List<List<Integer>> res = new ArrayList<>(size);

            for (int i = 0; i <= size; i++) {
                res.add(new LinkedList<>());
            }
            for (Map.Entry<TreeNode, Integer> entry : map.entrySet()) {
                Integer value = entry.getValue();
                List<Integer> integers = res.get(value);
                integers.add(entry.getKey().val);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
