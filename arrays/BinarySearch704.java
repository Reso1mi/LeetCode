public class BinarySearch704{
    public static void main(String[] args) {

    }

    //常规二分
    public int search(int[] nums, int target) {
        int left=0,right=nums.length;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]<target){
                left=mid+1;
            }else if(nums[mid] > target){
                right=mid;
            }else{
                return mid;
            }
        }
        return -1;
    }

    //模板二分
    public int search(int[] nums, int target) {
        int left=0,right=nums.length;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]<target){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return left!=nums.length&&nums[left]==target?left:-1;
    }
}