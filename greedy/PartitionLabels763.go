func partitionLabels(S string) []int {
    var m = make(map[byte]int)
    var Max = func(a, b int) int {if a>b{return a};return b}
    for i := 0; i < len(S); i++ {
        m[S[i]] = i
    }
    var start, end = 0, 0
    var res []int
    for i := 0; i < len(S); i++ {
        //更新当前区间结尾最大值
        end = Max(end, m[S[i]])
        //走到当前区间结尾，当前区间结束
        if i == end {
            res = append(res, end-start+1)
            start = i+1
        }
    }
    return res
}