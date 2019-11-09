public class IsValidBST98{
    public static void main(String[] args) {

    }

    public boolean isValidBST(TreeNode root) {
        if (root==null) {
            return true;
        }
        return isValidBST(root,null,null);
    }

    public boolean isValidBST(TreeNode node,Integer low,Integer high){
        if (node==null) return true;
        if (low!=null && low>=node.val || high!=null && high<=node.val) {
            return false;
        }
        return isValidBST(node.left,low,node.val) && isValidBST(node.right,node.val,high);
    }

    //BST的中序遍历一定是升序的
    public boolean isValidBST(TreeNode root){
        LinkedList<Integer> order=new LinkedList<>();
        if (root==null) {
            return true;
        }
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        while(cur!=null || !stack.isEmpty()){
            while(cur!=null){
                stack.add(cur);
                cur=cur.left;
            }
            cur=stack.pop();
            if (!order.isEmpty() && order.getLast()>= cur.val) {
                return false;
            }
            order.add(cur.val);
            cur=cur.right;
        }
        return true;
    }
}