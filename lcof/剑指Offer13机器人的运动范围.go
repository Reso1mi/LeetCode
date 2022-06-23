func movingCount(m int, n int, k int) int {
    dsum := func(a int) int {
        cnt := 0
        for a > 0 {
            cnt += a % 10
            a /= 10
        }
        return cnt
    }

    dir := []int{1, 0, -1, 0, 1}
    vis := make([]bool, m*n+1)
    var dfs func(x int, y int)
    dfs = func(x int, y int) {
        vis[x*n+y] = true
        for i := 0; i < 4; i++ {
            nx := x + dir[i]
            ny := y + dir[i+1]
            if nx < 0 || nx >= m || ny < 0 || ny >= n || vis[nx*n+ny] {
                continue
            }
            if dsum(nx)+dsum(ny) <= k {
                dfs(nx, ny)
            }
        }
    }
    dfs(0, 0)
    res := 0
    for _, v := range vis {
        if v {
            res++
        }
    }
    return res
}