/*
给你一维空间的 n 个点，其中第 i 个点（编号从 0 到 n-1）位于 x = i 处，请你找到 恰好 k 个不重叠 线段且每个线段至少覆盖两个点的方案数。线段的两个端点必须都是 整数坐标 。这 k 个线段不需要全部覆盖全部 n 个点，且它们的端点 可以 重合。

请你返回 k 个不重叠线段的方案数。由于答案可能很大，请将结果对 109 + 7 取余 后返回。

 

示例 1：
输入：n = 4, k = 2
输出：5
解释：
如图所示，两个线段分别用红色和蓝色标出。
上图展示了 5 种不同的方案 {(0,2),(2,3)}，{(0,1),(1,3)}，{(0,1),(2,3)}，{(1,2),(2,3)}，{(0,1),(1,2)} 。

示例 2：
输入：n = 3, k = 1
输出：3
解释：总共有 3 种不同的方案 {(0,1)}, {(0,2)}, {(1,2)} 。

示例 3：
输入：n = 30, k = 7
输出：796297179
解释：画 7 条线段的总方案数为 3796297200 种。将这个数对 109 + 7 取余得到 796297179 。

示例 4：
输入：n = 5, k = 3
输出：7

示例 5：
输入：n = 3, k = 2
输出：1

提示：
2 <= n <= 1000
1 <= k <= n-1

 * dp21 = 1  dp31 = 3   dp41 = 6   dp51 = 10   dp61 = 15
 *           dp32 = 1   dp42 = 5   dp52 = 15   dp62 = 35  dp72 = 70  dp82 =126
 *                      dp43 = 1   dp53 = 7    dp63 = 28
 *                                 dp54 = 1    dp64 = 9
 *                                             dp65 = 1
 * dp42 = 2*dp32 + dp31 - dp22
 * dp63 = 2*dp53 + dp52 - dp43 = 14+15-1 = 28
 */

public class NumberOfSets1621 {

    //有一点脑洞的递推
    public int numberOfSets(int n, int k) {
        int MOD = (int)1e9+7;
        //前n个点，放k个线段，不重叠的方案数
        long[][] dp = new long[n+1][k+1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i-1 && j <= k; j++) {
                //dp[2][1] = 2*dp[1][1] - dp[0][1] + dp[1][0]
                //这个递推还是有点难直接推出来，我想了很久，想到了是对称的应该*2，但是没想到怎么去重
                dp[i][j] = 2*dp[i-1][j] - dp[i-2][j] + dp[i-1][j-1];
                dp[i][j] = (dp[i][j] + MOD) % MOD;
            }
        }
        return (int)dp[n][k];
    }


    //友好一点的递推
    public int numberOfSets(int n, int k) {
        int MOD = (int)1e9+7;
        //dp[i][j][0]: 前i个点放j条线段，第j条线段没有覆盖右端点
        //dp[i][j][1]: 前i个点放j条线段，第j条线段覆盖右端点（可以延长）
        long[][][] dp = new long[n+1][k+1][2];
        for (int i = 0; i <= n; i++) {
            dp[i][0][0] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= Math.min(i-1, k); j++) {
                dp[i][j][0] = dp[i-1][j][0] + dp[i-1][j][1];
                dp[i][j][1] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j][1];
                dp[i][j][0] = (dp[i][j][0] + MOD) % MOD;
                dp[i][j][1] = (dp[i][j][1] + MOD) % MOD;
            }
        }
        return (int)(dp[n][k][0] + dp[n][k][1] + MOD) % MOD;
    }
    

    //写个暴搜试试（T了）
    int MOD = (int)1e9+7;

    public int numberOfSets2(int n, int k) {
        Long[][] dp = new Long[n+1][k+1];
        return dfs(n, k, dp);
    }

    //n个点放k条线段的方案数
    public int dfs(int n, int k, Long[][] dp) {
        if (dp[n][k] != null) {
            return dp[n][k].intValue();
        }
        if (k == 0) {
            return 1;
        }
        if (k == 1) {
            return (n-1)*n/2;
        }
        long res = 0;
        //i <= n-k+2
        for (int i = 1; n-i >= k-2; i++) {
            //前(i+1)个点放一条线段有i种方案（刨开之前的方案）
            res += 1l * i * dfs(n-i, k-1, dp);
            res = (res + MOD) % MOD;
        }
        dp[n][k] = res;
        return (int)res;
    }
}