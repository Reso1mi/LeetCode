//按照终点排序
func findMinArrowShots(points [][]int) int {
    if len(points) <= 0 {
        return 0
    }
    sort.Slice(points, func(i int, j int) bool {
        return points[i][1] < points[j][1]
    })
    //当前这一箭能射穿前面所有气球的最远距离
    var end = points[0][1]
    var res = 1
    for i := 1; i < len(points); i++ {
        if points[i][0] > end {
            res++
            end = points[i][1]
        }
    }
    return res
}

func Min(a, b int) int {
    if a > b {
        return b
    }
    return a
}

//按照起点排序
func findMinArrowShots(points [][]int) int {
    if len(points) <= 0 {
        return 0
    }
    sort.Slice(points, func(i int, j int) bool {
        return points[i][0] < points[j][0]
    })
    //当前这一箭能射穿前面所有气球的最远距离
    var end = points[0][1]
    var res = 1
    for i := 1; i < len(points); i++ {
        if points[i][0] > end {
            res++
            end = points[i][1]
        }else{
            end = Min(end, points[i][1])
        }
    }
    return res
}