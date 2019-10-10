public class SurroundedRegions130{
    public static void main(String[] args) {
        SurroundedRegions130 s=new SurroundedRegions130();
        char[][] board={{'X','X','X','X'},
        {'X','O','O','X'},
        {'X','O','O','X'},
        {'X','O','X','X'}};

        s.solve(board);
        for (int i=0;i<board.length;i++) {
            for (int j=0;j<board[0].length;j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    //方向: 右,下,左,上
    private int[][] direction={{0,1},{1,0},{0,-1},{-1,0}};

    public void solve(char[][] board) {
        if (board==null || board.length<=0) {
            return;
        }
        boolean[][] visit=new boolean[board.length][board[0].length];
        int lx=0,ly=0;

        //遍历4条边的'O',将与相连的'O'都标记为true
        while(lx<board.length) { 
            if (board[lx][0]=='O') { //左
                dfs(board,lx,0,visit);
            }
            if (board[lx][board[0].length-1] == 'O') { //右
                dfs(board,lx,board[0].length-1,visit);
            }
            lx++;
        }

        while(ly<board[0].length) { 
            if (board[0][ly]=='O') { //上
                dfs(board,0,ly,visit);
            }
            if (board[board.length-1][ly] == 'O') { //下
                dfs(board,board.length-1,ly,visit);   
            }
            ly++;
        }

        //遍历将所有visit=false的O变为X
        for (int i=0;i<board.length;i++) {
            for (int j=0;j<board[0].length;j++) {
                if (board[i][j]=='O' && !visit[i][j]) {
                    board[i][j]='X';
                }
            }
        }
    }

    public void dfs(char[][] board,int x,int y,boolean[][] visit) {
        visit[x][y]=true;
        for (int i=0;i<direction.length;i++) {
            int nx=x+direction[i][0];
            int ny=y+direction[i][1];
            if (isValid(board,nx,ny) && board[nx][ny]=='O' && !visit[nx][ny]) {
                dfs(board,nx,ny,visit);
            }
        }
    }

    //是否合法
    public boolean isValid(final char[][] grid,int x,int y){
        return x>=0 && x<grid.length && y>=0 && y<grid[0].length;
    }
}
