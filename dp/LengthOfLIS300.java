public class LengthOfLIS300{
    public static void main(String[] args) {
        int[] nums={5,12,3,4,5,6,7,1};
        int[] nums2={10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums2));
    }

/*   
     题目就没看清楚就开始做题。。。
     public static int lengthOfLIS(int[] nums) {
        if (nums==null||nums.length<=0) {
            return 0;
        }
        int[] dp=new int[nums.length];
        dp[0]=1;
        int res=Integer.MIN_VALUE;
        for (int i=1; i<nums.length;i++) {
            if(nums[i]>=nums[i-1]){
                dp[i]=dp[i-1]+1;
            }else{
                res=Math.max(res,dp[i-1]);
                dp[i]=1;
            }
        }
        return res;
    }*/

    /*
    输入: [10,9,2,5,3,7,101,18]
    输出: 4 
    解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
     */
    public static int lengthOfLIS(int[] nums) {
        if (nums==null||nums.length<=0) {
            return 0;
        }
        int[] dp=new int[nums.length];
        dp[0]=0;
        for (int i=1;i<nums.length;i++) {
            for (int j=i+1;j<nums.length;j++) {
                
            }
        }
    }
}