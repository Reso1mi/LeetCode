public class MaxSubArray53{
    public static void main(String[] args) {

    }

    //这次是直接在Web上写的
    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int[] dp=new int[nums.length];
        //一开始没处理好Wa了一发
        int max=dp[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            if(dp[i-1]<=0){
                dp[i]=nums[i];
            }else{
                dp[i]=dp[i-1]+nums[i];
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }

    //根据二维改一维
    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int dp1=nums[0],dp2=0,max=nums[0];
        for (int i=1;i<nums.length;i++) {
            if (dp1<=0) {
                dp2=nums[i];
            }else{
                dp2=dp1+nums[i];
            }
            dp1=dp2;
            max=Math.max(max,dp2);
        }
        return max;
    }
}