func findSubsequences(nums []int) [][]int {
    var n = len(nums)
    var res [][]int
    var dfs func(int, []int)
    dfs = func(index int, lis []int) {
        if len(lis) >= 2 {
            dest := make([]int, len(lis))
            copy(dest, lis)
            res = append(res, dest)
        }
        //保证一次for循环中没有重复的就行了，根据取值范围做下偏移
        var visit = make([]bool, 201)
        for i := index; i < n; i++ {
            if !visit[nums[i]+100] && (len(lis) == 0 || nums[i] >= lis[len(lis)-1]) {
                visit[nums[i]+100] = true
                lis = append(lis, nums[i])
                dfs(i+1, lis)
                lis = lis[:len(lis)-1]
            }
        }
    }
    dfs(0, make([]int, 0))
    return res
}
