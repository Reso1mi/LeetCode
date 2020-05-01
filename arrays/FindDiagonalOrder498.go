//借助额外空间
func findDiagonalOrder(matrix [][]int) []int {
    var res []int
    m := len(matrix)
    if matrix == nil || m == 0 {
        return res
    }
    n := len(matrix[0])
    hmap := make(map[int][]int)
    flagRow := false //行开头标志位
    for i, row := range matrix {
        flagColumn := flagRow //列标志位
        for j, num := range row {
            if flagColumn {
                hmap[i+j] = append(hmap[i+j], num)
            } else {
                hmap[i+j] = append([]int{num}, hmap[i+j]...)
            }
            flagColumn = !flagColumn
        }
        flagRow = !flagRow
    }
    for i := 0; i <= m*n; i++ {
        res = append(res, hmap[i]...)
    }
    return res
}

//比较好的解法
func findDiagonalOrder(matrix [][]int) []int {
    var res []int
    m := len(matrix)
    if matrix == nil || m == 0 {
        return res
    }
    n := len(matrix[0])
    leftX := 0
    leftY := 0
    rightX := 0
    rightY := 0
    flag := true
    //左右端点沿着矩形边缘移动就行了
    for leftX < m && leftY < n {
        help(matrix, leftX, leftY, rightX, rightY, flag, &res)
        if leftX == m-1 { //左端点到达边界
            leftY++
        } else {
            leftX++
        }
        if rightY == n-1 { //右端点到达边界
            rightX++
        } else {
            rightY++
        }
        flag = !flag //反转
    }
    return res
}

//获取 (lx,ly) 和 (rx,ry)之间的点
func help(matrix [][]int, lx, ly, rx, ry int, flag bool, res *[]int) {
    for lx >= rx && ly <= ry {
        if flag {
            *res = append(*res, matrix[lx][ly])
            lx--
            ly++
        } else {
            *res = append(*res, matrix[rx][ry])
            rx++
            ry--
        }
    }
}
