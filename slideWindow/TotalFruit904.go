func totalFruit(tree []int) int {
    var left = 0
    var Max = func (a, b int) int {if a>b {return a};return b}
    var n = len(tree)
    var freq [40001]int
    var res, count = 0, 0
    for right := 0; right < n; right++ {
        if freq[tree[right]] == 0 {
            count++
        }
        freq[tree[right]]++
        for count > 2 {
            freq[tree[left]]--
            if freq[tree[left]] == 0 {
                count--
            }
            left++
        }
        res = Max(res, right-left+1)
    }
    return res
}