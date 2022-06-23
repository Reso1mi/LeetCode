func cuttingRope(n int) int {
    f := make([]int, n+1)
    Max := func(a, b int) int {
        if a > b {
            return a
        }
        return b
    }
    f[2] = 1
    // f[i] = k * f[i-k]
    for i := 3; i <= n; i++ {
        for k := 1; k < i; k++ {
            // 只分两份，或者特殊处理2，3
            f[i] = Max(k*(i-k), Max(f[i], k*f[i-k]))
        }
    }
    return f[n]
}