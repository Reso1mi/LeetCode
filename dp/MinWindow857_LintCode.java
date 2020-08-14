public class MinWindow857_LintCode{
    public static void main(String[] args) {

    }

    public String minWindow(String S, String T) {
        int m = S.length(), n = T.length();
        //S前i个字符包含T前j个字符的最小窗口子序列起始位置
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <= m; i++){
            //虽然T串为空，但是注意这里不是0，因为需要最短，所以起点越靠后越短
            //最后的长度就是通过 i-dp[i][j]来计算的
            Arrays.fill(dp[i], -1);
            dp[i][0] = i;
        }
        int start = -1, end = m;
        for (int i = 1; i <= m; i++) {
            //注意T的长度小于S的长度
            for (int j = 1; j <= Math.min(n, i); j++){
                if (S.charAt(i-1) == T.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    //dbd
                    //  b   dbd和db包含b的最小窗口起始位置一样
                    dp[i][j] = dp[i-1][j];
                }
                
            }
            if (dp[i][n]!=-1 && i-dp[i][n] < end-start+1) {
                start = dp[i][n];
                end = i-1;
            }
        }
        return start==-1 ? "" : S.substring(start,end+1);
    }
}