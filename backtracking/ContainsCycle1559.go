func containsCycle(grid [][]byte) bool {
    var m, n = len(grid), len(grid[0])
    var dir = [4][2]int{{0,1},{1,0},{-1,0},{0,-1}}
    var visit = make([][]bool, m)
    for i := 0; i < m; i++ {
        visit[i] = make([]bool, n)
    }
    var valid = func(x, y int) bool { return x >= 0 && x < m && y >= 0 && y < n}
    var dfs func (int, int, int, int)
    var res = false
    dfs = func(preX int, preY int, x int, y int) {
        if visit[x][y] || res{
            res = true
            return
        }
        visit[x][y] = true
        for i := 0; i < len(dir); i++ {
            nx := x + dir[i][0]
            ny := y + dir[i][1]
            //不走回头路
            if nx == preX && ny == preY {
                continue
            }
            if valid(nx, ny) && grid[nx][ny] == grid[x][y] {
                dfs(x, y, nx, ny)
            }
        }
    }
    for i := 0; i < m; i++ {
        for j := 0; j < n; j++ {
            if !visit[i][j] {
                dfs(i,j,i,j)
            }
        }
    }
    return res
}