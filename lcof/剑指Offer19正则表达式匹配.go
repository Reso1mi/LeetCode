func isMatch(s string, p string) bool {
    m, n := len(s), len(p)
    dp := make([][]bool, m+1)
    for i := 0; i <= m; i++ {
        dp[i] = make([]bool, n+1)
    }

    dp[0][0] = true
    // init dp[0][j]
    for j := 1; j <= n; j++ {
        if p[j-1] == '*' && j > 1 {
            // *匹配0个
            dp[0][j] = dp[0][j-2]
        }
    }

    for i := 1; i <= m; i++ {
        for j := 1; j <= n; j++ {
            if s[i-1] == p[j-1] || p[j-1] == '.' {
                dp[i][j] = dp[i-1][j-1]
            } else if p[j-1] == '*' && j > 1 {
                // 匹配一个或者多个
                if s[i-1] == p[j-2] || p[j-2] == '.' {
                    dp[i][j] = dp[i][j-1] || dp[i-1][j]
                }
                // *匹配0个
                dp[i][j] = dp[i][j-2] || dp[i][j]
            }
        }
    }

    return dp[m][n]
}