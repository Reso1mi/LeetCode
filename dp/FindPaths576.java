public class FindPaths576{
    public static void main(String[] args) {

    }


    //自顶向下，记忆化递归，比较好写
    int[][] dir={{0,1},{1,0},{-1,0},{0,-1}};
    
    int mod=(int)1e9+7;

    Long[][][] dp=null;
    
    public int findPaths(int m, int n, int N, int i, int j) {
        dp=new Long[m][n][N+1];
        return (int)(dfs(m,n,i,j,N)%mod);
    }

    public long dfs(int m,int n,int x,int y,int k){
        if(k==0) return 0;
        if(dp[x][y][k]!=null){
            return dp[x][y][k];
        }
        long count=0;
        for(int i=0;i<dir.length;i++){
            int nx=x+dir[i][0];
            int ny=y+dir[i][1];
            if(!valid(m,n,nx,ny)){
                count++;
                continue;
            }
            count=(count+dfs(m,n,nx,ny,k-1))%mod;
        }
        return dp[x][y][k]=(count)%mod;
    }

    public boolean valid(int m,int n,int x,int y){
        return x>=0 && x<m && y>=0 && y<n;
    }

    //自底向上递推
    public int findPaths(int m, int n, int N, int i, int j) {
        int mod=(int)1e9+7;
        //群里偷学到的
        int[] dir={0,1,0,-1,0};
        long[][][] dp=new long[m][n][N+1];
        for (int k=1;k<=N;k++) {
            for (int r=0;r<m;r++) {
                for (int c=0;c<n;c++) {
                    for (int d=0;d<4;d++) {
                        int nx=r+dir[d];
                        int ny=c+dir[d+1];
                        if(nx<0 || ny<0 || nx>=m ||ny>=n){
                            dp[r][c][k]++;
                        }else{
                            dp[r][c][k]=(dp[r][c][k]+dp[nx][ny][k-1])%mod;
                        }
                    }
                    //提前结束，只需要i,j,N就行了(貌似没有快多少)
                    if(k==N && r==i && c==j){
                        return (int)(dp[i][j][N]);
                    }
                }
            }
        }
        //return (int)(dp[m-1][n-1][N]); md一开始返回错了，看了半天
        return 0;
    }
}