import java.util.*;
public class TotalNQueens52{
    public static void main(String[] args) {
        TotalNQueens52 s=new TotalNQueens52();
        for (int i=1;i<=11;i++) {
            System.out.println(s.totalNQueens(i));
        }
    }

    /*
    [".Q..",  // 解法 1
    "...Q",
    "Q...",
    "..Q."],

    ["..Q.",  // 解法 2
    "Q...",
    "...Q",
    ".Q.."]
    */
    public int totalNQueens(int n) {
        res=0;
        if (n<=0) return 0;
        col=new boolean[n];
        //row=new boolean[n];
        dia1=new boolean[2*n-1];
        dia2=new boolean[2*n-1];
        dfs(n,0,new ArrayList());
        return res;
    }

    private int res=0;

    private boolean[] col;
    //private boolean[] row;
    private boolean[] dia1;
    private boolean[] dia2;


    //dfs
    public void dfs(int n,int index,List<Integer> lis) {
        if (index==n) {
            res++;
            return;
        }
        //检测第index行第i列
        for (int i=0;i<n;i++) {
            if (!col[i] && !dia1[index-i+n-1] && !dia2[i+index]) {
                col[i]=true;
                dia1[index-i+n-1]=true;
                dia2[index+i]=true;
                //不用添加到lis中
                dfs(n,index+1,lis);
                //回溯
                col[i]=false;
                dia1[index-i+n-1]=false;
                dia2[index+i]=false;
            }
        }
    }
}