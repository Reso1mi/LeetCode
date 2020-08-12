func removeCoveredIntervals(intervals [][]int) int {
    sort.Slice(intervals, func(i int, j int) bool {
        if intervals[i][0] == intervals[j][0] {
            return intervals[i][1] > intervals[j][1]
        }
        return intervals[i][0] < intervals[j][0]
    })
    var Max = func(a, b int) int {
        if a > b {
            return a
        }
        return b
    }
    var count = 0
    var maxRight = intervals[0][1]
    for i := 1; i < len(intervals); i++ {
        if intervals[i][1] <= maxRight {
            count++
        }
        maxRight = Max(maxRight, intervals[i][1])
    }
    return len(intervals) - count
}
