public class FindUnsortedSubarray581{
    public static void main(String[] args) {

    }

    //O(1)空间的解法
    public int findUnsortedSubarray(int[] nums) {
        if (nums[0]>nums[nums.length-1]) {
            return nums.length;
        }
        int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        for (int i=1;i<nums.length;i++) {
            if (nums[i]<nums[i-1]) {
                min=Math.min(min,nums[i]); //无序序列中的最小值
            }
        }

        for (int i=nums.length-1;i>0;i--) {
            if (nums[i]<nums[i-1]) {
                max=Math.max(max,nums[i-1]); //无序序列中的最大值
            }
        }
        int left=0,right=nums.length-1;
        while(left<nums.length){
            if (nums[left]>min) {
                break;
            }
            left++; //左边界正确位置
        }
        while(right>=0){
            if (nums[right]<max) {
                break;
            }
            right--; //右边界正确位置
        }
        return right<left?0:right-left+1;
    }

    //单调栈的解法,很优秀
    public int findUnsortedSubarray(int[] nums) {
        Stack<Integer> stack=new Stack<>();
        int left=Integer.MAX_VALUE,right=Integer.MIN_VALUE;
        for (int i=0;i<nums.length;i++) {
            while(!stack.isEmpty() && nums[stack.peek()]>nums[i]){
                left=Math.min(stack.pop(),left); //左边界正确位置
            }
            stack.push(i);
        }
        stack.clear();
        for (int i=nums.length-1;i>=0;i--) {
            while(!stack.isEmpty() && nums[stack.peek()]<nums[i]){
                right=Math.max(stack.pop(),right); //右边界正确位置
            }
            stack.push(i);
        }
        return left>right?0:right-left+1;
    }

    //SB做法WRONG ANSWER
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