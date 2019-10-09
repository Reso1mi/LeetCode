import java.util.*;
public class WordSearch79{
    public static void main(String[] args) {
        WordSearch79 w=new WordSearch79();
        char[][]board ={
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };
        char[][]board2 ={
            {'a'}
        };
        System.out.println(w.exist(board2,"a"));
        //System.out.println("A".substring(0,0));
    }
    
    /*
    board =
    [
      ['A','B','C','E'],
      ['S','F','C','S'],
      ['A','D','E','E']
    ]
     */
    
    //方向: 右,下,左,上
    private int[][] direction={{0,1},{1,0},{0,-1},{-1,0}};

    public boolean exist(char[][] board, String word) {
        if (board==null || word==null) {
            return false;
        }
        char[] words=word.toCharArray();
        boolean[][] visit=new boolean[board.length][board[0].length];
        for (int i=0;i<board.length;i++) {
            for (int j=0;j<board[0].length;j++) {
                //遍历board每个元素,以为个元素为起点都试一下
                if(dfs(board,words,0,i,j,visit)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, char[] word,int index,int x,int y,boolean[][] visit) {
        //遍历到word的最后一个了,直接比较就可以得出结果
       if (index == word.length-1) {
        return word[index] == board[x][y];
    }
        /*
         这样写如果board只有一个元素就会错了,后面的isValid会直接false,但是有可能word就是这个board
         if (index == word.length) {
            return true;
        }*/
        //当元素相等的时候才有继续的必要
        if (board[x][y]==word[index]) {
            visit[x][y]=true;
            for (int i=0;i<direction.length;i++) {
                int nx=x+direction[i][0];
                int ny=y+direction[i][1];
                //保证合法性
                if (isValid(board,nx,ny)&&!visit[nx][ny]&&dfs(board,word,index+1,nx,ny,visit)) {
                    return true;
                }
            }
            visit[x][y]=false;
        }
        return false;
    }

    public boolean isValid(char[][] cs,int x,int y){
        return x>=0 && x<cs.length && y >=0 && y< cs[0].length;
    }
}