public class NumIslands200{
    public static void main(String[] args) {
        NumIslands200 n=new NumIslands200();
        char[][] s={{'1','1','1','1','0'},
        {'1','1','0','1','0'},
        {'1','1','0','0','0'},
        {'0','0','0','0','0'}};
        System.out.println(n.numIslands2(s));
    }

    //方向: 右,下,左,上
    private int[][] direction={{0,1},{1,0},{0,-1},{-1,0}};

    public int numIslands(char[][] grid) {
        if (grid==null||grid.length<=0) {
            return 0;
        }
        boolean[][] visit=new boolean[grid.length][grid[0].length];
        for (int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[0].length;j++) {
                if (grid[i][j]=='1'&&!visit[i][j]) {
                    dfs(grid,i,j,visit);
                    res++;
                }
            }
        }
        return res;
    }

    private int res=0;

    public void dfs(char[][] grid,int x,int y,boolean[][] visit) {
        //其实整个dfs做的就是对visit[x][y]标记,标记为true代表访问过
        visit[x][y]=true;
        for (int i=0;i<direction.length;i++) {
            int nx=x+direction[i][0];
            int ny=y+direction[i][1];
            if (isValid(grid,nx,ny) && !visit[nx][ny] && grid[nx][ny]=='1') {
                dfs(grid,nx,ny,visit);
            }
        }
    }

    public boolean isValid(final char[][] grid,int x,int y){
        return x>=0 && x<grid.length && y>=0 && y<grid[0].length;
    }

    //复习下并查集
    int[] rank=null;
    
    int[] parent=null;

    public int find(int a){
        if(parent[a]==a) return a;
        return parent[a]=find(parent[a]);
    }

    public void merge(int a,int b){
        int fa=find(a);
        int fb=find(b);
        if(fa==fb) return;
        if(rank[fa]>rank[fb]){
            parent[fb]=fa;
            rank[fa]+=rank[fb];
        }else{
            parent[fa]=fb;
            rank[fb]+=rank[fa];
        }
    }

    public int numIslands2(char[][] grid) {
        if(grid==null || grid.length<=0) return 0;
        int m=grid.length,n=grid[0].length;
        rank=new int[m*n];
        parent=new int[m*n];
        //init
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if(grid[i][j]=='1'){
                    parent[i*n+j]=i*n+j;
                    rank[i*n+j]=1;
                }
            }
        }
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if(grid[i][j]=='1'){
                    //和上/左合并
                    if(i>0 && grid[i-1][j]=='1') merge(i*n+j,(i-1)*n+j);
                    if(j>0 && grid[i][j-1]=='1') merge(i*n+j,i*n+(j-1));
                }
            }
        }
        int res=0;
        //直接循环parent会有问题,还是老老实实遍历矩阵
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if(grid[i][j]=='1' && parent[i*n+j]==i*n+j){
                    res++;
                }
            }
        }
        return res;
    }
}