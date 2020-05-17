public class GoodNodes5398{
    public static void main(String[] args) {
        
    }

    int count=0;
    
    public int goodNodes(TreeNode root) {
        if(root==null) return 0;
        dfs(root,root.val);
        return count;
    }
    
    public void dfs(TreeNode root,int max){
        if(root==null){
            return;
        }
        if(max<=root.val){
            count++;
            max=root.val;
        }
        dfs(root.left,max);
        dfs(root.right,max);
    }
}