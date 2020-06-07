public class LongestConsecutive_LintCode595{
    public static void main(String[] args) {

    }

    public int longestConsecutive(TreeNode root) {
        // write your code here
        dfs(root);
        return max;
    }
    
    int max=0;
    
    //以root开始的最长连续序列
    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        //保证至少是1
        int leftMax = Math.max(1,dfs(root.left));
        int rightMax = Math.max(1,dfs(root.right));
        if(root.left!=null){
            leftMax = root.val==root.left.val-1 ? leftMax+1:1;
        }
        if(root.right!=null){
            rightMax = root.val==root.right.val-1 ? rightMax+1:1;
        }
        max=Math.max(max,Math.max(leftMax,rightMax));
        return Math.max(leftMax,rightMax);
    }
}