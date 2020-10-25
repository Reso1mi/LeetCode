//322 -> 299
//243 -> 239
//3524 -> 499
//332 -> 299
//235854 235799
func monotoneIncreasingDigits(N int) int {
    var nums []int
    for N > 0 {
        nums = append(nums, N%10)
        N /= 10
    }
    var res = 0
    var idx = -1
    //213
    for i := 0; i < len(nums)-1; i++ {
        if nums[i] < nums[i+1] {
            idx = i
            nums[i+1]--
        }
    }
    for i := len(nums) - 1; i >= 0; i-- {
        if i <= idx {
            res = res*10 + 9
        } else {
            res = res*10 + nums[i]
        }
    }
    return res
}
