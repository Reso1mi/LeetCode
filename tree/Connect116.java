public class Connect116{
    public static void main(String[] args) {

    }

    //差一点就写出来了
    public Node connect(Node root) {
        if (root ==null ||root.left==null) {
            return root;
        }
        root.left.next=root.right;
        if (root.next!=null) {
            root.right.next=root.next.left;   
        }
        connect(root.left);
        connect(root.right);
        return root;
    }

    //另一种思路
    public Node connect(Node root) {
        if (root ==null ||root.left==null) {
            return root;
        }
        Node left=root.left;
        Node right=root.right;
        //有的像拉拉链的过程
        while(left!=null){
            left.next=right;
            left=left.right;
            right=right.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}