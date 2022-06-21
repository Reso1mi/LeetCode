func fib(n int) int {
    if n == 0 {
        return 0
    }
    MOD := int(1e9 + 7)
    f := make([]int, n+1)
    f[0] = 0
    f[1] = 1
    for i := 2; i <= n; i++ {
        f[i] = (f[i-1] + f[i-2]) % MOD
    }
    return f[n]
}