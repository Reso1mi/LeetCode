public class MaxProduct152{
    public static void main(String[] args) {
        int[] n={2, -5 ,-2,-4,3};
        maxProduct(n);
    }

    //     -2  2  3   -4        -2 0 -1   2 3 -2  4   -1  2 -3 -2  4 
    //dp1:  0  2  6   48         0 0  0   2 6  0  4    0  2  6 12  48
    //dp2: -2 -4 -12 -24        -2 0 -1   0 0 -12 0   -1 -2 -6 -2  0
    //
    // 2 -5   -2  -4   3
    // 2  0   20   8   24
    // 0 -10  -2  -80 -240
    public static int maxProduct(int[] nums) {
        int[] dp1=new int[nums.length];
        int[] dp2=new int[nums.length];
        //最大值
        dp1[0]=nums[0]>=0?nums[0]:0;
        //最小值
        dp2[0]=nums[0]>=0?0:nums[0];
        int max=nums[0]>0?dp1[0]:dp2[0];
        for(int i=1;i<nums.length;i++){
            if (nums[i]>0) {
                if (nums[i-1]<0) {
                    dp1[i]=dp1[i-1]!=0?nums[i]*dp1[i-1]:nums[i];
                    dp2[i]=dp2[i-1]*nums[i];
                }else if(nums[i-1]>0){
                    dp1[i]=dp1[i-1]*nums[i];
                    dp2[i]=dp2[i-1]!=0?nums[i]*dp2[i-1]:0;
                }else{
                    dp1[i]=nums[i];
                    dp2[i]=0;
                }
            }else if (nums[i]<0) {
                if (nums[i-1]<0) {
                    dp1[i]=dp2[i-1]*nums[i];
                    dp2[i]=dp1[i-1]!=0?dp1[i-1]*nums[i]:nums[i];
                }else if(nums[i-1]>0){
                    dp1[i]=dp1[i-1]!=0?nums[i]*dp2[i-1]:0;
                    dp2[i]=dp1[i-1]*nums[i];
                }else{
                    dp1[i]=0;
                    dp2[i]=nums[i];
                }
            }else{
                dp1[i]=0;
                dp2[i]=0;
            }
            //System.out.println(dp1[i]+","+dp2[i]);
            max=Math.max(max,dp1[i]);
        }
        return max;
    }

    public static int maxProduct(int[] nums) {
        int[] min=new int[nums.length];
        int[] max=new int[nums.length];
        int res=max[0]=min[0]=nums[0];
        for (int i=1;i<nums.length;i++) {
            max[i]=Math.max(nums[i]*min[i-1],Math.max(nums[i],nums[i]*max[i-1]));
            min[i]=Math.min(nums[i]*min[i-1],Math.min(nums[i],nums[i]*max[i-1]));
            res=Math.max(res,max[i]);
        }
        return res;
    }
}