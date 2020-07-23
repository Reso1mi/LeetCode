//滑动窗口的做法
func findRadius(houses []int, heaters []int) int {
    heaters = append(heaters, math.MaxInt32)
    heaters = append(heaters, math.MinInt32)
    sort.Ints(heaters)
    sort.Ints(houses)
    var n = len(heaters)
    var Min = func (a, b int) int { if a < b {return a}; return b}
    var Max = func (a, b int) int { if a < b {return b}; return a}
    var res = 0
    var left = 0
    for _, h := range houses {
        for left < n && heaters[left] < h {
            left++
        }
        res = Max(res, Min(heaters[left]-h, h-heaters[left-1]))
    }
    return res
}

//二分做法
func findRadius(houses []int, heaters []int) int {
    sort.Ints(heaters)
    var n = len(heaters)
    var Min = func (a, b int) int { if a < b {return a}; return b}
    var Max = func (a, b int) int { if a < b {return b}; return a}
    var res = 0
    for _, h := range houses{
        left := search(heaters, h)
        if left == -1{ //全部大于hourse,取最小的那个
            res = Max(res, heaters[0]-h)
        }else if left+1 < n{
            res = Max(res, Min(h-heaters[left], heaters[left+1]-h))
        }else{
            res = Max(res, h-heaters[left])
        }
    }
    return res
}

//target左边最近的一个
func search(heaters []int, target int) int {
    var left, right = 0, len(heaters)-1
    var res = -1 //左边没有供暖器
    for left <= right {
        mid := left + (right-left)/2
        if heaters[mid] <= target{
            res = mid
            left = mid + 1
        }else{
            right = mid - 1
        }
    }
    return res
}

//优化边界处理逻辑
func findRadius(houses []int, heaters []int) int {
    heaters = append(heaters, math.MaxInt32)
    heaters = append(heaters, math.MinInt32)
    sort.Ints(heaters)
    var Min = func (a, b int) int { if a < b {return a}; return b}
    var Max = func (a, b int) int { if a < b {return b}; return a}
    var res = 0
    for _, h := range houses{
        left := search(heaters, h)
        res = Max(res, Min(h-heaters[left], heaters[left+1]-h))
    }
    return res
}

//target左边最近的一个
func search(heaters []int, target int) int {
    var left, right = 0, len(heaters)-1
    var res = left //左边没有供暖器
    for left <= right {
        mid := left + (right-left)/2
        if heaters[mid] <= target{
            res = mid
            left = mid + 1
        }else{
            right = mid - 1
        }
    }
    return res
}


//wrong answer
func findRadius(houses []int, heaters []int) int {
    var n = len(houses)
    var left, right = 0, math.MaxInt32
    var start, end = houses[0], houses[n-1]
    var res = right
    for left <= right {
        mid := left + (right-left)/2
        if check(heaters, mid, start, end) {
            res = mid
            right = mid - 1
        } else {
            left = mid + 1
        }
    }
    return res
}

func check(hea []int, target int, start int, end int) bool {
    var last int64 = start - 1
    for _, h := range hea {
        if h-target > last+1 { //断层了，接不上
            return false
        }
        if h+target > last {
            last = h + target
        }
        if last >= end {
            return true
        }
    }
    return last >= end
}
