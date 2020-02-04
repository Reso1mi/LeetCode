public class MaxSumDivThree1262{
    public static void main(String[] args) {

    }

    //3,6,5,1,8
    public int maxSumDivThree(int[] nums) {
        int[] dp=new int[nums.length+1];
        dp[0]=0; //dp[i]表示0~i最大整除3元素和
        for (int i=1;i<=nums.length;i++) {
            dp[i]=dp[i-1];
            for (int j=i-1;j>0;j--) {
                int temp=nums[i-1]+nums[j-1];
                if((temp)%3==0){
                    dp[i]=Math.max(dp[i],dp[j-1]+temp);
                }
            }
        }
        return  dp[nums.length];
    }
}