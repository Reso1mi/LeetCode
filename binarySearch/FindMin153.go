func findMin(nums []int) int {
    var n = len(nums)
    var left, right = 0, n - 1
    var res = right
    for left <= right {
        mid := left + (right-left)/2
        if nums[mid] < nums[n-1] {
            res = mid
            right = mid - 1
        } else {
            left = mid + 1
        }
    }
    return nums[res]
}
