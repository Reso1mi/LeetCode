public class FindNumberOfLIS673{
    public static void main(String[] args) {
        
    }

    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        //dp[i][0]结尾的最长递增子序列,dp[i][1]代表个数
        int[][] dp=new int[n][2];
        int max=0;
        for(int i=0;i<n;i++){
            dp[i][1]=1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    if(dp[j][0]+1==dp[i][0]){
                        dp[i][1]+=dp[j][1];
                    }else if(dp[j][0]+1>dp[i][0]){
                        dp[i][1]=dp[j][1];
                        dp[i][0]=dp[j][0]+1;
                    }
                }
            }
            max=Math.max(max,dp[i][0]);
        }
        int res=0;
        for(int i=0;i<nums.length;i++) {
            res+=dp[i][0]==max?dp[i][1]:0;   
        }
        return res;
    }
}