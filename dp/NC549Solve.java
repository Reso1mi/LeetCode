//NC549变向 https://www.nowcoder.com/practice/85efab854e60499daa524ca943b72d35
public class NC549Solve{
    public static void main(String[] args) {

    }

    //很直白的dp
    public int solve (int n, int[] a1, int[] a2, int[] a3, int[] m) {
        // write code here
        int[][] dp = new int[3][n];
        dp[0][0] = a1[0];
        dp[1][0] = a2[0];
        dp[2][0] = a3[0];
        for (int j = 1; j < n; j++) {
            dp[0][j] = a1[j] + Math.max(dp[0][j-1], dp[1][j-1]-m[j-1]);
            dp[1][j] = a2[j] + Math.max(dp[1][j-1], Math.max(dp[0][j-1]-m[j-1], dp[2][j-1]-m[j-1]));
            dp[2][j] = a3[j] + Math.max(dp[2][j-1], dp[1][j-1]-m[j-1]);
        }
        return Math.max(dp[0][n-1],Math.max(dp[1][n-1], dp[2][n-1]));
    }
}