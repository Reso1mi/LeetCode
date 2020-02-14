public class MissingNumber53{
    public static void main(String[] args) {
        
    }

    public int missingNumber(int[] nums) {
        int left=0,right=nums.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]==mid){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        if(nums[left]==left) return left+1; //只有一个数
        return left;
    }
}