func findDiagonalOrder(nums [][]int) []int {
    //最大的行列值
    n := 0
    m := make(map[int][]int)
    for i, row := range nums {
        for j, num := range row {
            //逆序添加
            m[i+j] = append([]int{num}, m[i+j]...)
            n = max(n, i+j)
        }
    }
    //res := make([]int, n)
    var res []int
    for i := 0; i <= n; i++ {
        res = append(res, m[i]...)
    }
    return res
}

func max(a, b int) int {
    if a < b {
        return b
    }
    return a
}
