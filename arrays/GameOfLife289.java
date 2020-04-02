public class GameOfLife289{
    public static void main(String[] args) {

    }


    /*
    如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
    如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
    如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
    如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
     */

    int[][] dir={{1,0},{0,1},{-1,0},{0,-1},{1,1},{-1,-1},{-1,1},{1,-1}};
    
    public void gameOfLife(int[][] board) {
        if(board==null || board.length<=0) return;
        int m=board.length,n=board[0].length;
        boolean[][] change=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==0 && aliveCell(board,i,j,change)==3){
                    board[i][j]=1;
                    change[i][j]=true;
                }else if(board[i][j]==1){
                    int alive=aliveCell(board,i,j,change);
                    if(alive<2 || alive>3){
                        board[i][j]=0;
                        change[i][j]=true;
                    }
                }
            }
        }
    }

    public int aliveCell(int[][] board,int x,int y,boolean[][] change){
        int alive=0;
        for(int k=0;k<dir.length;k++){
            int nx=x+dir[k][0];
            int ny=y+dir[k][1];
            if(valid(board,nx,ny)&&(board[nx][ny]==1 && !change[nx][ny] || (board[nx][ny]==0 && change[nx][ny]))){
                alive++;
            }
        }
        return alive;
    }

    public boolean valid(final int[][] board,int x,int y){
        return x>=0 && x<board.length && y>=0 && y<board[0].length;
    }
}