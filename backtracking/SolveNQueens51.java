import java.util.*;
public class SolveNQueens51{
    public static void main(String[] args) {
        SolveNQueens51 s=new SolveNQueens51();
        List<List<String>> r=s.solveNQueens(8);
        r.forEach(lis->{
            lis.forEach(System.out::println);
            System.out.println();
        });
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

    private List<List<String>> res=new ArrayList<>();

    private boolean[] col;
    //private boolean[] row;
    private boolean[] dia1;
    private boolean[] dia2;

    public List<List<String>> solveNQueens(int n) {
        if (n<=0) return res;
        col=new boolean[n];
        //row=new boolean[n];
        dia1=new boolean[2*n-1];
        dia2=new boolean[2*n-1];
        dfs(n,0,new ArrayList());
        return res;
    }

    //dfs
    public void dfs(int n,int index,List<Integer> lis) {
        if (index==n) {
            res.add(generateRes(lis));
            return;
        }
        //检测第index行第i列
        for (int i=0;i<n;i++) {
            if (!col[i] && !dia1[index-i+n-1] && !dia2[i+index]) {
                col[i]=true;
                dia1[index-i+n-1]=true;
                dia2[index+i]=true;
                //尝试添加
                lis.add(i);
                dfs(n,index+1,lis);
                //回溯
                lis.remove(lis.size()-1);
                col[i]=false;
                dia1[index-i+n-1]=false;
                dia2[index+i]=false;
            }
        }
    }

    public List<String> generateRes(List<Integer> lis){
        List<String> res=new ArrayList<>();
        for (int i=0;i<lis.size();i++) {
            int index = lis.get(i);
            StringBuilder sb=new StringBuilder();
            for (int j=0;j<lis.size();j++) {
                if (j!=index){
                    sb.append(".");
                }else{
                    sb.append("Q");
                }
            }
            res.add(sb.toString());
        }
        return res;
    }

/*    public List<String> generateRes(List<Integer> lis){
        List<String> res=new ArrayList<>();
        for (int i=0;i<lis.size();i++) {
            int index = lis.get(i);
            for (int j=0;j<lis.size();j++) {
                if (j!=index){
                    res.add(".");
                }else{
                    res.add("Q");
                }
            }
        }
        return res;
    }*/
}