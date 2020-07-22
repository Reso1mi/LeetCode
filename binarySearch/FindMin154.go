//先对尾部去重，再二分会清晰很多
func minArray(numbers []int) int {
    var n = len(numbers)
    var left = 0
    var right = n - 1
    //尾部去重
    for right >= 1 && numbers[right] == numbers[right-1] {
        right--
    }
    var res = right
    for left <= right {
        mid := left + (right-left)/2
        //去重后min一定是小于numbers[n-1]的
        if numbers[mid] < numbers[n-1] {
            res = mid
            right = mid - 1
        } else {
            left = mid + 1
        }
    }
    return numbers[res]
}
