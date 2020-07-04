func longestValidParentheses1(s string) int {
    var dp = make([]int, len(s)) //以s[i]结尾的最长有效括号
    //dp[0] = 0
    var res = 0
    for i := 1; i < len(s); i++ {
        if s[i] == ')' {
            if i-dp[i-1]-1 >= 0 && s[i-dp[i-1]-1] == '(' {
                dp[i] = dp[i-1] + 2
                if i-dp[i-1]-2 >= 0 {
                    dp[i] += dp[i-dp[i-1]-2]
                }
            }
        }
        res = Max(res, dp[i])
    }
    return res
}

//实时统计左右括号的个数，当匹配的时候统计长度，记得左右都要扫一遍
func longestValidParentheses(s string) int {
    var left, right = 0, 0
    var res = 0
    for i := 0; i < len(s); i++ {
        if s[i] == '(' {
            left++
        } else {
            right++
        }
        if right > left {
            right, left = 0, 0
        }else if right == left {
            res = Max(res, left*2)
        }
    }
    right, left = 0, 0
    for i := len(s) - 1; i >= 0; i-- {
        if s[i] == '(' {
            left++
        } else {
            right++
        }
        if right < left {
            right, left = 0, 0
        } else if right == left {
            res = Max(res, left*2)
        }
    }
    return res
}

func Max(a, b int) int {
    if a > b {
        return a
    }
    return b
}
