func equalSubstring(s string, t string, maxCost int) int {
    left := 0
    cost := 0
    res := 0
    for right := 0; right < len(s); right++ {
        cost += getCost(s[right], t[right])
        if cost <= maxCost {
            res = max(res, right-left+1)
        } else {
            cost -= getCost(s[left], t[left])
            left++
        }
    }
    return res
}

func equalSubstring2(s string, t string, maxCost int) int {
    left := 0
    cost := 0
    res := 0
    for right := 0; right < len(s); right++ {
        cost += getCost(s[right], t[right])
        for cost > maxCost {
            cost -= getCost(s[left], t[left])
            left++
        }
        res = max(res, right-left+1)
    }
    return res
}

func getCost(a, b byte) int {
    if a < b { //a-b<0 byte是uint8直接这样减会变成正数
        return int(b - a)
    }
    return int(a - b)
}

func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}
