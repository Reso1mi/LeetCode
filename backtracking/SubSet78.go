func subsets(nums []int) [][]int {
    var n = len(nums)
    var res [][]int
    for i := 0; i < (1<<n); i++ {
        var lis []int
        for j := 0; j < n; j++ {
            if i & (1<<j) != 0 {
                lis = append(lis, nums[j])
            }
        }
        res = append(res, lis)
    }
    return res
}