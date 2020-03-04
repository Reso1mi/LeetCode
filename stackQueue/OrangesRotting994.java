import java.util.*;
public class OrangesRotting994{
    public static void main(String[] args) {

    }

    private int[][] diretion={{0,1},{1,0},{0,-1},{-1,0}};

    public int orangesRotting(int[][] grid) {
        Queue<Pair> queue=new LinkedList<>();
        int time=0;
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1) count++; //统计好橘子的数量
                if(grid[i][j]==2){
                    queue.add(new Pair(i,j));
                }
            }
        }
        if(count==0) return 0;
        while(!queue.isEmpty()){
            //每一轮的坏橘子数量
            int size=queue.size();
            time++;
            while(size-- >0){
                Pair pair=queue.poll();
                for (int i=0;i<4;i++) {
                    int nx=pair.x+diretion[i][0];
                    int ny=pair.y+diretion[i][1];
                    if(valid(grid,nx,ny) && grid[nx][ny]==1){
                        grid[nx][ny]=2;
                        count--;//好橘子--
                        queue.add(new Pair(nx,ny));
                    }
                }
                if(count==0) return time;
            }
        }
        return -1;
    }

    class Pair{
        int x,y;
        public Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }

    public boolean valid(final int[][] grid,int x,int y){
        return x>=0 && x<grid.length && y>=0 && y<grid[0].length;
    }
}