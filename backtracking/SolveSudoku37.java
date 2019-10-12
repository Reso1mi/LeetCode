import java.util.*;
public class SolveSudoku37{
    public static void main(String[] args) {
        /*
        
         */
        SolveSudoku37 s= new SolveSudoku37();
        char[][] board={{'5','3','.','.','7','.','.','.','.'},
                        {'6','.','.','1','9','5','.','.','.'},
                        {'.','9','8','.','.','.','.','6','.'},
                        {'8','.','.','.','6','.','.','.','3'},
                        {'4','.','.','8','.','3','.','.','1'},
                        {'7','.','.','.','2','.','.','.','6'},
                        {'.','6','.','.','.','.','2','8','.'},
                        {'.','.','.','4','1','9','.','.','5'},
                        {'.','.','.','.','8','.','.','7','9'}};
        s.solveSudoku(board);
       for (int i=0 ;i<board.length;i++) {
            for (int j=0;j<board[0].length;j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    //三个限定规则
    private boolean[][] col=new boolean[9][9];
    private boolean[][] row=new boolean[9][9];
    private boolean[][] block=new boolean[9][9];


    public void solveSudoku(char[][] board) {
        if (board==null || board.length<=0) {
            return;
        }
        for (int i=0;i<9;i++) {
            for (int j=0;j<9;j++) {
                if (board[i][j]!='.') {
                    col[i][board[i][j]-48-1]=true;
                    row[j][board[i][j]-48-1]=true;
                    //块号为 i/3*3+j/3
                    block[i/3*3+j/3][board[i][j]-48-1]=true;
                }
            }
        }
        dfs(board,0,0);
    }

    //private  static char[][] res=new char[9][9];

    public boolean dfs(char[][] board,int i,int j) {
        //从,i,j位置向后寻找'.', i>=9说明全部填充完了
        while(board[i][j]!='.') {
            j++;
            if (j==9) {
                i++;
                j=0;
            }
            //over
            if (i==9) {
                return true;
            }
        }
        //System.out.println(i+","+j);
        for (int val=0;val<9;val++) {
            if (!col[i][val] && !row[j][val] && !block[i/3*3+j/3][val]) {
                col[i][val]=true;
                row[j][val]=true;
                block[i/3*3+j/3][val]=true;
                //尝试填充为 val+1
                board[i][j]=(char)(val+1+48);
                //尝试后面的'.',这里传进去还是i,j
                //大脑模拟下其实这个dfs过程也挺简单
                if(dfs(board,i,j)){
                    return true;
                }else{
                    //回溯
                    board[i][j]='.';
                    col[i][val]=false;
                    row[j][val]=false;
                    block[i/3*3+j/3][val]=false;
                }
            }
        }
        return false;
    }


    public void dfs2(char[][] board,int index) {
        if (index==9) {
            //System.arraycopy(board,0,res,0,board.length);
            return;
        }
        //index行第i个
        for (int i=0;i<9;i++) {
            if (board[index][i] =='.') {
                for (int val=0;val<9;val++) {
                    if (!col[index][val] && !row[i][val] && !block[index/3*2+i/3*2][val]) {
                        System.out.println(index+","+i);
                        col[index][val]=true;
                        row[i][val]=true;
                        block[i/3*2+index/3*2][val]=true;
                        //尝试填充为 val+1
                        board[index][i]=(char)(val+1+48);
                        dfs2(board,index);
                        //回溯
                        board[index][i]='.';
                        col[index][val]=false;
                        row[i][val]=false;
                        block[i/3*2+index/3*2][val]=false;
                    }
                }
            }
        }
    }
}