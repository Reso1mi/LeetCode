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

    public Node root;

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
            if ((cur.left==null && cur.right ==null) || (lastNode!=null &&(cur.left==lastNode || cur.right==lastNode))){
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

    //层次遍历,这种写法更加通用,一次确定一层,后面很多题目都可以用这个模板
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

    //求最大值,递归比较优雅
    public E getMax(){
        return getMax(root).e;
    }

    public Node getMax(Node root){
        if (root.right==null) {
            return root;
        }
        return getMax(root.right);
    }

        //求最小值
    public E getMin(){
        return getMin(root).e;
    }

    public Node getMin(Node root){
        if (root.left==null) {
            return root;
        }
        return getMin(root.left);
    }

    //floor向下取整,小于等于e的最大元素
    public E floor(E e){
        //没有做校验,会有NPE
        Node node=floor(root,e);
        return node!=null?node.e:null;
    }

    public Node floor(Node root,E e){
        if (root==null) {
            return null;
        }
        int temp=e.compareTo(root.e);
        if (temp==0) {
            return root;
        }
        if (temp<0) { //root.e > e,求小于e的值,一定在左边
            return floor(root.left,e);
        }
        //tmep>0 e>root.e
        Node node=floor(root.right,e);
        return node!=null?node:root;
    }

    //向上取整,大于等于e的最小元素
    public E ceiling(E e){
        Node node=ceiling(root,e);
        return node!=null?node.e:null;
    }

    public Node ceiling(Node root,E e){
        if (root==null) {
            return null;
        }
        int temp=e.compareTo(root.e);
        if (temp==0) {
            return root;
        }
        if (temp>0) { //root.e<e,求的是最后大于root.e的元素,一定在右边
            return ceiling(root.right,e);
        }
        //tmep<0 e<root.e
        Node node=ceiling(root.left,e);
        return node!=null?node:root;
    }

    //获取第k大的元素,时间复杂度应该是N*logN,并不好,但是我也懒得改了😁
    //其实这里应该在Node上加一个子节点的个数的属性,添加删除的时候顺便维护下就ok,《算法》上就是这样实现的,有兴趣可以去看看
    //这样就可以直接获取子节点的个数,不用遍历整棵子树求节点数,时间复杂度O(logN),我为了不影响整体就懒得改了
    //所以下面的只是为了体现一种思想,这里最好的做法其实是直接中序遍历求第k个就ok
    public E getKth(int k){
        if (k>=size || k<0) {
            return null;
        }
        return getKth(root,k).e;
    }

    public Node getKth(Node root,int k){
        if (root==null) {
            return root;
        }
        int temp = childSize(root.left);
        if (temp>k) {
            return getKth(root.left,k);
        }
        if (temp<k) {
            return getKth(root.right,k-temp-1);
        }
        return root;
    }

    public int childSize(Node node){
        if (node==null) {
            return 0;
        }
        return childSize(node.left)+childSize(node.right)+1;
    }

    //获取键所在的排位
    public int getRank(E e){
        return getRank(root,e);
    }

    public int getRank(Node root,E e){
        if (e.compareTo(root.e)<0) { //e<root.e
            return getRank(root.left,e);
        }
        if (e.compareTo(root.e)>0) {
            return getRank(root.right,e)+childSize(root.left)+1;
        }
        return childSize(root.left);
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
        return "\n";
    }
}