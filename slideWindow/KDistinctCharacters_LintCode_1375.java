public class KDistinctCharacters_LintCode_1375 {
    
    public long kDistinctCharacters(String s, int k) {
        int n = s.length();
        int left = 0;
        int[] freq = new int[128];
        int count = 0;
        long res = 0;
        for (int right = 0; right < n; right++) {
            char cr = s.charAt(right);
            if (freq[cr] == 0) {
                count++;
            }
            freq[cr]++;
            while (count >= k && left <= right) {
                // abc | abcabcabc
                // l r(2)          n(12)
                //统计以s[left,right]开头的所有子串
                //10+9+8+7+...+1
                res += n-right;
                char cl = s.charAt(left);
                freq[cl]--;
                if (freq[cl] <= 0) {
                    count--;
                }
                left++;
            }
        }
        return res;
    }
}