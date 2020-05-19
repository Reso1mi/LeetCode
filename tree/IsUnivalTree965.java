public class IsUnivalTree965{
    public static void main(String[] args) {

    }

    public boolean isUnivalTree(TreeNode root) {
        if(root==null || (root.left==null && root.right==null)){
            return true;
        }
        if(root.left==null && root.right!=null){
            return root.val==root.right.val && isUnivalTree(root.right); 
        }
        if(root.right==null && root.left!=null){
            return root.val==root.left.val && isUnivalTree(root.left); 
        }
        return root.val==root.left.val && root.val==root.right.val && isUnivalTree(root.left) && isUnivalTree(root.right);
    }

    public boolean isUnivalTree(TreeNode root) {
        return dfs(root,root.val);
    }

    public boolean dfs(TreeNode root,int val){
        if(root==null) return true;
        return root.val==val && dfs(root.left,val) && dfs(root.right,val);
    }
}