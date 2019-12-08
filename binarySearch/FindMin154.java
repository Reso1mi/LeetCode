public class FindMin154{
    public static void main(String[] args) {

    }

    //3 3 1 3
    //1 3 3
    public int findMin(int[] nums) {
        int left=0,right=nums.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid] > nums[right]){
                left=mid+1;
            }else if(nums[mid] < nums[right]){
                right=mid;
            }else{
                right--; //和右边界相等,无法判断,只缩减一步
            }
        }
        return nums[left];
    }
}