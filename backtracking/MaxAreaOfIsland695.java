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



    //补充一个并查集的解法
    int[] parent=null;

    int[] size=null;

    int max=0;

    public void merge(int a,int b){
        int fa=find(a);
        int fb=find(b);
        if(fa==fb) return;
        if(size[fa]>size[fb]){
            parent[fb]=fa;
            size[fa]+=size[fb];
            max=Math.max(max,size[fa]);
        }else{
            parent[fa]=fb;
            size[fb]+=size[fa];
            max=Math.max(max,size[fb]);
        }
    }

    public int find(int p){
        if(parent[p]==p) return p;
        parent[p]=find(parent[p]);
        return parent[p];
    }

    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        //init
        parent=new int[m*n];
        size=new int[m*n];
        for (int i=0;i<m*n;i++){
            parent[i]=i;
            size[i]=1;
        }
        //1 1 1 1 
        //1 1 1 1
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if(grid[i][j]==1){
                    //特判一下 hahaha~ 感觉如果不是lc有wacase我还挺难发现这个
                    max=Math.max(max,1);
                    //和前面,上面的合并
                    if(i>0 && grid[i-1][j]==1) merge(i*n+j,(i-1)*n+j);
                    if(j>0 && grid[i][j-1]==1) merge(i*n+j,i*n+j-1);
                }
            }
        }
        return max;
    }
}