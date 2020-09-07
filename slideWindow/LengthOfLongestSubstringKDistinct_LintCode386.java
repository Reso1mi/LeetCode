public class LengthOfLongestSubstringKDistinct_LintCode386 {

    //好长的名字，也是个无脑滑窗题
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        int n = s.length();
        int left = 0;
        int res = 0;
        int[] freq = new int[128];
        int count = 0;
        for (int right = 0; right < n; right++) {
            char cr = s.charAt(right);
            if (freq[cr] == 0) {
                count++;
            }
            freq[cr]++;
            while (left <= right && count > k) {
                char cl = s.charAt(left);
                freq[cl]--;
                if (freq[cl] <= 0) {
                    count--;
                }
                left++;
            }
            res = Math.max(res, right-left+1);
        }
        return res;
    }
}