public class TreeToDoublyListJZ36{
    public static void main(String[] args) {
        
    }

    public Node treeToDoublyList(Node root) {
        if(root==null) return root;
        dfs(root);
        head.left=lastNode;
        lastNode.right=head;
        return head;
    }

    Node lastNode,head=null;

    public void dfs(Node root){
        if(root==null) return;
        dfs(root.left);
        if(lastNode==null){
            head=lastNode=root;
        }else{
            root.left=lastNode;
            lastNode.right=root;
            lastNode=root;
        }
        dfs(root.right);
    }
}