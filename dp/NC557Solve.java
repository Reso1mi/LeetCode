import java.util.*;


public class NC557Solve {
    /**
     * 好多牛牛
     * @param s string字符串 
     * @return int整型
     */
    public static void main(String[] args) {
        System.out.println(new NC557Solve().solve2("niuniniu"));    
    }

    public int solve1 (String s) {
        // write code here 
        String p = "niuniu";
        int n = s.length();
        int MOD = (int)1e9+7;
        //dp[i][j]代表s[0,j]中有多少个p[0,j]
        long[][] dp = new long[7][n+1];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i <= 6; i++){
            for (int j = 1; j <= n; j++){
                if (s.charAt(j-1) == p.charAt(i-1)) {
                    dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % MOD;
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return (int)dp[6][n];
    }

    //错误降维写法，看似正确实际上不对
    public int solve2 (String s) {
        // write code here 
        String p = "niuniu";
        int n = s.length();
        int MOD = (int)1e9+7;
        //dp[i][j]代表s[0,j]中有多少个p[0,j]
        //优化掉一维的空间
        long[] dp = new long[n+1];
        //这里错了，这样的写法不好初始化，需要特判，这里懒得写了
        Arrays.fill(dp, 1); 
        for (int i = 1; i <= 6; i++){
            for (int j = 1; j <= n; j++){
                if (s.charAt(j-1) == p.charAt(i-1)) {
                    dp[j] = (dp[j] + dp[j-1]) % MOD;
                } else {
                    dp[j] = dp[j-1];
                }
                System.out.println(i+","+j+","+dp[j]);
                //这里如果不写else就是下面的表达式，明显和我们的意图不一致
                //所以正确的做法就是手动赋值 dp[j] = dp[j-1] 或者交换内外循环的循序
                //else dp[j] = dp[j] （dp[i-1][j] ）
            }
        }
        return (int)dp[n];
    }

    public int solve3 (String s) {
        String p = "niuniu";
        int n = s.length();
        int m = p.length();
        int MOD = (int)1e9+7;
        //dp[j]代表s[0,i]中有多少个p[0,i]
        long[] dp = new long[m+1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                if (s.charAt(i-1) == p.charAt(j-1)) {
                    dp[j] = (dp[j] + dp[j-1]) % MOD;
                }
            }
        }
        return (int)dp[m];
    }
}