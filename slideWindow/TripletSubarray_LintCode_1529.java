public class TripletSubarray_LintCode_1529{
    
    //LintCode上居然是Hard，感觉不是很难
    public int tripletSubarray(int[] nums, int limit) {
        // write your code here
        int n = nums.length;
        int left = 0, right = 0;
        int res = 0;
        while (left <= right) {
            //找到最远的合法right
            while (right < n && nums[right]-nums[left] <= limit) {
                right++;
            }
            //  1  (2 3 4)  5
            //left   len  right
            int len = right-left-1;
            left++;
            if (len < 2) continue;
            //C(len,2) 求以left开头，包含left的所有3元组，这样不会重复
            res += len*(len-1)/2;
        }
        return res;
    }
}