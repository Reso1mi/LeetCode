func longestPrefix(s string) string {
    if len(s) == 1 {
        return ""
    }
    //裸KMP
    next := make([]int, len(s)+1)
    next[0] = -1
    next[1] = 0
    var left = 0
    var i = 2
    for i <= len(s) {
        if s[i-1] == s[left] {
            left++
            next[i] = left
            i++
        } else if next[left] == -1 {
            i++
        } else {
            left = next[left]
        }
    }
    return s[0:next[len(s)]]
}
