public class LowestCommonAncestor236{
    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p==root ||q==root) {
            return root;
        }
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if (left!=null && right!=null) {
            return root;
        }else if (left!=null) {
            return left;
        }else if (right!=null) {
            return right;
        }
        return null;
    }
}
