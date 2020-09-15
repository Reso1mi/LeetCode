public class MinCostConnectPoints5513{

    public static void main(String[] args){
        
    }

    //Prim O(V^2) 任取一个节作为起点，dis[i]记录mst点集到点i的最短距离
    //每次取出mst点集外dis[i]最小的点，也就是离mst点集最近的点，并标记为mst节点
    //然后利用该点更新其他的mst点集外的点的dis距离，直到将所有的点都加进去，适合稠密图（边数远大于点数）
    //可以使用一些数据结构来优化时间复杂度，暂时不深究
    public int minCostConnectPoints(int[][] points) {
        int INF = 0x3f3f3f3f;
        int n = points.length;
        //dis表示mst点集到该点的最小距离
        int[] dis = new int[n];
        Arrays.fill(dis, INF);
        dis[0] = 0;
        boolean[] vis = new boolean[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            int minCost = INF;
            int k = -1; //最小的新节点
            for (int j = 0; j < n; j++) {
                if (!vis[j] && dis[j] < minCost) {
                    minCost = dis[j];
                    k = j;
                }
            }
            vis[k] = true;
            res += minCost;
            for (int j = 0; j < n; j++) {
                //更新所有mst点集外的点的dis
                if (vis[j]) continue;
                int mhd = Math.abs(points[k][0]-points[j][0])+Math.abs(points[k][1]-points[j][1]);
                dis[j] = Math.min(dis[j], mhd);
            }
        }
        return res;
    }

    //Kruskal+UnionFind
    //以边为中心，首先构造出所有的边，然后排序，从最短的边开始，合并该边的两个端点，这里需要用到并查集
    //合并n-1次后就得到mst（n为节点数），适合稀疏图
    int[] parent;
    int[] rank;
    //路径压缩
    public int find(int a){
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    public boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) {
            return false;
        }
        //随便合并 553ms
        //parent[pa] = pb;
        //按秩合并 564ms 似乎没有什么变化。。。
        if (rank[pa] > rank[pb]) {
            parent[pb] = pa;
        }else if (rank[pb] > rank[pa]) {
            parent[pa] = pb;
        }else{
            parent[pa] = pb;
            rank[pb]++;
        }
        return true;
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        parent = new int[n];
        rank = new int[n];
        //n-1 + n-2 + n-3 +...+ 1 = (n-1) + (n-1)*(n-2)/2 = n(n-1)/2
        //5 : 4+3+2+1 = 4*
        //0,1: 端点，2: 边权值
        int[][] edge = new int[n*(n-1)/2][3];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int dis = Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                edge[idx++] = new int[]{i, j, dis};
            }
            parent[i] = i;
            rank[i] = 1;
        }
        //按照边的权值排序
        Arrays.sort(edge, (e1, e2)->e1[2]-e2[2]);
        int res = 0;
        int count = 0;
        for (int i = 0; i < edge.length; i++) {
            if (union(edge[i][0], edge[i][1])) {
                res += edge[i][2];
                count++;
            }
            if (count == n-1) {
                break;
            }
        }
        return res;
    }
}