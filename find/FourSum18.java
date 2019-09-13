import java.util.*;
public class FourSum18{
    public static void main(String[] args) {
        int[] nums={-1,0,1,2,-1,-4};
        /*
            [-4,0,-4,2,2,2,-2,-2]
            7           
            [-1,0,1,2,-1,-4]
            -1
         */
        System.out.println(fourSum(nums,-1));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        int n=nums.length;
        //0 0 -1 1
        for (int i=0;i<n-3;i++) {
            if(i>0 && nums[i]==nums[i-1])continue;
            if (nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target) break;
            if (nums[i]+nums[n-1]+nums[n-2]+nums[n-3]<target) continue;
            for (int j=i+1;j<n-2;j++) {
                if(j>i+1&&nums[j]==nums[j-1])continue;
                if (nums[i]+nums[j]+nums[j+2]+nums[j+1]>target) break;
                if (nums[i]+nums[j]+nums[n-2]+nums[n-1]<target) continue;
                int two=nums[i]+nums[j];
                //左右边界
                int left=j+1,right=n-1;
                while(left<right){
                    if (target-two==nums[left]+nums[right]) {
                        res.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        //想清楚什么时候跳,放外面就错了
                        while(left<right && nums[left]==nums[left+1]){left++;};
                        while(left<right && nums[right]==nums[right-1]){right--;};
                        left++;
                        right--;
                    }else if (target-two>nums[left]+nums[right]) {
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        return res;
    }
}