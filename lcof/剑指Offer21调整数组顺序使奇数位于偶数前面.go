func exchange(nums []int) []int {
    i, j := 0, len(nums)-1
    for i < j {
        for nums[i]&1 == 1 && i < j {
            i++
        }
        for nums[j]&1 == 0 && i < j {
            j--
        }
        if i >= j {
            break
        }
        nums[i], nums[j] = nums[j], nums[i]
    }
    return nums
}