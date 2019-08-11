public class MinPathSum64{
    public static void main(String[] args) {

    }

    public int minPathSum(int[][] grid) {
        minPathSum(grid,0,0);
        return min;
    }

    private static int min=Integer.MAX_VALUE;

    private static int current=0;

    public void minPathSum(int[][] grid,int i,int j) {
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