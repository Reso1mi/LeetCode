func findCheapestPrice(n int, flights [][]int, src int, dst int, K int) int {
    //dp[i][k]：从src到i节点中转k次最短距离
    var Min = func(a, b int) int {if a<b {return a};return b}
    var INF = 0x3f3f3f3f
    var dp = make([][]int, n)
    for i := 0; i < n; i++ {
        //K+2是为了方便初始化，不用单独处理不中转的情况
        dp[i] = make([]int, K+2)
        for j := 0; j <= K+1; j++ {
            dp[i][j] = INF   
        }
    }
    for k := 0; k <= K+1; k++ {
        dp[src][k] = 0
    }
    //k==1就是不中转的情况
    for k := 1; k <= K+1; k++ {
        for _,flt := range flights {
            //src到flt[1]通过flt[0]中转
            dp[flt[1]][k] = Min(dp[flt[1]][k], dp[flt[0]][k-1]+flt[2])
        }
    }
    if dp[dst][K+1] == INF {
        return -1
    }
    return dp[dst][K+1]
}