public class FindUnsortedSubarray581{
    public static void main(String[] args) {

    }

    public int findUnsortedSubarray(int[] nums) {
        if (nums[0]>nums[nums.length-1]) {
            return nums.length;
        }
        int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        for (int i=1;i<nums.length;i++) {
            if (nums[i]<nums[i-1]) {
                min=Math.min(min,nums[i]);
            }
        }

        for (int i=nums.length-1;i>0;i--) {
            if (nums[i]<nums[i-1]) {
                max=Math.max(max,nums[i-1]);
            }
        }
        int left=0,right=nums.length-1;
        while(left<nums.length){
            if (nums[left]>min) {
                break;
            }
            left++;
        }
        while(right>=0){
            if (nums[right]<max) {
                break;
            }
            right--;
        }
        return right<left?0:right-left+1;
    }

    public int findUnsortedSubarray(int[] nums) {
        int i=0,j=nums.length-1;
        if (nums[i]>nums[j]) {
            return nums.length;
        }
        while (i<nums.length-1 && nums[i]<=nums[i+1]) {
            if (nums[i]==nums[i+1]) {
                i++;
            }
            if (nums[i]<nums[i+1]) {  
                left++;
            }
        }
        if (i==nums.length-1) {
            return 0;
        }
        while(j>0 && nums[j]>=nums[j-1]){
            j--;
        }
        return j-i+1;
    }
}