func minCost(n int, cut []int) int {
    sort.Ints(cut)
    //在前后加上0和n
    cut = append(cut, n)
    cut = append([]int{0}, cut...)
    var Min = func(a,b int) int {if a<b {return a};return b}
    var m = len(cut)
    //dp[i][j]切割i,j的成本
    var dp = make([][]int, m)
    for i := 0; i < m; i++ {
        dp[i] = make([]int, m)
        if i < m-1 {
            dp[i][i+1] = 0   
        }
    }
    for tlen := 2; tlen <= m; tlen++ {
        for left := 0; left+tlen < m; left++ {
            right := left+tlen //注意这里不加1
            dp[left][right] = math.MaxInt32
            for k := left+1; k < right; k++ {
                dp[left][right] = Min(dp[left][right], dp[left][k]+dp[k][right]+cut[right]-cut[left])
            }
        }
    }
    return dp[0][m-1]
}