public class FindTargetSumWays494{
    public static void main(String[] args) {

    }

    Integer[][] cache=null;

    //HashMap<Integer,Integer> cache=new HashMap<>

    public int findTargetSumWays(int[] nums, int S) {
        if (nums==null || nums.length<=0 || S>1000) {
            return 0;
        }
        //
        int sum=0;
        for(int n:nums)sum+=n;
            if(S>sum)return 0;
        
        //相当于平移了一下,从[-sum,sum] --> [0,2*sum]
        cache=new Integer[nums.length][2*sum+1];
        return findTarget(nums,S,0,2*sum+1);
    }

    public int findTarget(int[] nums,int S,int index,int max){
        if (S==0 && index ==nums.length) {
            return 1;
        }
        if (index>=nums.length) {
            return 0;
        }
        if(S <0  && cache[index][S+max]!=null){
            return cache[index][S+max];
        }
        if (S>=0 && cache[index][S]!=null) {
            return cache[index][S];
        }
        int temp=findTarget(nums,S-nums[index],index+1,max)+findTarget(nums,S+nums[index],index+1,max);
        if (S<0) {
            cache[index][S+max]=temp;
        }else{
            cache[index][S]=temp;
        }
        return  temp;
    }

    //新解法,其实就是01背包
    public int findTargetSumWays(int[] nums, int S) {
        if(nums==null || nums.length<=0) return 0;
        //nsum负,psum正; sum;
        //sum=psum+nsum;
        //S=psum-nsum;
        //(sum+S)/2 = psum
        int sum=0;
        for(int i=0;i<nums.length;i++) sum+=nums[i];
        if((sum+S)%2!=0 || S>sum) return 0;
        int target=(sum+S)/2;
        int[] dp=new int[target+1];
        dp[0]=1;
        for(int i=0;i<nums.length;i++){
            for(int j=target;j>=nums[i];j--){
                dp[j]+=dp[j-nums[i]];
            }
        }
        return dp[target];
    }
}