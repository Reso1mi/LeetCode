func countBinarySubstrings(s string) int {
    var n = len(s)
    var last, cur = 0, 0
    var res = 0
    var Min = func (a, b int) int {if a<b {return a};return b}
    var p = 0
    for p < n {
        c := s[p]
        for p < n && s[p] == c {
            p++
            cur++
        }
        res += Min(cur, last)
        last = cur
        cur = 0
    }
    return res
}