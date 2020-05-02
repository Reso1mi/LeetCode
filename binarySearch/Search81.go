func search(nums []int, target int) bool {
    n := len(nums)
    if n == 0 {
        return false
    }
    left := 0
    right := n - 1
    for left < right {
        mid := left + (right-left)/2 + 1
        if nums[mid] > nums[right] { //左半边
            //target在[left,mid)的有序区间内
            if nums[left] <= target && target < nums[mid] {
                right = mid - 1
            } else {
                left = mid
            }
        } else if nums[mid] < nums[right] {
            //target在[mid,right]
            if nums[mid] <= target && target <= nums[right] {
                left = mid
            } else {
                right = mid - 1
            }
        } else {
            //mid==right看right是不是target
            if nums[right] == target {
                return true
            }
            right--
        }
    }
    return nums[left] == target
}
