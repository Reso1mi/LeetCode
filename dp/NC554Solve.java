import java.util.*;


public class NC554Solve {
    /**
     * 简单变相
     * @param n int整型 
     * @param m int整型 
     * @param x int整型一维数组 
     * @param y int整型一维数组 
     * @return int整型
     */
    //1 2 3 4
    //x 2 x 4
    //1 x 3 4
    //3,3,[2,3,2],[3,2,1]
    public int solve (int n, int m, int[] x, int[] y) {
        long[][] dp = new long[3][n+1];
        int MOD = (int)1e9+7;
        boolean[][] v = new boolean[3][n];
        for(int i = 0; i < m; i++){
            v[x[i]-1][y[i]-1] = true;
        }
        dp[0][0] = 1;
        for (int j = 1; j < n; j++) {
            dp[0][j] = v[0][j] ? 0 : (dp[0][j-1] + dp[1][j-1])%MOD;
            dp[1][j] = v[1][j] ? 0 : (dp[1][j-1] + dp[0][j-1]+dp[2][j-1])%MOD;
            dp[2][j] = v[2][j] ? 0 : (dp[2][j-1] + dp[1][j-1])%MOD;
        }
        return  (int)(dp[2][n-1]%MOD);
    }
}