package leetcode.editor.cn.dataStruct;


public class BST<Key extends Comparable<Key>, Value> {

    private Node root;

    private class Node {
        private Key key; //健
        private Value val; //值
        private Node left, right; //指向子树的链接
        private int N;  //以该节点为根的子树中节点总数

        public Node(Key key, Value val, int n) {
            this.key = key;
            this.val = val;
            N = n;
        }
    }


    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {

        if (x == null) return null;
        int cmp = key.compareTo(x.key);

        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x.val;
    }

    public void put(Key key, Value val) {

    }

    private Node put(Node x, Key key, Value value) {
        if (x == null) return new Node(key, value, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, value);
        else if (cmp > 0) x.right = put(x.left, key, value);
        else x.val = value;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public int size() {
        return size(root);
    }

    public int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }
    
    
    public Key min(){
        return min(root).key;
    }
    
    private Node min(Node x){
        if (x.left==null)return x;
        return min(x.left);
    }
    
    public Key floor(Key key){
        Node x=floor(root,key);
        if (x==null) return null;
        return x.key;
    }
    
    private Node floor(Node x,Key key){
        if (x==null) return null;
        int cmp=key.compareTo(x.key);
        if (cmp==0) return x;
        if (cmp<0) return floor(x.left,key);
        Node t=floor(x.right,key);
        if (t!=null) return t;
        else return x;
    }
    
    public Key select(int k){
        return select(root,k).key;
    }
    
    private Node select(Node x,int k){
        //返回排名为k的节点
        if (x==null)return null;
        int t=size(x.left);
        if (t>k) return select(x.left,k);
        else if (t<k) return select(x.right,k-t-1);
        else return x;
    }
    
    
    
    
    
    
    

}
