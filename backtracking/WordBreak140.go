//记忆化递归
func wordBreak(s string, wordDict []string) []string {
    var set = make(map[string]bool)
    var cache = make(map[string][]string)
    for i := 0; i < len(wordDict); i++ {
        set[wordDict[i]] = true
    }
    return dfs(s, set, cache)
}

func dfs(s string, set map[string]bool, cache map[string][]string) []string {
    if _, ok := cache[s]; ok {
        return cache[s]
    }
    var res []string
    for i := 1; i <= len(s); i++ {
        if set[s[:i]] {
            if i == len(s) {
                res = append(res, s[:i])
            } else {
                temp := dfs(s[i:], set, cache)
                for _, w := range temp {
                    res = append(res, s[:i]+" "+w)
                }
            }
        }
    }
    cache[s] = res
    return res
}
