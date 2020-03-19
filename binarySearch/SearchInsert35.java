public class SearchInsert35{
    public static void main(String[] args) {
        int []nums={1,2,3,4,5,10};  
        int index=searchInsert(nums,2);
        System.out.println(index);
    }   

    public static  int searchInsert(int[] nums, int target) {
        int len=nums.length;
        int lo=0,hi=len-1;
        if(nums[hi]<target){
            return len;
        }
        if(nums[0]>=target){
            return 0;
        }
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(nums[mid]<target){
                lo=mid+1;
                if(lo<nums.length&&nums[lo]>target){
                   return mid+1;
                }
            }else if(nums[mid]>target){
                hi=mid-1;
                if(hi>=0&&nums[hi]<target){
                    return hi+1;
                }
            }else{
                return mid; //相等的情况，直接返回这个index
            }
        }
        return 0; //到这里说明数组为空
    }

    //上面的都是dd
    public int searchInsert(int[] nums, int target) {
        int len=nums.length;
        int lo=0,hi=len;
        while(lo< hi){
            int mid=lo+(hi-lo)/2;
            if(nums[mid]<target){
                lo=mid+1;
            }else {
                hi=mid;
            }
        }
        return lo;
    }
}