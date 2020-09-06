public class StringCount_LintCode_1870{
    // 1 1 1 1 1 (5+4+3+2+1) = n(n-1)/2 + n or n(n+1)/2
    public int stringCount(String str) {
        // Write your code here.
        int left = 0, right = 0;
        int res = 0;
        while (right < str.length()) {
            while(right < str.length() && str.charAt(right) == '0'){
                right++;
            }
            // (0  0  0) 1 1
            //  l  n     r
            int n = right-left;
            //C(n+1,2)/2
            res += n*(n+1)/2;
            right++;
            left = right;
        }
        return res;
    }
}