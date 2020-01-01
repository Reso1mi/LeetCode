public class ConvertBST538{
    public static void main(String[] args) {

    }


    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    private int sum=0;

    public void dfs(TreeNode root){
        if (root==null) {
            return;
        }
        dfs(root.right);
        sum+=root.val;
        root.val=sum;
        dfs(root.left);
    }

    /* Wrong Answer
    public TreeNode convertBST(TreeNode root) {
        if (root==null) {
            //return new TreeNode(0);
            return null;
        }
        if (root.left==null && root.right==null) {
            return root;
        }
        root.val+= convertBST(root.right).val;
        convertBST(root.left).val+=root.val;
        return root;
    }

    public int convert(TreeNode root){
        if (root==null) {
            return 0;
        }
        if (root.left==null && root.right==null) {
            return root.val;
        }
        root.val+=convert(root.right);
        root.left.val+=convert(root.left);
        return root.val;
    }

    public TreeNode convertBST(TreeNode root) {
        if (root==null) {
            return new TreeNode(0);
        }
        if (root.left==null && root.right==null) {
            return root;
        }
        root.val+=convertBST(root.right).val;
        root.left.val+=root.val;
        convertBST(root.left);
        return root;
    }*/
}