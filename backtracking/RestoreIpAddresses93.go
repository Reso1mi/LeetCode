func restoreIpAddresses(s string) []string {
    var res []string
    if len(s) < 4 || len(s) > 12 {
        return res
    }
    var dfs func(s string, lis []string)
    dfs = func(s string, lis []string) {
        if s == "" {
            if len(lis) == 4 {
                res = append(res, strings.Join(lis, "."))
            }
            return
        }
        //s未遍历完就集齐了4块
        if len(lis) >= 4 {
            return
        }
        for i := 1; i <= 3; i++ {
            if i <= len(s) && check(s[:i]) {
                lis = append(lis, s[:i])
                dfs(s[i:], lis)
                lis = lis[:len(lis)-1]
                //前导0的处理，读取0之后就不再向后扩展
                if s[:i] == "0" {
                    return
                }
            }
        }
    }
    dfs(s, []string{})
    return res
}

func check(s string) bool {
    if ns, _ := strconv.Atoi(s); ns <= 255 {
        return true
    }
    return false
}
