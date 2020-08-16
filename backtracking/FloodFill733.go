func floodFill(image [][]int, sr int, sc int, newColor int) [][]int {
    var m = len(image)
    var n = len(image[0])
    var dir = []int{1, 0, -1, 0, 1}
    var visit = make([][]bool, m)
    for i := 0; i < m; i++ {
        visit[i] = make([]bool, n)
    }
    var src = image[sr][sc]
    var valid = func(x int, y int) bool {
        return x >= 0 && x < m && y >= 0 && y < n
    }
    var dfs func(x int, y int)
    dfs = func(x int, y int) {
        visit[x][y] = true
        image[x][y] = newColor
        for i := 0; i < 4; i++ {
            var nx = x + dir[i]
            var ny = y + dir[i+1]
            if valid(nx, ny) && !visit[nx][ny] && image[nx][ny] == src {
                dfs(nx, ny)
            } 
        }
    }
    dfs(sr, sc)
    return image
}

//通过染色的情况判断是否遍历过节点，节省visit数组
func floodFill(image [][]int, sr int, sc int, newColor int) [][]int {
    var m = len(image)
    var n = len(image[0])
    var dir = []int{1, 0, -1, 0, 1}
    var src = image[sr][sc]
    var valid = func(x int, y int) bool {
        return x >= 0 && x < m && y >= 0 && y < n
    }
    var dfs func(x int, y int)
    dfs = func(x int, y int) {
        image[x][y] = newColor
        for i := 0; i < 4; i++ {
            var nx = x + dir[i]
            var ny = y + dir[i+1]
            if valid(nx, ny) && image[nx][ny]!=newColor && image[nx][ny] == src {
                dfs(nx, ny)
            } 
        }
    }
    dfs(sr, sc)
    return image
}