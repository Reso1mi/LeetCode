func commonChars(A []string) []string {
    var m = make(map[int]map[byte]int)

    var max = 0
    for i := 0; i < len(A); i++ {
        m[i] = make(map[byte]int)
        for j := 0; j < len(A[i]); j++ {
            m[i][A[i][j]]++
        }
        if len(A[i]) > len(A[max]) {
            max = i
        }
    }
    var res []string
    for i := 0; i < len(A[max]); i++ {
        var flag = true
        for j := 0; j < len(A); j++ {
            if j == max {
                continue
            }
            if m[j][A[max][i]] == 0 {
                flag = false
                break
            }
            m[j][A[max][i]]--
        }
        if flag {
            res = append(res, string(A[max][i]))
        }
    }
    return res
}
