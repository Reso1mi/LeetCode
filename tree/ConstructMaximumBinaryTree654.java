public class ConstructMaximumBinaryTree654{
    public static void main(String[] args) {

    }

    //不做预处理,直接搜索2ms,我这个50ms+.....懒得改的就当练手了
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int n=nums.length;
        int[][] max=new int[n][n];
        for(int i=0;i<n;i++){
            max[i][i]=i;
            for(int j=i+1;j<n;j++){
                max[i][j]=nums[j]>nums[max[i][j-1]]?j:max[i][j-1];
            }
        }
        return dfs(nums,0,n-1,max);
    }

    public TreeNode dfs(int[] nums,int left,int right,int[][] max){
        if(left>right) return null;
        int maxIdx=max[left][right];
        TreeNode root=new TreeNode(nums[maxIdx]);
        root.left=dfs(nums,left,maxIdx-1,max);
        root.right=dfs(nums,maxIdx+1,right,max);
        return root;
    }
}