func maxProductPath(grid [][]int) int {
    var m, n = len(grid), len(grid[0])
    var MOD = int(1e9+7)
    var dp = make([][][2]int, m)
    var Max = func(a, b int) int {if a < b {return b}; return a}
    var Min = func(a, b int) int {if a > b {return b}; return a}
    for i := 0; i < m; i++ {
        dp[i] = make([][2]int, n)
    }
    dp[0][0][1] = grid[0][0]
    dp[0][0][0] = grid[0][0]
    for i := 1; i < m; i++ {
        dp[i][0][0] = grid[i][0] * dp[i-1][0][0]
        dp[i][0][1] = dp[i][0][0]
    }
    for j := 1; j < n; j++ {
        dp[0][j][0] = grid[0][j] * dp[0][j-1][0]
        dp[0][j][1] = dp[0][j][0]
    }
    for i := 1; i < m; i++ {
        for j := 1; j < n; j++ {
            if grid[i][j] > 0 {
                dp[i][j][0] =  grid[i][j] * Max(dp[i][j-1][0], dp[i-1][j][0])
                dp[i][j][1] =  grid[i][j] * Min(dp[i][j-1][1], dp[i-1][j][1])
            }else if grid[i][j] < 0 {
                dp[i][j][0] =  grid[i][j] * Min(dp[i][j-1][1], dp[i-1][j][1])
                dp[i][j][1] =  grid[i][j] * Max(dp[i][j-1][0], dp[i-1][j][0])
            }
        }
    }
    if dp[m-1][n-1][0] < 0 {
        return -1
    }
    return dp[m-1][n-1][0] % MOD
}