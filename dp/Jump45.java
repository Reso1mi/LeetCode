public class Jump45{
    public static void main(String[] args) {
        
    }


    //TLE
    public int jump(int[] nums) {
        if (nums==null || nums.length<=0) {
            return 0;
        }
        int[] dp=new int[nums.length];
        for (int i=1;i<nums.length;i++) {
            dp[i]=Integer.MAX_VALUE;
            for (int j=0;j<i;j++) {
               if (nums[j]>=i-j) {
                    dp[i]=Math.min(dp[j]+1,dp[i]);    
               }
            }
        }
        return dp[nums.length-1];
    }

    //每次选能跳的位置中跳的最远的
    public int jump(int[] nums){
        if (nums==null || nums.length<=0) {
            return 0;
        }
        int max=0;//最大边界
        int step=0,curMaxIndex=0;
        for (int i=0;i<nums.length-1;i++) {
            curMaxIndex=Math.max(curMaxIndex,nums[i]+i); //i能跳的位置中,跳的最远的
            if (i==max) {//走到边界就++
                step++;
                max=curMaxIndex;
            }
        }
        return step;
    }


/*    public int jump(int[] nums){
        if (nums==null || nums.length<=0) {
            return 0;
        }
        int step=0,index=0;
        while (index<nums.length-1) {
            int max=0;
            for (int j=index;j<=nums[index]+index;j++) {
                if (nums[j]>=max) {
                    index=j;
                    max=nums[j];
                }
                if (max+j>nums.length) {
                    return step+1;
                }
            }
            step++;
        }
        return step;
    }*/
}