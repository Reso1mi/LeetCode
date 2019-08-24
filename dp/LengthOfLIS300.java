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

    public static int lengthOfLIS(int[] nums) {
        int[] tail = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int index=binarySearch(tail,len,num);
            tail[index] = num;
            if (index == len) {
                len++;
            }
        }
        return len;
    }

    //可以搜索
    private static int binarySearch(int[] nums, int len, int target) {
        int l=0,r=len-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(target<nums[mid]){
                r=mid-1;
            }else if(target>nums[mid]){
                l=mid+1;
            }else{
                return mid;
            }
        }
        return l;
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