public class BinarySearchDetail{
    public static void main(String[] args) {
        int[] nums={1,2,4,5,22,234};
        int res=binarySearch(nums,nums.length,0);
        System.out.println(res);
    }

    //这种写法可以找到 第一个比target大的元素
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
        return l;
    }
}