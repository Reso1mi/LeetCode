public class Rob198{
    public static void main(String[] args) {
        System.out.println();
    }

    //递归
/*    public int rob(int[] nums) {
        if(nums==null||nums.length<=0){
            return 0;
        }
        if (nums.length==2) {
            return Math.max(nums[0],nums[1]);
        }
        return rob(nums,nums.length-1);
    }

    public int rob(int[] nums,int index) {
        //问题就在这里,这里会提前返回
        if (index==0 || index==1) {
            return nums[index];
        }
        //过了80%的case了,但是还是有问题
        //这里的递归结构是有问题的,比如 2 1 1 2会得到结果3
        //主要是上面的递归出口会提前返回。。。。这里确实不知道咋处理了
        //比如这里最后一个2，max第二个参数会在index=1的时候直接返回1
        return Math.max(nums[index]+rob(nums,index-2),rob(nums,index-1));
    }*/


    //记忆化递归
    private Integer[] cache=null;

    public int rob(int[] nums) {
        cache=new Integer[nums.length];
        if(nums==null||nums.length<=0){
            return 0;
        }
        if (nums.length==2) {
            return Math.max(nums[0],nums[1]);
        }
        return rob(nums,0);
    }

    //rob的定义为抢劫[index,nums.length-1]范围内的所有房子
    public int rob(int[] nums,int index) {
        if (index>=nums.length) {
            return 0;
        }
        if (cache[index]!=null) {
            return cache[index];
        }
        int res=0;
        //2 1 1 2
        //这个递归说实话没看懂
        for (int i=index;i<nums.length;i++) {
            res=Math.max(res,rob(nums,i+2)+nums[i]);
        }
        cache[index]=res;
        return res;
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

    // Max[i]=max(pre+nums[i],cur);  
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