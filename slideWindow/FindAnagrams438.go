func findAnagrams(s string, p string) []int {
    var target = make([]int, 128)
    var window = make([]int, 128)
    var match = 0
    for _, sp := range p {
        if target[sp] == 0 {
            match++
        }
        target[sp]++
    }
    var left = 0
    var count = 0
    var res []int
    for right := 0; right < len(s); right++ {
        if target[s[right]] > 0 {
            window[s[right]]++
            if window[s[right]] == target[s[right]] {
                count++
            }
        }
        for count == match && left <= right {
            if right-left+1 == len(p) {
                res = append(res, left)
            }
            if window[s[left]] > 0 {
                window[s[left]]--
                if window[s[left]] < target[s[left]] {
                    count--
                }
            }
            left++
        }
    }
    return res
}

func findAnagrams(s string, p string) []int {
    var left = 0
    //-'a'看起来太丑了，直接128
    var target [128]int //注意用数组，可以直接比较
    var window [128]int
    for _, sp := range p {
        target[sp]++
    }
    var res []int
    for right := 0; right < len(s); right++ {
        if target[s[right]] > 0 {
            window[s[right]]++
        }
        for right-left+1 > len(p) {
            if window[s[left]] > 0 {
                window[s[left]]--
            }
            left++
        }
        if window == target {
            res = append(res, left)
        }
    }
    return res
}
