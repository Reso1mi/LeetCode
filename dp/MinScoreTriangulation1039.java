public class MinScoreTriangulation1039{
    public static void main(String[] args) {

    }

    //环形的结构
    public int minScoreTriangulation(int[] A) {
        if(A==null || A.length<=0) return 0;
        int N=A.length;
        //从 0 ~ N-1 形成一个环
        //    1——3 
        //   /    \
        //  5      1
        //   \    /
        //    1——4
        // dp[left][right] 代表left~right形成的环的最小得分值
        int[][] dp=new int[N][N];
        for (int len=3;len<=N;len++) { //枚举长度,从3开始
            for (int left=0;left<=N-len;left++) { //枚举左端点
                //left+len-1<N
                int right=left+len-1;
                //init
                dp[left][right]=Integer.MAX_VALUE;
                for (int i=left+1;i<right;i++) { //枚举区间内的点,将环分割成左右两部分
                    dp[left][right]=Math.min(dp[left][right],dp[left][i]+dp[i][right]+A[i]*A[left]*A[right]);
                }
            }
        }
        return dp[0][N-1];
    }
}