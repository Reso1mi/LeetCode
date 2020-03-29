public class FindPeakElement162{
    public static void main(String[] args) {

    }

    public int findPeakElement(int[] nums) {
        int left=0,right=nums.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(/*mid+1<nums.length &&*/nums[mid]<nums[mid+1]){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return left;
    }
}