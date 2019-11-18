public class UpdateBoard529{
    public static void main(String[] args) {
        UpdateBoard529 u= new UpdateBoard529();
        char[][]board={{'E','E','E','E','E'},{'E','E','M','E','E'},{'E','E','E','E','E'},{'E','E','E','E','E'}};
        print(board);
        System.out.println();
        u.updateBoard(board,new int[]{0,2});
        print(board);
    }

    private int[][] direction={{0,1},{1,0},{-1,1},{1,-1},{-1,0},{0,-1},{-1,-1},{1,1}};

    public char[][] updateBoard(char[][] board, int[] click) {
        int x=click[0];
        int y=click[1];
        if (board[x][y]=='M') {
            board[x][y]='X';
            return board;
        }
        boolean[][] visit=new boolean[board.length][board[0].length];
        dfs(board,x,y,visit);
        return board;
    }

    public void dfs(char[][] board,int x,int y,boolean[][] visit){
        visit[x][y]=true;
        int count=getRoundBoom(board,x,y);
        if(count!=0){
            board[x][y]=(char)(count+'0');
            return;
        }
        board[x][y]='B';
        for (int i=0;i<8;i++) {
            int nx=x+direction[i][0];
            int ny=y+direction[i][1];
            if (isValid(board,nx,ny) && !visit[nx][ny] && board[nx][ny]!='M') {
                dfs(board,nx,ny,visit);
            }
        }
    }

    public int getRoundBoom(char[][] board,int x,int y){
        int count=0;
        for (int i=0;i<8;i++) {
            int nx=x+direction[i][0];
            int ny=y+direction[i][1];
            if (isValid(board,nx,ny) && board[nx][ny]=='M') {
                count++;
            }   
        }
        return count;
    }

    public boolean isValid(final char[][] board,int x,int y){
        return x>=0 && x<board.length && y>=0 && y<board[0].length;
    }

    public static void print(char[][] board){
        for (int i=0;i<board.length;i++) {
            for (int j=0;j<board[0].length;j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}