package leetcode.editor.cn.dataStruct;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BinaryTree {

    public static void main(String[] args) {
        LinkedList<Integer> list=new LinkedList<>(Arrays.asList(3,2,9,null,null,10,null, null,8,null,4));

        TreeNode binaryTree = createBinaryTree(list);
        //System.out.println(binaryTree);
        
        preOrderTraveral(binaryTree);
        
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
    
    
}
