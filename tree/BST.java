import java.util.*;
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

    //非递归add
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

    //查询操作
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

    //前序遍历,递归
    public void preorderTravelRecur(){
        preorderTravel(root);
    }

    private void preorderTravel(Node root){
        if (root==null) {
            return;
        }
        System.out.print(root.e+" ");
        preorderTravel(root.left);
        preorderTravel(root.right);
    }

    //前序遍历,非递归实现
    public void preorderTravelNoRecur(){
        Stack<Node> stack=new Stack<>();
        Node cur=root;
        while( cur!=null || !stack.isEmpty()){
            while(cur!=null){
                System.out.print(cur.e+" ");
                stack.push(cur);
                cur=cur.left;
            }
            cur=stack.pop();
            cur=cur.right;
        }
    }

    //中序遍历,递归
    public void inorderTravelRecur(){
        inorderTravel(root);
    }

    private void inorderTravel(Node root){
        if (root==null) {
            return;
        }
        inorderTravel(root.left);
        System.out.print(root.e+" ");
        inorderTravel(root.right);
    }

    //中序遍历,非递归
    public void inorderTravelNoRecur(){
        Stack<Node> stack=new Stack<>();
        Node cur=root;
        while( cur!=null || !stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            cur=stack.pop();
            System.out.print(cur.e+" ");
            cur=cur.right;
        }
    }

    //后序遍历,递归
    public void postorderTravelRecur(){
        postorderTravel(root);
    }

    private void postorderTravel(Node root){
        if (root==null) {
            return;
        }
        postorderTravel(root.left);
        postorderTravel(root.right);
        System.out.print(root.e+" ");
    }
    
    //后序遍历,非递归
    public void postorderTravelNoRecur(){
        Stack<Node> stack=new Stack<>();
        Node cur=root,lastNode=null;
        while(cur!=null || !stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            cur=stack.peek();
            if (cur.right==null || lastNode==cur.right) {
                System.out.print(cur.e+" ");
                stack.pop();
                lastNode=cur;
                cur=null;
            }else{
                cur=cur.right;
            }
        }
    }

    //经典后序遍历
    public void postorderTravelNoRecur2() {
        Stack<Node> stack=new Stack<>();
        stack.push(root);
        Node lastNode=null;
        while(!stack.isEmpty()){
            Node cur=stack.peek();
            if ((cur.left==null && cur.right ==null) || 
                (lastNode!=null &&(cur.left==lastNode || cur.right==lastNode))){
                stack.pop();
                System.out.print(cur.e+" ");
                lastNode=cur;
            }else{
                if (cur.right!=null) {
                    stack.push(cur.right);
                } if (cur.left!=null) {
                    stack.push(cur.left);
                }  
            } 
        }
    }

    //层次遍历
    public void levelorderTravel(){
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int count=queue.size();
            while(count>0){
                Node node=queue.poll();
                System.out.print(node.e+" ");
                if (node.left!=null) {
                    queue.add(node.left);
                }
                if (node.right!=null) {
                    queue.add(node.right);
                }
                count--;
            }
        }
    }

    @Override
    public String toString(){
        System.out.println("递归前序：");
        preorderTravelRecur();
        System.out.println("\n非递归前序：");
        preorderTravelNoRecur();
        System.out.println("\n递归中序：");
        inorderTravelRecur();
        System.out.println("\n非递归中序：");
        inorderTravelNoRecur();
        System.out.println("\n递归后序：");
        postorderTravelRecur();
        System.out.println("\n非递归后序");
        postorderTravelNoRecur();
        System.out.println("\n层序遍历");
        levelorderTravel();
        return "\n-------------------------";
    }
}