public class MaximalSquare221{
    public static void main(String[] args) {

    }

    public int maximalSquare(char[][] matrix) {
        if (matrix==null || matrix.length<=0) {
            return 0;
        }
        int m=matrix.length;
        int n=matrix[0].length;
        //这里在上下边界+1处理边界
        int[][] dp=new int[m+1][n+1];
        int max=0;
        for (int i=1;i<=m;i++) {
            for (int j=1;j<=n;j++) {
                if (matrix[i-1][j-1]=='1') {
                    dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]));
                    max=Math.max(max,dp[i][j]);
                }
            }
        }
        return max*max;
    }
}