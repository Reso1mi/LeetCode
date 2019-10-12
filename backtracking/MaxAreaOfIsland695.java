import java.util.*;
public class MaxAreaOfIsland695{
    public static void main(String[] args) {
        MaxAreaOfIsland695 m=new MaxAreaOfIsland695();
        int[][] area={{1,1},{1,0}};
        System.out.println(m.maxAreaOfIsland(area));
    }

    private int[][] direction={{0,1},{0,-1},{1,0},{-1,0}};

    public int maxAreaOfIsland(int[][] grid) {
        if (grid==null || grid.length<=0) {
            return max;
        }
        boolean[][] visit=new boolean[grid.length][grid[0].length];
        for (int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[0].length;j++) {
                if (grid[i][j]==1 &&!visit[i][j]) {
                    int t=dfs(grid,i,j,visit);
                    max=max>t?max:t;
                }
            }
        }
        return max;
    }

    private int max=0;

    public int dfs(int[][] grid,int x,int y,boolean[][] visit) {
        int temp=1;
        visit[x][y]=true;
        for (int i=0;i<direction.length;i++) {
            int nx=x+direction[i][0];
            int ny=y+direction[i][1];
            if (isValid(grid,nx,ny) && grid[nx][ny]==1 && !visit[nx][ny]) {
                temp+=dfs(grid,nx,ny,visit);
            }
        }
        return temp;
    }

    public boolean isValid(final int[][] grid,int x,int y){
        return x>=0 && x<grid.length && y>=0 && y<grid[0].length;
    }
}