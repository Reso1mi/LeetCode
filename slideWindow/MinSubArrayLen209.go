var INF = 1 << 31

func minSubArrayLen(s int, nums []int) int {
    left := 0
    sum := 0
    res := INF
    for right := 0; right < len(nums); right++ {
        sum += nums[right]
        for sum >= s {
            res = Min(res, right-left+1)
            sum -= nums[left]
            left++
        }
    }
    if res == INF {
        return 0
    }
    return res
}

func Min(a, b int) int {
    if a < b {
        return a
    }
    return b
}
