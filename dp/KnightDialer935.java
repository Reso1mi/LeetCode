public class KnightDialer935{
    public static void main(String[] args) {

    }

    //粗糙的解法
    int[][] dir={{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2}};

    int mod=(int)1e9+7;
    
    Integer[][][] dp=null;
    
    public int knightDialer(int N) {
        int[][] grid={{1,2,3},{4,5,6},{7,8,9},{-1,0,-1}};
        int res=0;
        dp=new Integer[4][3][N];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]!=-1){
                    res=(res+dfs(grid,i,j,N-1))%mod;
                }
            }
        }
        return res;
    }

    public int dfs(int[][] grid,int x,int y,int N){
        if(N==0) return 1;
        if(dp[x][y][N]!=null) return dp[x][y][N];
        int res=0; //一开始赋值成1了。。从当前位置起跳，所以当前位置不应该有初始值
        for(int i=0;i<dir.length;i++){
            int nx=x+dir[i][0];
            int ny=y+dir[i][1];
            if(valid(grid,nx,ny)){
                res=(res+dfs(grid,nx,ny,N-1))%mod;
            }
        }
        return dp[x][y][N]=res;
    }
    
    public boolean valid(int[][] grid,int x,int y){
        return x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y]!=-1;
    }


    //精致的解法
    int mod=(int)1e9+7;
    
    Integer[][] dp=null;
    
    public int knightDialer(int N) {
        //直接看图建立对应关系
        int[][] next={{4,6},{6,8},{7,9},{4,8},{0,3,9},{},{0,1,7},{2,6},{1,3},{2,4}};
        int res=0;
        dp=new Integer[10][N];
        for(int i=0;i<=9;i++){
            res=(res+dfs(i,N-1,next))%mod;
        }
        return res;
    }

    public int dfs(int num,int N,int[][] next){
        if(N==0) return 1;
        if(dp[num][N]!=null) return dp[num][N];
        int res=0; //注意别写成1了
        for(int i=0;i<next[num].length;i++){
            res=(res+dfs(next[num][i],N-1,next))%mod;
        }
        return dp[num][N]=res;
    }

    //递推的方式
    public int knightDialer(int N) {
        //next[i]: i下一步能跳到的位置
        int[][] next={{4,6},{6,8},{7,9},{4,8},{0,3,9},{},{0,1,7},{2,6},{1,3},{2,4}};
        int[][] dp=new int[N][10];
        Arrays.fill(dp[0],1); //base dp[0]
        int mod=(int)1e9+7;
        int res=0;
        for (int i=1;i<N;i++) {
            for (int num=0;num<=9;num++) {
                for (int j=0;j<next[num].length;j++) {
                    dp[i][num]=(dp[i][num]+dp[i-1][next[num][j]])%mod;   
                }
            }
        }
        for(int i=0;i<=9;i++) res=(res+dp[N-1][i])%mod;
        return res;
    }
}