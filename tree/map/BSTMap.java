public class BSTMap<K extends Comparable,V> implements Map<K,V>{

    private class Node{
        public K key;
        public V value;
        public Node left;
        public Node right;
        public Node(K key,V value){
            this.key=key;
            this.value=value;
            left=null;
            right=null;
        }
    }  

    public Node root;

    private int size;

    public BSTMap(){
        root=null;
        size=0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void put(K key,V value){
        root=put(root,key,value);
    }

    //add元素后返回新的根节点
    private Node put(Node node,K key,V value){
        if (node == null) {
            size++;
            return new Node(key,value);
        }
        if(key.compareTo(node.key) < 0){
            node.left=put(node.left, key,value);
        }else if (key.compareTo(node.key) > 0) {
            node.right=put(node.right, key,value);   
        }else{
            //相等的情况
            node.value=value;
        }
        return node;
    }

    private Node getNode(Node node,K key){
        if (node==null) {
            return null;
        }
        int temp=node.key.compareTo(key);
        if (temp==0) {
            return node;
        }
        if (temp>0) { //node.key > key
            return getNode(node.left,key);
        }
        return getNode(node.right,key);
    }

    public boolean contains(K key){
        return getNode(root,key)!=null;
    }

    public V get(K key){
        Node node=getNode(root,key);
        return node==null?null:node.value;
    }

    public void set(K key,V newValue){
        Node node=getNode(root,key);
        if (node!=null) {
            node.value=newValue;
            return;
        }
        throw new IllegalArgumentException(key+ " doesn't exist");
    }

    private Node getMin(Node root){
        if (root.left==null) {
            return root;
        }
        return getMin(root.left);
    }

    private Node deleteMin(Node node){
        if (node.left==null) {
            return node.right;
        }
        node.left=deleteMin(node.left);
        return node;
    }

    public V remove(K key){
        Node node=getNode(root,key);
        if (node==null) {
            return null;
        }
        root=remove(node,key);
        size--;
        return node.value;
    }

    public Node remove(Node root,K key){
        if (key.compareTo(root.key)>0) { //key > root
            root.right=remove(root.right,key);
        }else if (key.compareTo(root.key)<0) {
            root.left=remove(root.left,key);
        }else{
            if (root.left==null) {
                return root.right;
            }
            if (root.right==null) {
                return root.left;
            }
            Node deleNode=root;
            root=getMin(root.right);
            root.right=deleteMin(deleNode.right);
            root.left=deleNode.left;
        }
        return root;
    }
}