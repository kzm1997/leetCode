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

    public BST(Key rootKey, Value rootValue) {
        Node root = new Node(rootKey, rootValue, 0);
        this.root = root;
    }

    public static void main(String[] args) {
        BST<Integer, Integer> bst = new BST<>(55, 55);
        bst.put(30, 30);
        bst.put(90, 90);
        bst.put(12, 12);
        bst.put(36, 36);
        bst.put(32, 32);
        bst.put(31, 31);
        bst.put(39, 39);
        bst.put(60, 60);
        bst.put(100, 100);

/*        System.out.println(bst);

        System.out.println(bst.get(60));

        System.out.println(bst.min());

        System.out.println(bst.floor(100));*/

        System.out.println(bst.select(3));

        BST.Node node = (BST.Node) bst.deleteBySelf(30);
        System.out.println(node);
        bst.delete(30);

        System.out.println(bst);
      
        
        
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
        put(root, key, val);
    }

    private Node put(Node x, Key key, Value value) {
        if (x == null) return new Node(key, value, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, value);
        else if (cmp > 0) x.right = put(x.right, key, value);
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


    public Key min() {
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }

    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) return null;
        return x.key;
    }

    private Node floor(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) return floor(x.left, key);
        Node t = floor(x.right, key);
        if (t != null) return t;
        else return x;
    }

    public Key select(int k) {
        return select(root, k).key;
    }

    private Node select(Node x, int k) {
        //返回排名为k的节点
        if (x == null) return null;
        int t = size(x.left);
        if (t > k) return select(x.left, k);
        else if (t < k) return select(x.right, k - t - 1); //-1是去除根节点
        else return x;
    }

    private Node delete(Node x, Key key) {

        if (x == null) return null;

        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }


    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }


    public void delete(Key key) {
        root = delete(root, key);
    }
    
    public Node deleteBySelf(Key key){
      return   deleteBySelf(root,key);
    }
    
    


    public Node deleteBySelf(Node x, Key key) {
        if (x == null) {
            return null;
        }
        
        if (x.key.compareTo(key) == 0) {
            
            if (x.left==null&&x.right==null){
                return null;
            }
            if (x.left == null && x.right != null) {
                return x.right;
            }
            if (x.right == null && x.left != null) {
                return x.left; 
            }
            if (x.left != null && x.right != null) {
               //定义一个current节点
                Node current=x.right;
                while (current.left!=null){
                     current=current.left;
                }
                current.left=x.left;
                x=x.right;
                return x;
            }
            
        } else if (x.key.compareTo(key) > 0) {
            x.left = deleteBySelf(x.left, key);
        } else if (x.key.compareTo(key) < 0) {
            x.right = deleteBySelf(x.right, key);
        }
        return x;
    }
    
    
    


}
