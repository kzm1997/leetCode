package leetcode.editor.cn.dataStruct;



public class AvlTree {

    
    private TreeNode root;


    public static void main(String[] args) {
        AvlTree avlTree=new AvlTree();
        avlTree.insert(55);
        avlTree.insert(30);
        avlTree.insert(90);
        avlTree.insert(12);
        avlTree.insert(36);
        avlTree.insert(60);
        avlTree.insert(100);
        avlTree.insert(32);
        avlTree.insert(39);
        avlTree.insert(31);
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
        
    }
    
    private void avlNode(TreeNode node){
        
        while (node!=null){
            
            int leftHeight=node.left==null?0:node.left.height+1;
            int rightHeight=node.right==null?0:node.right.height+1;
            
            int factor=leftHeight-rightHeight;
            
            if (factor==2){
                //左树比右树高
            }else if (factor==-2){
                //右树比左树高
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
        node.height=Math.max(leftHeight,rightHeight)+1;
    }
}


