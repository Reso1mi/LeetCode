func cuttingRope(n int) int {
    if n <= 3 {
        return n - 1
    }
    // 12 = 3*3*3*3 = 81
    MOD := int(1e9 + 7)
    cnt := 0
    for n > 4 {
        n -= 3
        cnt++
    }
    res := n
    for i := 0; i < cnt; i++ {
        res = (res * 3) % MOD
    }
    return res
}