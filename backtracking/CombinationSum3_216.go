//二进制枚举子集的做法
func combinationSum3(k int, n int) [][]int {
    var res [][]int
    for i := 0; i < (1<<9); i++ {
        var sum, cnt = 0, 0
        var lis []int
        for j := 0; j < 9; j++ {
            if i & (1<<j) != 0 {
                sum += j+1
                cnt++
                lis = append(lis, j+1)
            }
        }
        if sum == n && cnt == k {
            res = append(res, lis)   
        }
    }
    return res
}