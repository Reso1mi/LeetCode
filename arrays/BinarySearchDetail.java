public class BinarySearchDetail{
    public static void main(String[] args) {
        int[] nums={1,2,4,5,22,234};
        int res=binarySearch(nums,nums.length,3);
        //int res=binarySearch2(nums,3,0,nums.length-1);
        System.out.println(res);
    }

    //这种写法可以找到 第一个比target大的元素index
    public static int binarySearch(int[] nums,int len,int target){
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
        return r;
        //return l;
    }
    
    public static int binarySearch2(int []nums,int target,int lo,int hi){
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(nums[mid]>target){
                hi=mid-1;
            }else if(nums[mid]<target){
                lo=mid+1;
            }else return mid;
        }
        //return hi-1
        return lo;
    }
}