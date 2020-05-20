public class Connect117{
    public static void main(String[] args) {
        
    }

    public Node connect(Node root) {
        Node dummyNode=new Node(-1);
        Node cur=root;
        //cur在上层，dummyNode和tail在下层，tail负责连接下层所有子节点
        while(cur!=null){
            dummyNode.next=null; //重置
            Node tail=dummyNode;
            while(cur!=null){
                if(cur.left!=null){
                    tail.next=cur.left;
                    tail=tail.next;
                }
                if(cur.right!=null){
                    tail.next=cur.right;
                    tail=tail.next;
                }
                cur=cur.next;
            }
            cur=dummyNode.next; //cur转换到下一层
        }
        return root;
    }
}