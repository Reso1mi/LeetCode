public class Rob198{
    public static void main(String[] args) {
        System.out.println(Math.max(1,4));
    }

    //  Max[i]=max(nums[i-2]+nums[i],nums[i-1])
    public int rob(int[] nums) {
        if(nums==null||nums.length<=0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }

        int []dp=new int[nums.length];
        dp[0]=nums[0];
        dp[1]=nums[1]>nums[0]?nums[1]:nums[0];
        int i;
        for (i=2;i<nums.length;i++) {
            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[i-1];
    }

    // Max[i]=max(x+);  
    public int rob(int[] nums) {
        if(nums==null||nums.length<=0){
            return 0;
        }

        int pre= 0;
        int cur= 0;
        for (int i=0;i<nums.length;i++) {
            int temp=cur;
            cur=Math.max(pre+nums[i],cur);
            pre=temp;
        }
        return cur;
    }

}