public class KnightProbability688{
    public static void main(String[] args) {

    }

    //小数据可以过，大数据过不了
    //K[0,100]直接8^100就爆了，所以肯定不能像上面那样求，dp得存概率
    public double knightProbability(int N, int K, int r, int c) {
        int[][] dir={{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2}};
        int[][][] dp=new int[N][N][K+1];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                //这题如果反着求出界路径就错了，得正向求
                dp[i][j][0]=1; 
            }
        }
        for(int k=1;k<=K;k++){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    for(int d=0;d<dir.length;d++){
                        int nx=i+dir[d][0];
                        int ny=j+dir[d][1];
                        if(nx>=0 && nx<N && ny>=0 && ny<N){
                            dp[i][j][k]+=(dp[nx][ny][k-1]);
                        }
                    }
                }
            }
        }
        return dp[r][c][K]/Math.pow(8,K);
    }

    //DP存概率AC解法
    public double knightProbability(int N, int K, int r, int c) {
        int[][] dir={{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2}};
        double[][][] dp=new double[N][N][K+1];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                dp[i][j][0]=1;
            }
        }
        for(int k=1;k<=K;k++){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    for(int d=0;d<dir.length;d++){
                        int nx=i+dir[d][0];
                        int ny=j+dir[d][1];
                        if(nx>=0 && nx<N && ny>=0 && ny<N){
                            //md，一开始不知道为啥想到求独立事件P(A U B)上去了
                            //但是其实两者并不是独立事件，是互斥事件直接P(A)+P(B)就行了
                            dp[i][j][k]+=(dp[nx][ny][k-1])/8;
                        }
                    }
                    //提前返回
                    if(i==r && j==c && k==K){
                        return dp[i][j][k];
                    }
                }
            }
        }
        return dp[r][c][K];
    }

    //自顶向上
    Double[][][] dp=null;

    int[][] dir={{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2}};

    public double knightProbability(int N, int K, int r, int c) {
        dp=new Double[N][N][K+1];
        return dfs(N,K,r,c);
    }

    public double dfs(int N,int k,int x,int y){
        if(k==0) return 1.0;
        if(dp[x][y][k]!=null){
            return dp[x][y][k];
        }
        double p=0;
        for (int i=0;i<dir.length;i++) {
            int nx=x+dir[i][0];
            int ny=y+dir[i][1];
            if(nx>=0 && nx<N && ny>=0 && ny<N){
                p+=dfs(N,k-1,nx,ny)/8;
            }
        }
        return dp[x][y][k]=p;
    }
}