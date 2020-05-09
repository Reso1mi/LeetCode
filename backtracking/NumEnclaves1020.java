public class NumEnclaves1020{
    public static void main(String[] args) {

    }

    //DFS
    int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};

    public int numEnclaves(int[][] A) {
        if(A==null || A.length<=0) return 0;
        int N=A.length;
        int M=A[0].length;
        boolean[][] visit=new boolean[N][M];
        int a=0,b=0;
        while(a<N){ //左右边界
            if(A[a][0]==1 && !visit[a][0]) dfs(A,a,0,visit);
            if(A[a][M-1]==1 && !visit[a][M-1]) dfs(A,a,M-1,visit);
            a++;
        }
        while(b<M){ //上下边界
            if(A[0][b]==1&& !visit[0][b]) dfs(A,0,b,visit);
            if(A[N-1][b]==1&& !visit[N-1][b]) dfs(A,N-1,b,visit);
            b++;
        }
        int res=0;
        for (int i=0;i<N;i++) {
            for (int j=0;j<M;j++) {
               if(A[i][j]==1 && !visit[i][j]){
                    res++;
               }
            }
        }
        return res;
    }

    public void dfs(int[][] A,int x,int y,boolean[][] visit){
        visit[x][y]=true;
        for (int i=0;i<dir.length;i++) {
            int nx=x+dir[i][0];
            int ny=y+dir[i][1];
            if(valid(A,nx,ny) && !visit[nx][ny] && A[nx][ny]==1){
                dfs(A,nx,ny,visit);
            }
        }
    }

    public boolean valid(final int[][] A,int x,int y){
        return x>=0 && x<A.length && y>=0 && y<A[0].length;
    }



    //并查集
    int[] rank=null;

    int[] parent=null;

    public int find(int a){
        if(parent[a]==a) return a;
        return parent[a]=find(parent[a]); //路径压缩
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

    public int numEnclaves2(int[][] A) {
        if(A==null || A.length<=0) return 0;
        int m=A.length,n=A[0].length;
        rank=new int[m*n+1];
        parent=new int[m*n+1];
        //init
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if(A[i][j]==1){
                    parent[i*n+j]=i*n+j;
                    rank[i*n+j]=1;
                }
            }
        }
        //将边界和虚拟节点合并
        int dummyNode=m*n;
        parent[dummyNode]=dummyNode;
        rank[dummyNode]=1;
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if(A[i][j]==1){
                    if(i==0 || j==0 || i==m-1 || j==n-1){
                        merge(dummyNode,i*n+j);
                    }else{ 
                        //和周围节点合并
                        if(A[i][j-1]==1) merge(i*n+j,i*n+j-1);
                        if(A[i-1][j]==1) merge(i*n+j,(i-1)*n+j);
                        if(A[i][j+1]==1) merge(i*n+j,i*n+j+1);
                        if(A[i+1][j]==1) merge(i*n+j,(i+1)*n+j);
                    }
                }
            }
        }
        int res=0;
        int dump=find(dummyNode);
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                //判断和虚节点是否连接
                if(A[i][j]==1 && find(i*n+j)!=dump){
                    res++;
                }
            }
        }
        return res;
    }
}