func uniquePathsWithObstacles(grid [][]int) int {
    var m = len(grid)
    var n = len(grid[0])
    var dp = make([][]int, m+1)
    for i := 0; i <= m; i++ {
        dp[i] = make([]int, n+1)
    }
    dp[0][1] = 1 //初始值
    for i := 1; i <= m; i++ {
        for j := 1; j <= n; j++ {
            if grid[i-1][j-1] != 1 {
                dp[i][j] = dp[i-1][j] + dp[i][j-1]
            }
        }
    }
    return dp[m][n]
}

func uniquePathsWithObstacles(grid [][]int) int {
    var m = len(grid)
    var n = len(grid[0])
    var dp = make([]int, n)
    dp[0] = 1
    for i := 0; i < m; i++ {
        for j := 0; j < n; j++ {
            if grid[i][j] == 1 {
                dp[j] = 0
                continue
            }
            if i == 0 && j > 0{
                dp[j] = dp[j-1]
            }else if j != 0{
                dp[j] = dp[j-1] + dp[j]
            }
        }
    }
    return dp[n-1]
}