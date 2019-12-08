public class SmallestDivisor1282{
    public static void main(String[] args) {

    }

    public int smallestDivisor(int[] nums, int threshold) {
        int left=1,right=1000000;
        while(left<right){
            int mid=left+(right-left)/2;
            int sum=0;
            for (int i=0;i<nums.length;i++) {
                sum+=(nums[i]+mid-1)/mid; //向上取整
            }
            if (sum>threshold) {
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return left;
    }
}