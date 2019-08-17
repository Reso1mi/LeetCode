public class MinPathSum64{
    public static void main(String[] args) {

    }

    //动态规划 1
    public int minPathSum(int[][] grid) {
        int[][] dp=new int[grid.length][grid[0].length];
        for (int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[0].length;j++) {
                //第一行
                if(i==0 && j!=0){
                    dp[i][j]=grid[i][j]+dp[i][j-1];
                }else if(i!=0 && j==0){
                    dp[i][j]=grid[i][j]+dp[i-1][j];
                }else if(i!=0 && j!=0){
                    dp[i][j]=grid[i][j]+Math.min(dp[i-1][j],dp[i][j-1]);
                }else{
                    dp[i][j]=grid[i][j];
                }
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }


    //dp2
    public int minPathSum(int[][] grid) {
        int[][] dp=new int[grid.length][grid[0].length];
        for (int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[0].length;j++) {
                //第一行
                if(i==0 && j!=0){
                    dp[i][j]=grid[i][j]+dp[i][j-1];
                }else if(i!=0 && j==0){
                    dp[i][j]=grid[i][j]+dp[i-1][j];
                }else if(i!=0 && j!=0){
                    dp[i][j]=grid[i][j]+Math.min(dp[i-1][j],dp[i][j-1]);
                }else{
                    dp[i][j]=grid[i][j];
                }
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }




    public int minPathSumTLE(int[][] grid) {
        return minPathSum(grid,0,0);
    }

    public int caculater(int[][] grid,int i,int j){
        //i:行 j:列
        if(i==grid.length || j==grid[0].length){
            return Integer.MAX_VALUE;
        }
        if(i==grid.length-1 && j==grid[0].length-1){
            return grid[i][j];
        }
        return grid[i][j]+Math.min(caculater(grid,i,j+1),caculater(grid,i+1,j));
    }

    //DFS的做法...还没写出来
    private static int min=Integer.MAX_VALUE;

    private static int current=0;

    public void minPathSum222(int[][] grid,int i,int j) {
        int[][] dire={{0,1},{1,0}}; //右，下
        if(i==grid.length&&j==grid[0].length){
            min=current>min?min:current;
            return;
        }

        for (int k=0;k<dire.length;k++) {
            int ni=i+dire[k][0]; //右
            int nj=j+dire[k][1]; //下
            if(ni<grid[0].length && nj<grid.length){
                current+=grid[i][j];
                minPathSum(grid,ni,nj);
            }
        }
        return;
    }
}