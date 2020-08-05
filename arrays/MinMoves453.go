func minMoves(nums []int) int {
    var min = math.MaxInt32
    for i := 0; i < len(nums); i++ {
        if nums[i] < min {
            min = nums[i]
        }
    }
    var res = 0
    for i := 0; i < len(nums); i++ {
        res += (nums[i]-min)
    }
    return res
}