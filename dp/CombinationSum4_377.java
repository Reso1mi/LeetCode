import java.util.*;
public class CombinationSum4_377{
    public static void main(String[] args) {
        CombinationSum4_377 c=new CombinationSum4_377();
        int[] nums={1,2,3};
        System.out.println(c.combinationSum4(nums,4));
    }

    //一维dp
    public int combinationSum4(int[] nums,int target){
        int[] dp=new int[target+1];
        dp[0]=1;
        for (int i=0;i<=target;i++) {
            for (int j=0;j<nums.length;j++) {
                dp[i]+= i>=nums[j]?dp[i-nums[j]]:0;
            }
        }
        return dp[target];
    }


    //记忆化递归 1ms 100%
    public int combinationSum4(int[] nums, int target) {
        if (nums==null || nums.length<=0) {
            return 0;
        }
        cache=new Integer[target+1];
        return combination(nums,target);
    }

    Integer[] cache=null;

    public int combination(int[] nums,int target){
        if (cache[target]!=null) {
            return cache[target];
        }
        if (target==0) {
            return 1;
        }
        int res=0;
        for (int i=0;i<nums.length;i++) {
            if (target-nums[i]>=0) {
                res+=combination(nums,target-nums[i]);
            }
        }
        return cache[target]=res;
    }
}