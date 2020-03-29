import java.util.*;
public class MaxDistance1162{
    public static void main(String[] args) {

    }

    private int[][] diretion={{1,0},{-1,0},{0,1},{0,-1}};

    public int maxDistance(int[][] grid) {
        int maxDis=-1;
        int m=grid.length,n=grid[0].length;
        boolean[][] visit=new boolean[m][n];
        Queue<Pair> queue=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    queue.add(new Pair(i,j,0));
                    visit[i][j]=true;
                }
            }
        }
        if(queue.size()==0 || queue.size()==m*n)return -1;
        int step=0;
        int res=-1;
        while(!queue.isEmpty()){
            Pair pair=queue.poll();
            res=pair.step;
            for (int i=0;i<4;i++) {
                int nx=pair.x+diretion[i][0];
                int ny=pair.y+diretion[i][1];
                if(valid(grid,nx,ny) && !visit[nx][ny] && grid[nx][ny]==0){
                    queue.add(new Pair(nx,ny,pair.step+1));
                    visit[nx][ny]=true;
                }
            }
        }
        return res;
    }

    class Pair{
        int x,y;
        int step;
        public Pair(int x,int y,int step){
            this.x=x;
            this.y=y;
            this.step=step;
        }
    }

    public boolean valid(final int[][] grid,int x,int y){
        return x>=0 && x<grid.length && y>=0 && y<grid[0].length;
    }
}