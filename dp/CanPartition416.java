import java.util.*;
public class CanPartition416{
    public static void main(String[] args) {

    }

    //二维dp
    public boolean canPartition(int[] nums) {
        if (nums==null || nums.length<=0) return false;
        //int sum=Arrays.stream(nums).sum(); 用stream好慢
        int sum=0;
        for (int e:nums) sum+=e; //求和
        if (sum%2!=0) {
            return false;
        }
        int half=sum/2;
        //dp[i][j]的含义是从[0,i]中选取元素,能否刚好填满j
        boolean[][] dp=new boolean[nums.length][half+1];
        for (int j=0;j<=half;j++) {
            dp[0][j]= nums[0]==j;
        }
        for (int i=1;i<nums.length;i++) {
            for (int j=0;j<=half;j++) {
                dp[i][j]= j>=nums[i]?dp[i-1][j] || dp[i-1][j-nums[i]]:dp[i-1][j];
            }
            //如果某个位置填满了就直接返回
            if (dp[i][half]) {
                return true;
            }
        }
        return dp[nums.length-1][half];
    }

    //一维dp
    public boolean canPartition(int[] nums) {
        if (nums==null || nums.length<=0) return false;
        int sum=0;
        for (int e:nums) sum+=e; //求和
        if (sum%2!=0) {
            return false;
        }
        int half=sum/2;
        //dp[j]的含义是从[0,i]中选取元素,能否刚好填满j
        boolean[] dp=new boolean[half+1];
        for (int j=0;j<=half;j++) {
            dp[j]= nums[0]==j;
        }

        for (int i=1;i<nums.length;i++) {
            for (int j=half;j>=nums[i];j--) {
                //dp[i][j]= j>=nums[i]?dp[i-1][j] || dp[i-1][j-nums[i]]:dp[i-1][j];
                dp[j]=dp[j]||dp[j-nums[i]];
            }
            if (dp[half]) {
                return true;
            }
        }
        return dp[half];
    }


    //记忆化递归37ms 44%,开始慢是因为stream的原因
    Boolean[][] cache=null;

    public boolean canPartition(int[] nums) {
        if (nums==null || nums.length<=0) return false;
        //int sum=Arrays.stream(nums).sum();
        int sum=0;
        for (int e:nums) sum+=e; //求和
        cache=new Boolean[nums.length][sum+1];
        if (sum%2!=0) {
            return false;
        }
        return partition(nums,0,0,sum/2);
    }

    //尝试添加[0,index]位置的元素,看能否使得half=sum (这里其实可以直接在sum上减,看能不能减为0)
    public boolean partition(int[] nums,int index,int half,int sum) {
        if (index==nums.length) {
            return false;
        }
        if (cache[index][half]!=null) {
            return cache[index][half];
        }

        if (half==sum) {
            return true;
        }
        cache[index][half]=partition(nums,index+1,half,sum) || 
            (half<sum&&partition(nums,index+1,half+nums[index],sum));
        return cache[index][half];
    }
}
