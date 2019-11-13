public class InsertIntoBST701{
    public static void main(String[] args) {

    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root==null) {
            return new TreeNode(val);
        }
        if (root.val>val) {
            root.left=insertIntoBST(root.left,val);   
        }else if (root.val<val) {
            root.right=insertIntoBST(root.right,val);   
        }
        return root;
    }
}