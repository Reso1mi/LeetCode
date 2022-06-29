// 101011
// 101010 = 101010
//          101001 = 101000
func hammingWeight(num uint32) int {
    cnt := 0
    for num > 0 {
        num &= (num - 1)
        cnt++
    }
    return cnt
}