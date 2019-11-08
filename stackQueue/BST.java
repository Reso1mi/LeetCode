public class BST<E extends Comparable<E>>{

    //TreeNode
    private class Node{
        public E e;
        public Node left;
        public Node right;
        public Node(E e){
            this.e=e;
            left=null;
            right=null;
        }
    }

    private Node root;

    private int size;

    public BST(){
        root=null;
        size=0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }


    public void addLoop(E e){
        if (root==null) {
            size++;
            root=new Node(e);
            return;
        }
        Node temp=root;
        while(temp!=null){
            if (e.compareTo(temp.e)>0) {
                if (temp.right==null) {
                    temp.right=new Node(e);
                    size++;
                    return;
                }
                temp=temp.right;
            }else if (e.compareTo(temp.e)<0) {
                if (temp.left==null) {
                    temp.left=new Node(e);
                    size++;
                    return;
                }
                temp=temp.left;
            }else return; //不能有相等元素
        }
    }

    //简洁的方式add
    public void add(E e){
        root=add(root,e);
    }

    //add元素后返回新的根节点
    private Node add(Node node, E e){
        if (node == null) {
            size++;
            return new Node(e);
        }
        if(e.compareTo(node.e) < 0){
            node.left=add(node.left, e);
        }else if (e.compareTo(node.e) > 0) {
            node.right=add(node.right, e);   
        }
        return node;
    }

    public boolean contains(E e){
        if (e==null) {
            return false;
        }
        return contains(e,root);
    }

    private boolean contains(E e,Node root){
        if (root==null) {
            return false;
        }
        if (e.compareTo(root.e)==0) {
            return true;
        }
        return e.compareTo(root.e)<0?contains(e,root.left):contains(e,root.right);
    }

    // 向二分搜索树中添加新的元素e
    public void add2(E e){
        if(root == null){
            root = new Node(e);
            size ++;
        }
        else
            add(root, e);
    }

    // 向以node为根的二分搜索树中插入元素e，递归算法,略显繁琐
    private void add2(Node node, E e){
        if(e.equals(node.e)) return;

        if(e.compareTo(node.e) < 0 && node.left == null){
            node.left = new Node(e);
            size ++;
            return;
        }

        if(e.compareTo(node.e) > 0 && node.right == null){
            node.right = new Node(e);
            size ++;
            return;
        }

        if(e.compareTo(node.e) < 0)
            add(node.left, e);
        else //e.compareTo(node.e) > 0
        add(node.right, e);
    }
}