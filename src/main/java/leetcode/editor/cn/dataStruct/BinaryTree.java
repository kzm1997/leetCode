package leetcode.editor.cn.dataStruct;

import javax.xml.soap.Node;
import java.util.*;

public class BinaryTree {

    public static void main(String[] args) {
        LinkedList<Integer> list=new LinkedList<>(Arrays.asList(3,2,9,null,null,10,null, null,8,null,4));

        TreeNode binaryTree = createBinaryTree(list);
        //System.out.println(binaryTree);
        
        preOrderTraveral(binaryTree);

        System.out.println("---------------");
        
        preOrderTeravelByStack(binaryTree);
        
        
        
    }


    static class TreeNode {
        Integer value;
        TreeNode leftChild;
        TreeNode rightChild;

        public TreeNode(Integer value) {
            this.value = value;
        }
    }

    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;

        if (inputList == null || inputList.isEmpty()) {
            return null;
        }

        Integer data = inputList.removeFirst();
        
        if (data!=null){
            node=new TreeNode(data);
            node.leftChild=createBinaryTree(inputList);
            node.rightChild=createBinaryTree(inputList);
        }
        return node;
    }
    
    
    public static void  preOrderTraveral(TreeNode node){
        if (node==null){
            return;
        }
        System.out.println(node.value);
        preOrderTraveral(node.leftChild);
        preOrderTraveral(node.rightChild);
    }
    
    public static void inOrderTraveral(TreeNode node){
        if (node==null){
            return;
        }
        inOrderTraveral(node.leftChild);
        System.out.println(node.value);
        inOrderTraveral(node.rightChild);
    }
    
    public static void postOrderTravel(TreeNode node){
        if (node==null){
            postOrderTravel(node.leftChild);
            postOrderTravel(node.rightChild);
            System.out.println(node.value);
        }
    }

    /**
     * 通过栈实现前序遍历
     * //什么时候进栈,什么时候出栈?
     * //循环条件是什么
     * 
     * @param node
     */
    public static void  preOrderTeravelByStack(TreeNode node){
        Stack<TreeNode> stack=new Stack<>();
        
        while (node!=null||!stack.isEmpty()){
            if (node==null){
                TreeNode root=stack.pop();
                node=root.rightChild;
                continue;
            }
            System.out.println(node.value);
            stack.push(node);
            node=node.leftChild;
            
        }
    }

    /**
     * 通过栈实现中序遍历
     * @param node
     */
    public static void inOrderTeravelByStack(TreeNode node){
        Stack<TreeNode> stack=new Stack<>();
        
        while (node!=null||!stack.isEmpty()){
              if (node!=null){
                  node=node.leftChild;
                  
              }else {
                  
              }
        }
    }    
}
