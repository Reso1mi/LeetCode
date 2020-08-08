func palindromePairs(words []string) [][]int {
    var dict = make(map[string]int)
    for i := 0; i < len(words); i++ {
        dict[reverse(words[i])] = i
    }
    var res [][]int
    for i := 0; i < len(words); i++ {
        for j := 0; j <= len(words[i]); j++ {
            if idx, ok := dict[words[i][:j]]; ok && idx != i && isPalindrome(words[i][j:]) {
                res = append(res, []int{i, idx})
            }
            //这里需要判断下j!=0，避免重复的判断，s[0:] == s[:len(s)]
            if idx, ok := dict[words[i][j:]]; j != 0 && ok && idx != i && isPalindrome(words[i][:j]) {
                res = append(res, []int{idx, i})
            }
        }
    }
    return res
}

func reverse(s string) string {
    var bs = []byte(s)
    for i, j := 0, len(bs)-1; i < j; i, j = i+1, j-1 {
        bs[i], bs[j] = bs[j], bs[i]
    }
    return string(bs)
}

func isPalindrome(s string) bool {
    for i, j := 0, len(s)-1; i < j; i, j = i+1, j-1 {
        if s[i] != s[j] {
            return false
        }
    }
    return true
}
