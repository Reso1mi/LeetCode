
func exist(board [][]byte, word string) bool {
    n, m := len(board), len(board[0])
    var dir = []int{1, 0, -1, 0, 1}
    var dfs func(int, int, int) bool
    var vis = make([]bool, m*n+1)
    dfs = func(x int, y int, idx int) bool {
        if idx == len(word)-1 {
            return true
        }
        // WA: vis[x*n+y]
        vis[x*m+y] = true
        for i := 0; i < 4; i++ {
            nx := x + dir[i]
            ny := y + dir[i+1]
            if nx < 0 || nx >= n || ny < 0 || ny >= m {
                continue
            }
            if !vis[nx*m+ny] && board[nx][ny] == word[idx+1] && dfs(nx, ny, idx+1) {
                return true
            }
        }
        vis[x*m+y] = false
        return false
    }

    for i, t := range board {
        for j, w := range t {
            if w == word[0] {
                if dfs(i, j, 0) {
                    return true
                }
            }
        }
    }
    return false
}