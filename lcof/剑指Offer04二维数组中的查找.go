func findNumberIn2DArray(matrix [][]int, target int) bool {
    n := len(matrix)
    if n == 0 {
        return false
    }
    m := len(matrix[0])
    x, y := 0, m-1
    for x < n && y >= 0 {
        if target > matrix[x][y] {
            x++
        } else if target < matrix[x][y] {
            y--
        } else {
            return true
        }
    }
    return false
}