//最长公共前缀
//1011 011 m
//1011 100
//1011 101
//1011 110 n
func rangeBitwiseAnd(m int, n int) int {
    var tlen = 0
    for m != n {
        m >>= 1
        n >>= 1
        tlen++
    }
    return m << tlen
}

func rangeBitwiseAnd(m int, n int) int {
    for n > m {
        n &= (n-1)
    }
    return n
}