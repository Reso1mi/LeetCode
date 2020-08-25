//记忆化
func winnerSquareGame(n int) bool {
    var T, F = true, false
    var dfs func(int) bool
    var dp = make([]*bool, 100001)
    //先手拿x^2个石头
    dfs = func (n int) bool {
        if dp[n] != nil {
            return *dp[n]
        }
        if n == 0 {
            return F
        }
        for i := 1; i*i <= n; i++{
            if !dfs(n-i*i) {
                dp[n] = &T
                return T
            }
        }
        dp[n] = &F
        return F
    }
    return dfs(n)
}

//递推
func winnerSquareGame(n int) bool {
    var dp = make([]bool, 100001)
    dp[0] = false
    for i := 1; i <= n; i++ {
        for j := 1; j*j <= i; j++ {
            if !dp[i-j*j] {
                dp[i] = true
                break
            }
        }
    }
    return dp[n]
}