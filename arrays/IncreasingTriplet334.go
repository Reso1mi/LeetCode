//https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/
func increasingTriplet(nums []int) bool {
    var INT_MAX = int(^uint(0) >> 1)
    var n = len(nums)
    var a = INT_MAX
    var b = INT_MAX
    for i := 0; i < n; i++ {
        if nums[i] <= a {
            a = nums[i]
            //b = a 这里不用更新次小值，因为我们要保证a在b前面
        } else if nums[i] <= b {
            b = nums[i]
        } else {
            return true
        }
    }
    return false
}
