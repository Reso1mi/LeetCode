func hasAllCodes(s string, k int) bool {
    var set = make(map[int]bool)
    var left = 0
    var cur = 0
    for right := 0; right < len(s); right++ {
        cur = cur*2 + int(s[right]&1)
        for right-left+1 > k {
            cur &= ^(1 << k) //将首位置为0
            left++
        }
        if right-left+1 == k {
            set[cur] = true
        }
    }
    return len(set) == 1<<k
}
