type StringSlice []string

func (p StringSlice) Len() int           { return len(p) }
func (p StringSlice) Less(i, j int) bool { return p[i]+p[j] > p[j]+p[i] }
func (p StringSlice) Swap(i, j int)      { p[i], p[j] = p[j], p[i] }

func largestNumber(nums []int) string {
    strs := make([]string, len(nums))
    for i, n := range nums {
        strs[i] = strconv.Itoa(n)
    }
    sort.Sort(StringSlice(strs))
    //return strings.Join(strs,"") 要去前导0...
    var res = ""
    var idx = 0
    for idx < len(strs)-1 && strs[idx] == "0" {
        idx++
    }
    for idx < len(strs) {
        res += strs[idx]
        idx++
    }
    return res
}
