//欧拉回路，一笔画问题
func findItinerary(tickets [][]string) []string {
    var adj = make(map[string][]string)
    for _, tick := range tickets {
        adj[tick[0]] = append(adj[tick[0]], tick[1])
    }
    for _, toList := range adj {
        sort.Strings(toList)
    }
    var res []string
    var dfs func (cur string) 
    dfs = func (cur string) {
        for len(adj[cur]) != 0 {
            //删除节点，避免重复访问
            to := adj[cur][0]
            adj[cur] = adj[cur][1:]
            dfs(to)
        }
        //后序遍历，最后将路径添加进去，保证死胡同会首先加入
        res = append(res, cur)
    }
    dfs("JFK")
    //翻转下
    for i, j := 0, len(res)-1; i < j; i, j = i+1, j-1 {
        res[i], res[j] = res[j], res[i]
    }
    return res
}