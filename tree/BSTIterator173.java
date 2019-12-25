public class BSTIterator173{
 
    public static void main(String[] args) {

    }

    Stack<TreeNode> stack=new Stack<>();

    public BSTIterator(TreeNode root) {
        pushLeft(root);
    }
    
    public int next() {
        TreeNode node=stack.pop();
        if (node.right!=null) {
            pushLeft(node.right);
        }
        return node.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public void pushLeft(TreeNode node){
        while(node!=null){
            stack.add(node);
            node=node.left;
        }
    }
}