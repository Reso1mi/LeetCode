import java.util.*;
public class PacificAtlantic417{
    public static void main(String[] args) {

    }

    //方向键
    private int[][] direction={{0,1},{1,0},{0,-1},{-1,0}};

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res=new ArrayList<>();
        if (matrix==null || matrix.length<=0) {
            return res;
        }
        int m=matrix.length;
        int n=matrix[0].length;
        //太平洋
        boolean[][] pacific=new boolean[m][n];
        //大西洋
        boolean[][] atlantic=new boolean[m][n];

        for (int i=0;i<m;i++) {
            dfs(matrix,i,0,pacific);
            dfs(matrix,i,n-1,atlantic);
        }

        for (int i=0;i<n;i++) {
            dfs(matrix,0,i,pacific);
            dfs(matrix,m-1,i,atlantic);
        }
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }

    public void dfs(int[][] matrix,int x,int y,boolean[][] visit) {
        visit[x][y]=true;
        //向4个方向floodfill
        for (int i=0;i<direction.length;i++) {
            int nx=x+direction[i][0];
            int ny=y+direction[i][1];
            if (isValid(matrix,nx,ny) && matrix[nx][ny]>= matrix[x][y] && !visit[nx][ny]) {
                dfs(matrix,nx,ny,visit);
            }
        }
    }

    public boolean isValid(final int[][] matrix,int x,int y){
        return x>=0 && x<matrix.length && y>=0 && y<matrix[0].length;
    }
}