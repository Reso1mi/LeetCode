public class LeafSimilar872{
    public static void main(String[] args) {

    }

    //没啥好说的
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1==null || root2==null) return false;
        return dfs(root1).equals(dfs(root2));
    }
    
    public String dfs(TreeNode root){
        if(root==null){
            return "";
        }
        if(root.left==null && root.right==null){
            return "#"+root.val;
        }
        return dfs(root.left)+dfs(root.right);
    }
}
