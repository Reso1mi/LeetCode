import java.util.*;
public class CanPartitionKSubsets698{
    public static void main(String[] args) {
        CanPartitionKSubsets698 c=new CanPartitionKSubsets698();
        c.canPartitionKSubsets(new int[]{4,3,2,3,5,2,1},4);
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        if(nums==null || nums.length<=0){
            return false;
        }
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%k!=0) return false;
        Arrays.sort(nums);
        return dfs(nums,nums.length-1,new int[k],sum);
    }

    public boolean dfs(int[] nums,int index,int[] bucket,int sum){
        //sum(bucket)==sum
        //if条件: bucket[i]<=sum/bucket.len -> bucket[i]<=sum(bucket)/bucket.len
        //所以不用单独去判断是否都相等,直接retuen true
        if(index==-1){
            return true;
        }
        for(int i=0;i<bucket.length;i++){
            //普通的剪枝 60ms，只判断了是否小于平均值
            //if(bucket[i]+nums[index]<=sum/bucket.length){
            //更好的剪枝方式1ms，判断剩余空间不为0的时候还能不能填其他元素
            int rest=sum/bucket.length-bucket[i]-nums[index];
            if(rest==0 || rest>=nums[0]){ //小于nums[0]就啥也填不了了
                bucket[i]+=nums[index];
                if(dfs(nums,index-1,bucket,sum)){
                    return true;
                }
                bucket[i]-=nums[index];
            }
        }
        return false;
    }


    //尝试状压====> 仍然失败
    Boolean[] dp=null;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        if(nums==null || nums.length<=0){
            return false;
        }
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%k!=0) return false;
        Arrays.sort(nums);
        dp=new Boolean[1<<16];
        return dfs(nums,0,nums.length-1,new int[k],sum);
    }

    public boolean dfs(int[] nums,int state,int index,int[] bucket,int sum){
        if(index==-1){
            return true;
        }
        if(dp[state]!=null){
            return dp[state];
        }
        for(int i=0;i<bucket.length;i++){
            int rest=sum/bucket.length-bucket[i]-nums[index];
            if(rest==0 || rest>=nums[0]){
                bucket[i]+=nums[index];
                if(dfs(nums,state|1<<index,index-1,bucket,sum)){
                    return dp[state]=true;
                }
                bucket[i]-=nums[index];
            }
        }
        return dp[state]=false;
    }

}