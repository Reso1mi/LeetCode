var parent []int

func union(a int, b int) bool {
    pa := find(a)
    pb := find(b)
    if pa == pb {
        return false
    }
    parent[pa] = pb
    return true
}

func find(a int) int {
    if parent[a] == a {
        return a
    }
    parent[a] = find(parent[a])
    return parent[a]
}

func findRedundantConnection(edges [][]int) []int {
    var n = len(edges)
    parent = make([]int, n+1)
    for i := 1; i <= n; i++ {
        parent[i] = i
    }
    for i := 0; i < n; i++ {
        if !union(edges[i][0], edges[i][1]) {
            return edges[i]
        }
    }
    return []int{}
}