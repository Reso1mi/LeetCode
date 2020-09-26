//Trick，寻找分割点，使得分割点左边的1和右边的0相加的和最少
func minFlipsMonoIncr(S string) int {
    var count0 = 0 //分割点右边的0
    var count1 = 0 //分割点左边的1
    var Min = func(a, b int) int {if a < b {return a}; return b}
    for i := 0; i < len(S); i++ {
        if S[i] == '0' {
            count0++
        }
    }
    var res = count0
    for i := 0; i < len(S); i++ {
        if S[i] == '1' {
            count1++
        } else {
            count0--
        }
        res = Min(res, count1+count0)
    }
    return res
}

//动态规划
func minFlipsMonoIncr(S string) int {
    var n = len(S)
    //dp[i][0]: [0~i] s[i]==0 需要最小额翻转次数
    //dp[i][1]: [0~i] s[i]==1 需要最小额翻转次数
    var dp = make([][2]int, n)
    var Min = func(a, b int) int {if a < b {return a}; return b}
    var preSum = make([]int, n+1)
    for i := 1; i <= n; i++ { 
        preSum[i] = preSum[i-1] + int(S[i-1]-48)
    }
    if S[0] == '1' {
        dp[0][0] = 1
    }else {
        dp[0][1] = 1
    }
    for i := 1; i < n; i++ {
        if S[i] == '1' {
            dp[i][1] = Min(dp[i-1][1], dp[i-1][0])
            dp[i][0] = preSum[i+1] //包含i
        } else {
            dp[i][0] = preSum[i] //不包含i
            dp[i][1] = Min(dp[i-1][0], dp[i-1][1]) + 1
        }
    }
    return Min(dp[n-1][1], dp[n-1][0])
}