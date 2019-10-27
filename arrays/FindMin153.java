public class FindMin153{
    public static void main(String[] args) {

    }

    //4 5 6 7 8 9 1 2 3 
    //8 9 1 2 3 4 5 6 7
    //[4,5,6,7,0,1,2]
    public int findMin(int[] nums) {
        if (nums==null||nums.length<=0) {
            return 0;
        }
        if (nums.length==1||nums[0]<nums[nums.length-1]) {
            return nums[0];
        }
        int left=1,right=nums.length-1;
        while(left<right){
            int mid=left+(right-left)/2+1;
            if (nums[mid]>nums[mid-1]) {
                if (nums[mid]>nums[0]) {
                    left=mid;
                }else{
                    right=mid-1;
                }
            }else{
                return nums[mid];
            }
        }
        return nums[left];
    }

    //好解法
    public int findMin(int[] nums) {
        if (nums==null||nums.length<=0) {
            return 0;
        }
        int left=0,right=nums.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if (nums[mid]>nums[right]) {
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return nums[left];
    }
}