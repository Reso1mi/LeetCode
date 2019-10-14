public class UniquePathsWithObstacles63{
    public static void main(String[] args) {

    }

    //dp,参照之前的思路
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid==null || obstacleGrid.length<=0 || obstacleGrid[0][0]==1) {
            return 0;
        }
        int[][] dp=new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i=0;i<obstacleGrid.length;i++) {
            for (int j=0; j<obstacleGrid[0].length;j++) {
                if (obstacleGrid[i][j]==1) {
                    dp[i][j]=0;
                }else if (i==0 && j==0) {
                    dp[0][0]=1;
                }else if(i==0 && j!=0){
                    dp[0][j]=dp[0][j-1];
                }else if (j==0 && i!=0) {
                    dp[i][0]=dp[i-1][0];
                }else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }

    //一维dp
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid==null || obstacleGrid.length<=0 || obstacleGrid[0][0]==1) {
            return 0;
        }
        //以行为单位向下走
        int[] dp=new int[obstacleGrid[0].length];
        dp[0]=1;
        for (int i=0;i<obstacleGrid.length;i++) {
            for (int j=0; j<obstacleGrid[0].length;j++) {
                if (obstacleGrid[i][j]==1) {
                    dp[j]=0;
                }else if(i==0 && j!=0){ //第一行
                    dp[j]=dp[j-1];
                }else if(i!=0 && j!=0){ 
                    dp[j]=dp[j]+dp[j-1];
                }
                //每一行第一列的dp[j]=dp[j],和上一行的第一列保持一致就行
            }
        }
        return dp[obstacleGrid[0].length-1];
    }



    //dfs回溯 , TLE
    private int[][] direction={{0,1},{1,0}};

    private int count=0;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid==null || obstacleGrid.length<=0 || obstacleGrid[0][0]==1) {
            return 0;
        }
        boolean[][] visit=new boolean[obstacleGrid.length][obstacleGrid[0].length];
        dfs(obstacleGrid,visit,0,0);
        return count;
    }

    public void dfs(int[][] obstacleGrid,boolean[][] visit,int x,int y) {
        //!=1 是为了coner case
        if (x==obstacleGrid.length-1 && y==obstacleGrid[0].length-1 && obstacleGrid[x][y]!=1) {
            count++;
            return;
        }
        for (int i=0;i<direction.length;i++) {
            int nx=x+direction[i][0];
            int ny=y+direction[i][1];
            if (nx<obstacleGrid.length && ny<obstacleGrid[0].length && !visit[nx][ny] && obstacleGrid[nx][ny] !=1) {
                visit[nx][ny]=true;
                dfs(obstacleGrid,visit,nx,ny);
                visit[nx][ny]=false;
            }
        }
    }
}