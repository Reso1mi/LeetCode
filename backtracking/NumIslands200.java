public class NumIslands200{
    public static void main(String[] args) {
        NumIslands200 n=new NumIslands200();
        char[][] s={{'1','1','1','1','0'},
        {'1','1','0','1','0'},
        {'1','1','0','0','0'},
        {'0','0','0','0','0'}};
        System.out.println(n.numIslands(s));
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
}