func replaceSpace(s string) string {
    var res string
    for i := 0; i < len(s); i++ {
        if s[i] == byte(' ') {
            res = res + "%20"
        } else {
            res = res + string(s[i])
        }
    }
    return res
}