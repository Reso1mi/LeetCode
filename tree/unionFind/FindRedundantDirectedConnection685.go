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

func judge(edges [][]int, k int) bool {
    parent = make([]int, len(edges)+1)
    for i := 1; i <= len(edges); i++ {
        parent[i] = i
    }
    for i := 0; i < len(edges); i++ {
        if i == k {
            continue
        }
        if !union(edges[i][0], edges[i][1]) {
            return false
        }
    }
    return true
}

func findRedundantDirectedConnection(edges [][]int) []int {
    var n = len(edges)
    var indegree = make([]int, n+1)
    for i := 1; i <= n; i++ {
        indegree[edges[i-1][1]]++
    }
    for i := n-1; i >= 0; i-- {
        if indegree[edges[i][1]] == 2 {
            //删除该边
            if judge(edges, i) {
                return edges[i]
            }
        }
    }
    for i := n-1; i >= 0; i-- {
        if indegree[edges[i][1]] == 1 {
            if judge(edges, i) {
                return edges[i]
            }
        }
    }
    return []int{}
}