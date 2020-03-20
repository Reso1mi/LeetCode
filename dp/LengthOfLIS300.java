import java.util.*;
public class LengthOfLIS300{
    public static void main(String[] args) {
        int[] nums={5,12,3,4,5,6,7,1};
        int[] nums4={10,9,2,5,3,7,101,18};
        int[] nums3={1,2,8,3,4,5,6};
        int[] nums2={10,1,2,6,3,4,101,18};
        //[10,9,2,5,3,4]
        int[] nums5={10,9,2,5,3,4};
        System.out.println(":"+lengthOfLIS(nums5));
    }

/*   
     题目就没看清楚就开始做题。。。
     public static int lengthOfLIS(int[] nums) {
        if (nums==null||nums.length<=0) {
            return 0;
        }
        int[] dp=new int[nums.length];
        dp[0]=1;
        int res=Integer.MIN_VALUE;
        for (int i=1; i<nums.length;i++) {
            if(nums[i]>=nums[i-1]){
                dp[i]=dp[i-1]+1;
            }else{
                res=Math.max(res,dp[i-1]);
                dp[i]=1;
            }
        }
        return res;
    }*/

    /*
    输入: [10,9,2,5,3,7,101,18]
    输出: 4 
    解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
     */
    public static int lengthOfLIS2(int[] nums) {
        if (nums==null||nums.length<=0) {
            return 0;
        }
        int[] dp=new int[nums.length];
        //Arrays.fill(dp,1);
        dp[0]=1;
        for (int i=1;i<nums.length;i++) {
            dp[i]=1;
            for (int j=0;j<i;j++) {
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[j]+1,dp[i]);
                }
            }
        }
        int res=-1;
        for (int i=0;i<dp.length;i++) {
            res=res>dp[i]?res:dp[i];
        }
        return res;
    }

/*    Integer[][] cache=null;

    //dfs,其实也是个背包问题 cache记忆化不好处理有负数,而且长度不知道。。只能用HashMap了
    public  int lengthOfLIS3(int[] nums) {
        if (nums==null||nums.length<=0) {
            return 0;
        }
        cache=new Integer[nums.length][Integer.];
        return dfs(nums,0,Integer.MIN_VALUE);
    }

    public  int dfs(int[] nums,int index,int prev){
        if (index==nums.length) {
            return 0;
        }
        if (cache[index][prev]!=null) {
            return cache[index][prev];
        }
        int res=dfs(nums,index+1,prev);
        if (nums[index]>prev) {
            return cache[index][prev]=Math.max(dfs(nums,index+1,nums[index])+1,res);
        }
        return cache[index][prev]=res;
    }*/


    //贪心+二分
    public static int lengthOfLIS(int[] nums) {
        int[] top = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            //寻找左侧最小的堆顶
            int index=binarySearch(top,len,num);
            if (index == len) {
                len++;
            }
            top[index] = num;
        }
        return len;
    }

    //可以搜索
    private static int binarySearch(int[] nums, int len, int target) {
        int left=0,right=len;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]<target){
                left=mid+1;
            }else {
                right=mid;
            }
        }
        return left;
    }

        //[10,9,2,5,3,4]
    public static int binarySearch2(int[] nums,int len,int target){
        int l=0,r=len;
        // [l,r) 左闭右开
        while(l<r){
            int mid=l+(r-l)/2;
            if(target>nums[mid]){
                l=mid+1;
            }else if(target<nums[mid]){
                r=mid;//不用减1本身就取不到
            }else{
                return mid;
            }
        }
        return l;
    }


    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}