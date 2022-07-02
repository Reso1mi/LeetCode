// n很大的情况下，ans会爆栈，原题只是打印就无所谓了
func printNumbers(n int) []int {
    var ans []string
    var NUM = []string{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}
    var dfs func(string, int)
    dfs = func(s string, tlen int) {
        x := len(s)
        if x == tlen {
            ans = append(ans, s)
            return
        }
        t := 0
        if x == 0 {
            t = 1 // 不允许0开头
        }
        for i := t; i < 10; i++ {
            s += NUM[i]
            dfs(s, tlen)
            s = s[:len(s)-1]
        }
    }
    for i := 1; i <= n; i++ {
        dfs("", i)
    }
    res := make([]int, len(ans))
    for i, v := range ans {
        res[i], _ = strconv.Atoi(v)
    }
    return res
}