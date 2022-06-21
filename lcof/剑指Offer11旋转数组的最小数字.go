// 2 2 1 2 2
// 1 2 3 4 5 --> 3 4 5 1 2
func minArray(numbers []int) int {
    n := len(numbers)
    left, right := 0, n-1
    for numbers[left] == numbers[right] && left < right {
        left++
    }
    if left == n {
        return numbers[0]
    }

    ans := left
    for left <= right {
        mid := left + (right-left)/2
        // WA: numbers[mid] <= numbers[right]
        if numbers[mid] <= numbers[n-1] {
            ans = mid
            right = mid - 1
        } else {
            left = mid + 1
        }
    }
    return numbers[ans]
}