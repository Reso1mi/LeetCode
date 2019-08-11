public class Robs213{
    public static void main(String[] args) {
        System.out.println(Math.max(1,4));
    }


    public int rob(int [] nums){
        if(nums==null||nums.length<=0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }

        int n=nums.length;
        return Math.max(rob(nums,1,n),rob(nums,0,n-1));
    }

    //Max[i]=max(nums[i-2]+nums[i],nums[i-1])
    public int rob(int[] nums,int start,int end) {
        int[] dp=new int[nums.length];
        dp[start]=nums[start];
        dp[start+1]=Math.max(nums[start],nums[1+start]);
        int i;
        for (i=start+2;i<end;i++) {
            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[i-1];
    }

    //Max[i]=max(nums[i-2]+nums[i],nums[i-1])
    public int rob2(int[] nums,int start,int end) {
        int pre=0; //前一家最大值
        int cur=0; //当前最大值
        for (int i=start;i<end;i++) {
            int temp=cur;
            cur=Math.max(pre+nums[i],cur);
            pre=temp;
        }
        return cur;
    }

}