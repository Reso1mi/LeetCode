
//###解法一：
//正向dp，60ms
func respace(dictionary []string, sentence string) int {
    var dict = make(map[string]bool)
    for i := 0; i < len(dictionary); i++ {
        dict[dictionary[i]] = true
    }
    var n = len(sentence)
    //(0 ~ i)
    var dp = make([]int, n+1)
    for i := 1; i <= n; i++ {
        dp[i] = dp[i-1] + 1 //初始值
        for j := 0; j < i; j++ {
            if dict[sentence[j:i]] {
                dp[i] = Min(dp[j], dp[i])
            }
        }
    }
    return dp[n]
}

func Min(a, b int) int {
    if a < b {
        return a
    }
    return b
}

//###解法二：
//记忆化dfs tle了 可能思路有点问题
//确实是思路出了问题，下面补充了正确的记忆化写法 248ms
func respace(dictionary []string, sentence string) int {
    var dict = make(map[string]bool)
    for i := 0; i < len(dictionary); i++ {
        dict[dictionary[i]] = true
    }
    var cache = make(map[string]int)
    return dfs(sentence, dict, cache)
}

// func dfs(s string, dict map[string]bool, cache map[string]int) int {
//     if _, ok := cache[s]; ok {
//         return cache[s]
//     }
//     var res = len(s)
//     for i := 0; i <= len(s); i++ {
//         temp := len(s)
//         for j := i + 1; j <= len(s); j++ {
//             if dict[s[i:j]] {
//                 temp = Min(temp, dfs(s[j:], dict, cache))
//             }
//         }
//         res = Min(res, temp+i)
//     }
//     cache[s] = res
//     return res
// }

func dfs(s string, dict map[string]bool, cache map[string]int) int {
    if _, ok := cache[s]; ok {
        return cache[s]
    }
    var res = len(s)
    for i := 1; i <= len(s); i++ {
        if dict[s[:i]] {
            res = Min(res, dfs(s[i:], dict, cache))
        }else{
            res = Min(res, dfs(s[i:], dict, cache) + i)
        }
    }
    cache[s] = res
    return res
}

func Min(a, b int) int {
    if a < b {
        return a
    }
    return b
}

//解法三
//字典树 + dp ，用golang几乎感觉不到提升，主要是切片切分字符的时间复杂度是O(1)的
func respace(dictionary []string, s string) int {
    var trie = &Node{}
    for i := 0; i < len(dictionary); i++ {
        //逆序插入前缀树
        trie.insert(dictionary[i])
    }
    var n = len(s)
    //(0 ~ i)的最小字符数
    var dp = make([]int, n+1)
    for i := 1; i <= n; i++ {
        dp[i] = dp[i-1] + 1 //初始值
        cur := trie
        for j := i-1; j >=0 ; j-- {
            //很大的一步优化，后缀不存在，所以前面的肯定都不存在
            if cur.next[s[j]-'a'] == nil{
                break
            }
            if cur.next[s[j]-'a'].isWord {
                dp[i] = Min(dp[j], dp[i])
            }
            if dp[i] == 0{
                break
            }
            cur = cur.next[s[j]-'a']
        }
    }
    return dp[n]
}

func Min(a, b int) int {
    if a < b {
        return a
    }
    return b
}

type Node struct {
    next   [26]*Node
    isWord bool
}

func (root *Node) insert(s string) {
    var cur = root
    for i := len(s) - 1; i >= 0; i-- {
        if cur.next[s[i]-'a'] == nil {
            cur.next[s[i]-'a'] = &Node{}
        }
        cur = cur.next[s[i]-'a']
    }
    cur.isWord = true
}

/*func (root *Node) contains(s string) bool {
    var cur = root
    for i := len(s) - 1; i >= 0; i-- {
        if cur.next[s[i]-'a'] == nil {
            return false
        }
        cur = cur.next[s[i]-'a']
    }
    return cur.isWord
}*/
