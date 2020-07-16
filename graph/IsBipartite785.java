public class IsBipartite785{

    //瞎写的，很多可以优化的地方
    public boolean isBipartite(int[][] graph) {
        for(int i = 0; i < graph.length; i++){
            int[] mark = new int[graph.length];
            mark[i] = -1;
            if(!dfs(graph, i, mark, 1)){
                return false;
            }
        }
        return true;
    }
    
    //染色
    public boolean dfs(int[][] graph, int index, int[] mark, int m){
        for(int next : graph[index]){
            if (mark[next] == m){
                continue;
            }
            if (mark[next] == mark[index]) {
                return false;
            }
            mark[next] = m;
            dfs(graph, next, mark, -m);
        }
        return true;
    }
}