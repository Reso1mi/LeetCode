public class NumRookCaptures999{
    public static void main(String[] args) {

    }

    //模拟就ok
    public int numRookCaptures(char[][] board) {
        int[][] direction=new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
        int res=0;
        for (int i=0;i<board.length;i++) {
            for (int j=0;j<board[0].length;j++) {
                if(board[i][j]=='R'){
                    for (int k=0;k<4;k++) {
                        int nx=i+direction[k][0];
                        int ny=j+direction[k][1];
                        while(nx>=0 && nx<board.length && ny>=0 && ny<board[0].length){
                            if(board[nx][ny]=='B'){
                                break;
                            }
                            if(board[nx][ny]=='p'){
                                res++;
                                break;
                            }
                            nx+=direction[k][0];
                            ny+=direction[k][1];
                        }
                    }
                    return res;
                }
            }
        }
        return 0;
    }
}