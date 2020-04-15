import java.util.*;
public class UpdateMatrix542{
    public static void main(String[] args) {

    }

    /*[
       [1,1,1],
       [1,1,1],
       [1,1,1],
       [0,1,1]
      ]
    */
    //遍历每一个1,BFS寻找离他最近的0,一次只能确定一个1,效率略低
      public int[][] updateMatrix2(int[][] matrix) {
        if (matrix == null || matrix.length <=0 || matrix[0].length <=0) {
            return new int[][]{};
        }
        for (int i=0;i<matrix.length;i++) {
            for (int j=0;j<matrix[0].length;j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j]=findMinDis(matrix,i,j);   
                }
            }
        }
        return matrix;
    }

    private int[][] direction={{1,0},{0,1},{-1,0},{0,-1}};

    public int findMinDis(int[][] matrix,int x,int y){
        Queue<Pair> queue=new LinkedList<>();
        //boolean[][] visit=new boolean[matrix.length][matrix[0].length];
        queue.add(new Pair(x,y,0));
        //visit[x][y]=true;
        while(!queue.isEmpty()){
            Pair pair=queue.poll();
            for (int i=0;i<direction.length;i++) {
                int nx=pair.x + direction[i][0];
                int ny=pair.y + direction[i][1];
                if (isValid(matrix,nx,ny) /*&& !visit[nx][ny]*/) {
                    //visit[nx][ny]=true;
                    if (matrix[nx][ny] == 0) {
                        return pair.step+1;
                    }
                    queue.add(new Pair(nx,ny,pair.step+1));
                }
            }
        }
        return -1; //题目说了一定有0,所以不会走到这里
    }   

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length <=0 || matrix[0].length <=0) {
            return new int[][]{};
        }
        Queue<Pair> queue=new LinkedList<>();
        for (int i=0;i<matrix.length;i++) {
            for (int j=0;j<matrix[0].length;j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new Pair(i,j,0));
                }else{
                    matrix[i][j]=Integer.MAX_VALUE;
                }
            }
        }
        while(!queue.isEmpty()){
            Pair pair=queue.poll();
            for (int i=0;i<direction.length;i++) {
                int nx=pair.x+direction[i][0];
                int ny=pair.y+direction[i][1];
                if (isValid(matrix,nx,ny) && pair.step+1 < matrix[nx][ny]) {
                    matrix[nx][ny]=pair.step+1;
                    queue.add(new Pair(nx,ny,pair.step+1));
                }
            }
        }
        return matrix;
    }

    public boolean isValid(int[][] matrix,int x,int y){
        return x>=0 && x<matrix.length && y>=0 && y<matrix[0].length;
    }

    class Pair{
        int x;
        int y;
        int step;
        public Pair(int x,int y,int step){
            this.x=x;
            this.y=y;
            this.step=step;
        }
    }

    //update: 2020.4.15
    private int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};

    public int[][] updateMatrix(int[][] matrix) {
        if(matrix==null || matrix.length<=0) return matrix;
        boolean[][] visit=new boolean[matrix.length][matrix[0].length];
        Queue<Pair> queue=new LinkedList<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    queue.add(new Pair(i,j,0));
                    visit[i][j]=true;
                }else{
                    matrix[i][j]=Integer.MAX_VALUE;
                }
            }
        }
        while(!queue.isEmpty()){
            Pair pair=queue.poll();
            for(int i=0;i<dir.length;i++){
                int nx=pair.x+dir[i][0];
                int ny=pair.y+dir[i][1];
                if(valid(matrix,nx,ny) && !visit[nx][ny]){
                    queue.add(new Pair(nx,ny,pair.step+1));
                    matrix[nx][ny]=pair.step+1;
                    visit[nx][ny]=true;
                }
            }
        }
        return matrix;
    }

    public boolean valid(final int[][] matrix,int x,int y){
        return x>=0 && x<matrix.length && y>=0 && y<matrix[0].length;
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
}