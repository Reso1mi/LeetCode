//tle了，这题卡的还挺严格的
func trailingZeroes(n int) int {
    var count = 0
    for i := 1; i <= n; i++ {
        num := i
        for num%5 == 0 {
            if num%5 == 0 {
                count++
                num /= 5
            } else {
                break
            }
        }
    }
    return count
}

//每隔5个数出现一个5，每隔25个数出现一个5，每隔125个数出现一个5....
//所以因子5的个数就是： n/5 + n/25 + n/125 + n/625 + ...转换成代码就是下面这样
func trailingZeroes(n int) int {
    var count = 0
    for n > 0 {
        n /= 5
        count += n
    }
    return count
}
