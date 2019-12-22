public class GetMaximumGold1219{
    public static void main(String[] args) {
       GetMaximumGold1219  g=new GetMaximumGold1219();
       int[][] nums={{0,6,0},{5,8,7},{0,9,0}};
       System.out.println(g.getMaximumGold(nums));
    }


    
    //下右左上
    private int[][] direction={{0,1},{1,0},{0,-1},{-1,0}};

    public int getMaximumGold(int[][] grid) {
        int max=0;
        boolean[][] visit=new boolean[grid.length][grid[0].length];
        for (int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[0].length;j++) {
                if (grid[i][j]>0) {
                    max=Math.max(dfs(grid,i,j,visit),max);
                }
            }
        }
        return max;
    }
    
    //求出从x,y开始所能获得的最大的收益
    public int dfs(int[][] grid,int x,int y,boolean[][] visit){
        int maxGlod=grid[x][y]; //一开始这里写的0...排了半天的错
        visit[x][y]=true;
        for (int i=0;i<direction.length;i++) {
            int nx=x+direction[i][0];
            int ny=y+direction[i][1];
            if (isValid(grid,nx,ny) && !visit[nx][ny] && grid[nx][ny]>0) {
                //求向4个方向扩展的最大值
                maxGlod=Math.max(dfs(grid,nx,ny,visit)+grid[x][y],maxGlod);
            }
        }
        visit[x][y]=false;
        return maxGlod;
    }

    public boolean isValid(final int[][] grid,int x,int y){
        return x>=0 && x<grid.length && y>=0 && y<grid[0].length;
    }
}