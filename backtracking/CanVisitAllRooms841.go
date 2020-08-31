func canVisitAllRooms(rooms [][]int) bool {
    var n = len(rooms)
    var visit = make([]bool, n)
    var dfs func(int)
    var count = 0
    dfs = func(idx int) {
        visit[idx] = true
        count++
        for i := 0; i < len(rooms[idx]); i++ {
            if !visit[rooms[idx][i]] {
                dfs(rooms[idx][i])   
            }
        }
    }
    dfs(0)
    return count == n
}