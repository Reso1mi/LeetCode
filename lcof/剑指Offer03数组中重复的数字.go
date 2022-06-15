// func findRepeatNumber(nums []int) int {
//     bucket := make([]bool, len(nums))
//     for _, v := range nums {
//         if bucket[v] {
//             return v
//         }
//         bucket[v] = true
//     }
//     return -1
// }

func findRepeatNumber(nums []int) int {
    for i := 0; i < len(nums); i++ {
        for i != nums[i] {
            if nums[i] == nums[nums[i]] {
                return nums[i]
            }
            nums[i], nums[nums[i]] = nums[nums[i]], nums[i]
        }
    }
    return -1
}