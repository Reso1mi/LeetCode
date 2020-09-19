//之前只用Java写了个记忆化的，补一下纯dp的
func findMaxForm(strs []string, m int, n int) int {
    var sn = len(strs)
    var dp = make([][]int, m+1)
    var Max = func(a, b int) int {if a>b {return a};return b}
    for i := 0; i <= m; i++ {
        dp[i] = make([]int, n+1)
    }
    for i := 0; i < sn; i++ {
        zero, one := count(strs[i])
        for j := m; j >= zero; j-- {
            for k := n; k >= one; k-- {
                dp[j][k] = Max(dp[j][k], dp[j-zero][k-one]+1)
            }
        }
    }
    return dp[m][n]
}

func count(str string) (int, int) {
    var one, zero = 0, 0
    for i := 0; i < len(str); i++ {
        if str[i] == '0' {
            zero++
        }
        if str[i] == '1' {
            one++
        }
    }
    return zero, one
}