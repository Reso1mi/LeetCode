public class MinimumOperations_LCP19{
    public int minimumOperations(String s) {
        int n = s.length();
        int[][] dp = new int[n+1][3];
        //0，1，2分别代表 前面的r 中间的y 结尾的r
        dp[0][0] = s.charAt(0) == 'r' ? 0 : 1;
        dp[0][1] = dp[0][2] = dp[1][2] = 0x3f3f3f3f;
        //简单的递推
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == 'r') {
                dp[i][0] = dp[i-1][0];
                dp[i][1] = Math.min(dp[i-1][1]+1, dp[i-1][0]+1);
                dp[i][2] = Math.min(dp[i-1][2], dp[i-1][1]);
            } else {
                dp[i][0] = dp[i-1][0]+1;
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][1]);
                dp[i][2] = Math.min(dp[i-1][2]+1, dp[i-1][1]+1);
            }
        }
        return dp[n-1][2];
    }
}