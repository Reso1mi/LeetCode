import java.util.*;


public class NC557Solve {
    /**
     * 好多牛牛
     * @param s string字符串 
     * @return int整型
     */
    public static void main(String[] args) {
        System.out.println(new NC557Solve().solve3("abaa"));    
    }

    //二维DP（不方便优化成一维的）
    public int solve1 (String s) {
        // write code here 
        String p = "aa";
        int m = p.length();
        int n = s.length();
        int MOD = (int)1e9+7;
        //dp[i][j]代表s[0,j]中有多少个p[0,j]
        long[][] dp = new long[7][n+1];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                if (s.charAt(j-1) == p.charAt(i-1)) {
                    //dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % MOD;
                    //上面的是错的，之所以正确是因为题目的niuniu没有连续的相同字符
                    //考虑如下case:  p = "aa" , s = "abaa" wa = 6, ac = 3
                    dp[i][j] = (dp[i-1][j-1] + dp[i][j-1]) % MOD;
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return (int)dp[m][n];
    }

    // //按照上面的写法来降维，无论怎么写都不对，怪怪的
    // public int solve2 (String s) {
    //     // write code here 
    //     String p = "aa";
    //     int m = p.length();
    //     int n = s.length();
    //     int MOD = (int)1e9+7;
    //     //dp[i][j]代表s[0,j]中有多少个p[0,j]
    //     //优化掉一维的空间
    //     long[] dp = new long[n];
    //     //这里不能直接fill需要手动初始化第一个字符，这样的写法不好初始化，需要特判，这里懒得写了
    //     //Arrays.fill(dp, 1);
    //     for (int j = 0; j < n; j++) {
    //         if (s.charAt(j) == p.charAt(0)) {
    //             dp[j]++;
    //         }
    //     }
    //     for (int i = 1; i < m; i++){
    //         //for (int j = 1; j < n; j++){
    //         for (int j = n-1; j > 0; j--){
    //             if (s.charAt(j) == p.charAt(i)) {
    //                 dp[j] = (dp[j] + dp[j-1]) % MOD;
    //             }
    //             System.out.println(i+","+j+","+dp[j]);
    //             //这里如果不写else就是下面的表达式，明显和我们的意图不一致
    //             //所以正确的做法就是手动赋值 dp[j] = dp[j-1] 或者交换内外循环的循序
    //             //else dp[j] = dp[j] （dp[i-1][j] ）
    //         }
    //     }
    //     return (int)dp[n-1];
    // }


    //二维DP，交换内外循环
    public int solve2 (String s) {
        // write code here 
        String p = "aa";
        int n = s.length();
        int m = p.length();
        int MOD = (int)1e9+7;
        //dp[i][j]代表s[0,i]中有多少个p[0,j]
        long[][] dp = new long[n+1][m+1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++){
            dp[i][0] = 1;
            for (int j = 1; j <= m; j++){
                if (s.charAt(i-1) == p.charAt(j-1)) {
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % MOD;
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return (int)dp[n][m];
    }
    
    //按上面的来降维舒服多了
    public int solve3 (String s) {
        String p = "aa";
        int n = s.length();
        int m = p.length();
        int MOD = (int)1e9+7;
        //dp[j]代表s[0,i]中有多少个p[0,i]
        long[] dp = new long[m+1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++){
            //for (int j = 1; j <= m; j++){
            //内层应该反过来递推，保证dp[j]和dp[j-1]是上一次的
            for (int j = m; j >= 1; j--){
                if (s.charAt(i-1) == p.charAt(j-1)) {
                    dp[j] = (dp[j] + dp[j-1]) % MOD;
                }
            }
        }
        return (int)dp[m];
    }
}