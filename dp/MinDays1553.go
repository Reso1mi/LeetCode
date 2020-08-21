var dp = make(map[int]int)

func minDays(n int) int {
    if n == 1 || n == 0 {
        return n
    }
    if v, ok := dp[n]; ok {
        return v
    }
    res := 1+Min(minDays(n/2)+n%2, minDays(n/3)+n%3)
    dp[n] = res
    return res
}

func Min (a, b int) int {
    if a < b {
        return a
    }
    return b
}