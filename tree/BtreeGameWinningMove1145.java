public class BtreeGameWinningMove1145{
    public static void main(String[] args) {
        
    }

    int max=0;
    
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        dfs(root,x,n);
        return max>n-max;
    }
    
    public int dfs(TreeNode root,int x,int n){
        if(root==null) return 0;
        int left=dfs(root.left,x,n);
        int right=dfs(root.right,x,n);
        if(root.val==x){
            max=Math.max(left,max);
            max=Math.max(right,max);
            max=Math.max(n-left-right-1,max);
        }
        return left+right+1;
    }
}