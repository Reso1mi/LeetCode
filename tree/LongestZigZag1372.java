public class LongestZigZag1372{
    public static void main(String[] args) {

    }

    int res=0;
    
    public int longestZigZag(TreeNode root) {
        dfs(root,false);//true false都无所谓
        return res-1;
    }
    
    public int dfs(TreeNode root,boolean isRight){
        if(root==null){
            return 0;
        }
        int l=dfs(root.left,false);
        int r=dfs(root.right,true);
        res=Math.max(res,Math.max(l+1,r+1));
        if(isRight){
            return l+1;
        }
        return r+1;
    }

    //树形DP写法
    int max=0;
    
    public int longestZigZag(TreeNode root) {
        dfs(root);
        return max-1;
    }
    
    public int[] dfs(TreeNode root){
        int[] res=new int[2];
        if(root==null){
            return res;
        }
        res[0]=dfs(root.left)[1]+1;
        res[1]=dfs(root.right)[0]+1;
        max=Math.max(max,Math.max(res[0],res[1]));
        return res;
    }
}