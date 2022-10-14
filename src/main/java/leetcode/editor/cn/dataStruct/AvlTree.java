package leetcode.editor.cn.dataStruct;


import java.util.UnknownFormatConversionException;

public class AvlTree {

    
    private TreeNode root;


    public static void main(String[] args) {
        AvlTree avlTree=new AvlTree();
        avlTree.insert(10);
        avlTree.insert(6);
        avlTree.insert(12);
        avlTree.insert(11);
        avlTree.insert(14);
        avlTree.insert(4);
        avlTree.insert(8);
        avlTree.insert(3);
        avlTree.insert(5);
        avlTree.insert(2);
        
  
        System.out.println(avlTree);
    }
    

    static class TreeNode {

        private int value;

        private Object data;

        private int height;

        private transient TreeNode parent;

        private TreeNode left;

        private TreeNode right;

        public TreeNode(int value, Object data) {
            this.value = value;
            this.data = data;
        }
    }
    
    
    
    public void insert(int value){
        insert(value,value);
    }
    
    
    public void insert(int value,Object data){
        TreeNode newNode=new TreeNode(value,data);
        if (root==null){
            root=newNode;
            return;
        }
        
        TreeNode temp=root;
        
        while (true){
            
            if (newNode.value<temp.value){
                if (temp.left==null){
                    //左子节点为空,插入,否则继续往下找
                    temp.left=newNode;
                    newNode.parent=temp;
                    break;
                }else {
                    temp=temp.left;
                }
            }else if (newNode.value>temp.value){
                if (temp.right==null){
                    temp.right=newNode;
                    newNode.parent=temp;
                    break;
                }else {
                    temp=temp.right;
                }
            }else {
                break;
            }
            
        }
        
        //平衡二叉树
        avlNode(newNode);
    }

    private void avlNode(TreeNode node) {

        /*
           从当前节点开始，循环向上找父节点，是否需要左旋右旋来平衡
         */
        while (node != null) {

            // 左树高 = 左子节点的高节+1
            int leftHeight = node.left == null ? 0 : node.left.height + 1;
            // 右树高 = 右子节点的高+1
            int rightHeight = node.right == null ? 0 : node.right.height + 1;
            // 平衡因子，左右树高相差：2，需要旋转
            int factor = leftHeight - rightHeight;

            if (factor == 2) {// 左树比有高
                TreeNode left = node.left;
                // L子节点的L子节点高
                int leftLeftHeight = left.left == null ? 0 : left.left.height + 1;
                // L子节点的R子节点高
                int leftRightHeight = left.right == null ? 0 : left.right.height + 1;
                if (leftLeftHeight >= leftRightHeight) {
                    // RR ： L子节点的L子节点 >= L子节点的R子节点  --> 右旋
                    rightRotate(node);
                }else {
                    // LR 否则左右旋
                    leftRightRotate(node);

                }

            }else if(factor==-2) {// 右树比左树高
                TreeNode right = node.right;
                // R子节点的R子节点高
                int rightRightHeight = right.right == null ? 0 : right.right.height + 1;
                // R子节点的L子节点高
                int rightLeftHeight = right.left == null ? 0 : right.left.height + 1;
                if (rightRightHeight >= rightLeftHeight){
                    // LL ：R子节点的R子节点 >= R子节点的L子节点 --> 左旋
                    leftRotate(node);
                }else {
                    // RL 否则右左旋
                    rightLeftRotate(node);
                }
            }
            // 重新节点高度
            calcHeight(node);

            if (node.parent == null) {
                this.root = node;
            }
            node = node.parent;
        }
    }





    /**
     * 右旋
     * @param node 被旋转的节点，及当前节点
     * @return 当前节点
     */
    private TreeNode rightRotate(TreeNode node) {
        // 当前节点的右子节点
        TreeNode left = node.left;
        // 原左子节点的右子节点 替换到 当前节点的左子节点
        replaceParentLeft(left.right,node);

        /*
         * 当前节点和原左子节点，更换父子关系。
         * 当前节点成为原左儿子的右儿子，原左儿子成当前节点的父亲
         */
        // 当前节点的左子节点父节点 更换成 当前节点父节点
        replaceSubNode(left,node.parent);

        // 当前节点的原左子节点 替换成 当前节点的父节点，原左子节点的右子节点 更换成 当前节点
        replaceParentRight(node, left);
        return node;
    }


    /**
     * 左旋
     * @param node 被选转的的节点，及当前节点
     * @return 当前节点
     */
    private TreeNode leftRotate(TreeNode node) {
        // 当前节点的右子节点
        TreeNode right = node.right;
        // 原右子节点的左子节点 替换到 当前节点的右子节点
        replaceParentRight(right.left,node);

        /*
         * 当前节点和原右子节点，更换父子关系。
         * 当前节点成为原右儿子的左儿子，原右儿子成当前节点的父亲
         */
        // 当前节点的右子节点父节点 更换成 当前节点父节点，
        replaceSubNode(right,node.parent);
        // 当前节点的原右子节点 更换成 当前节点的父节点，原右子节点的左子节点 更换成 当前节点
        replaceParentLeft(node, right);
        return node;
    }



    /**
     * 左右旋
     * 先左子节点左旋，再当前节点右旋
     * @param node 当前节点
     */
    private void leftRightRotate(TreeNode node) {
        // 最低不平衡节点的左子节点左旋
        TreeNode currentNode = leftRotate(node.left);
        // 重新计算有左子节点树高
        calcHeight(currentNode);
        // 最低不平衡节点右旋
        rightRotate(node);
    }

    /**
     * 右左旋
     * 先右子节点右旋，再当前节点左旋
     * @param node 当前节点
     */
    private void rightLeftRotate(TreeNode node) {
        // 最低不平衡节点的右子节点右旋
        TreeNode currentNode = rightRotate(node.right);
        // 重新计算右子节点树高
        calcHeight(currentNode);
        // 最低不平衡节点左旋
        leftRotate(node);
    }
    
    

    /**
     * 此父节点的右子节点更换成此子节点
     * 已知是替换父节点的右子节点
     * @param subNode 子节点 可为空
     * @param parentNode 父节点 可为空
     */
    private void replaceParentRight(TreeNode subNode, TreeNode parentNode) {
        if (parentNode!=null) {
            parentNode.right = subNode;
        }
        if (subNode != null) {
            subNode.parent = parentNode;
        }
    }

    /**
     * 父节点的左子节点被原左子节点的右子节点取代
     * @param subNode
     * @param parentNode
     */
    private void replaceParentLeft(TreeNode subNode,TreeNode parentNode){
        if (parentNode!=null){
            parentNode.left=subNode;
        }
        if (subNode!=null){
            subNode.parent=parentNode;
        }
    }

    /**
     * 
     * @param subNode
     * @param parentNode
     */
    private void replaceSubNode(TreeNode subNode,TreeNode parentNode){
        if (subNode==null){
            return;
        }
        subNode.parent=parentNode;
        if (parentNode!=null) {
            // 子节点比父节点小，子节点在是父节点则左子树，父节点的左子节点替换成新的子节点
            if (subNode.value < parentNode.value) {
                parentNode.left = subNode;
            } else {
                // 子节点比父节点大，子节点在是父节点则右子树，父节点的右子节点替换成新的子节点
                parentNode.right = subNode;
            }
        }
    }



    /**
     * 打印树状结构
     */
    public void print() {
        if (root.right != null) {
            printTree(root.right, true, "");
        }
        printNodeValue(root);
        if (root.left != null) {
            printTree(root.left, false, "");
        }
        System.out.println();
        System.out.println();
    }

    private void printNodeValue(TreeNode node) {
        System.out.print(node.value);
        System.out.println();
    }

    private void printTree(TreeNode node, boolean isRight, String indent) {
        if (node.right != null) {
            printTree(node.right, true, indent + (isRight ? "        " : " |      "));
        }
        System.out.print(indent);
        if (isRight) {
            System.out.print(" /");
        } else {
            System.out.print(" \\");
        }
        System.out.print("----- ");
        printNodeValue(node);
        if (node.left != null) {
            printTree(node.left, false, indent + (isRight ? " |      " : "        "));
        }
    }
    
    
    
    
    

    /**
     * 计算节点的高度
     *
     * @param node
     */
    private void calcHeight(TreeNode node) {
        int leftHeight = node.left == null ? 0 : node.left.height + 1;
        int rightHeight = node.right == null ? 0 : node.right.height + 1;
        node.height=Math.max(leftHeight,rightHeight);
    }
}


