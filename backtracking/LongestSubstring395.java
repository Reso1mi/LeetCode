public class LongestSubstring395{
    public static void main(String[] args) {

    }

    //380ms+ 很慢的解法
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i)-'a']++;
        }
        int min = 0; //记录count最小的index
        for(int i = 0;i < s.length(); i++){
            min = count[s.charAt(i)-'a'] < count[s.charAt(min)-'a'] ? i : min;
        }
        if (count[s.charAt(min)-'a'] >= k) {
            return s.length();
        }
        return Math.max(longestSubstring(s.substring(0,min),k),longestSubstring(s.substring(min+1),k));
    }
    

    //1ms 多路分治，虽然过了，但是感觉还是有点不流畅
    //主要就是最后那个当以大于k的字符结尾的时候的额外处理
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i)-'a']++;
        }
        int res = 0;
        int left = 0; //分治左端点
        boolean flag = false;
        for(int i = 0; i < s.length(); i++){
            if(count[s.charAt(i)-'a'] < k){
                flag = true;
                if(i - left >= res){ //剪枝优化
                    res = Math.max(longestSubstring(s.substring(left,i),k),res);
                }
                left = i+1;
            }
        }
        if(!flag) return s.length();
        //上面分治的逻辑是以left到小于k的字母i进行分治，但是如果字符不是以小于k的字母结尾就无法计算
        //eg: aabbb k=3
        return Math.max(res,longestSubstring(s.substring(left),k));
    }
}