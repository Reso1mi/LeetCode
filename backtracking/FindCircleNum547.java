public class FindCircleNum547{
    public static void main(String[] args) {

    }

    /*
    [
     [1,1,1], 
     [1,1,0], 
     [0,0,1] 
    ]
     */
    public int findCircleNum(int[][] M) {
        if (M==null || M.length<=0) {
            return 0;
        }
        boolean[] visit=new boolean[M.length];
        int count=0;
        for (int i=0;i<M.length;i++) {
            if (!visit[i]) {
                dfs(M,visit,i);
                count++;
            }
        }
        return count;
    }

    //一共m.length个人
    public void dfs(int[][] M,boolean[] visit,int index) {
        //标记index号学生已经访问过
        visit[index]=true;
        for (int i=0;i<M.length;i++) {
            //index和i是好朋友
            if (M[index][i]==1 && !visit[i]) {
                //递归标记i的好朋友,形成朋友圈
                dfs(M,visit,i);
            }
        }
    }
}