func PredictTheWinner(nums []int) bool {
    var Max = func(a, b int) int {if a > b {return a};return b}
    var n = len(nums)
    var preSum = make([]int, n+1)
    for i := 1; i <= n; i++ {
        preSum[i] = preSum[i-1] + nums[i-1]
    }
    //记忆化
    var dp = make([][]int, n)
    for i := 0; i < n; i++ {
        dp[i] = make([]int, n)
        for j := 0; j < n; j++ {
            dp[i][j] = -1
        }
    }
    var dfs func(i int, j int) int
    dfs = func(i int, j int) int {
        if dp[i][j] != -1 {
            return dp[i][j]
        }
        if i == j {
            return nums[i]
        }
        //区间和
        sum := preSum[j+1] - preSum[i]
        dp[i][j] = Max(sum-dfs(i+1, j), sum-dfs(i, j-1))
        return dp[i][j]
    }
    A := dfs(0, n-1)
    return A >= preSum[n]-A
}

func PredictTheWinner(nums []int) bool {
    var n = len(nums)
    var dp = make([][]int, n)
    var Max = func(a,b int) int {if a>b {return a};return b}
    for i := 0; i < n; i++ {
        dp[i] = make([]int, n)
        dp[i][i] = nums[i]
    }
    var preSum = make([]int, n+1)
    for i := 1; i <= n; i++ {
        preSum[i] = preSum[i-1] + nums[i-1]
    }
    for tlen := 2; tlen <= n; tlen++ {
        for left := 0; left+tlen-1 < n; left++ {
            right := left+tlen-1
            sum := preSum[right+1]-preSum[left]
            dp[left][right] = Max(sum-dp[left][right-1], sum-dp[left+1][right])
        }
    }
    return dp[0][n-1] >= preSum[n]-dp[0][n-1]
}