public class CanIWin464{

    public static void main(String[] args) {
        CanIWin464 c=new CanIWin464();
        System.out.println(c.canIWin(2,2));
    }

    //TLE 41/45: 20 210
    public boolean canIWin2(int maxChoosableInteger, int desiredTotal) {
        //小于最大值先手可以直接拿
        if(desiredTotal<=maxChoosableInteger) return true;
        //前N项和还不够desiredTotal
        if((1+maxChoosableInteger)*(maxChoosableInteger)/2<desiredTotal) return false;
        boolean[] visit=new boolean[maxChoosableInteger+1];
        return dfs(maxChoosableInteger,desiredTotal,visit);
    }

    /* 错误写法
    public boolean dfs(int max,int total,boolean[] visit){
        if(total<=0) return false;
        for (int i=1;i<=max;i++) {
            if(!visit[i]){
                visit[i]=true;
                if(!dfs(max,total-i,visit)){
                    return true;
                }
                visit[i]=false;
            }
        }
        return false;
    }
    */

    public boolean dfs(int max,int total,boolean[] visit){
        //System.out.println("t:"+total);
        if(total<=0) return false;
        for (int i=1;i<=max;i++) {
            if(!visit[i]){
                visit[i]=true;
                boolean temp=dfs(max,total-i,visit);
                visit[i]=false;
                if(!temp){
                    return true;
                }
            }
        }
        //System.out.println(">>>");
        return false;
    }

    Boolean[] dp=null;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        //小于最大值先手可以直接拿
        if(desiredTotal<=maxChoosableInteger) return true;
        //前N项和还不够desiredTotal
        if((1+maxChoosableInteger)*(maxChoosableInteger)/2<desiredTotal) return false;
        //20位二进制 1<<21
        dp=new Boolean[1<<21];
        return dfs(maxChoosableInteger,desiredTotal,0);
    }

    public boolean dfs(int max,int total,int state){
        if(total<=0) return false;
        if(dp[state]!=null){
            return dp[state];
        }
        for (int i=max;i>=1;i--) {
            if((state>>i&1)==0 && !dfs(max,total-i,state|(1<<i))){
                return dp[state]=true;
            }
        }
        return dp[state]=false;
    }

    //int做状压，似乎性能没有提升
    int[] dp=null; //0:未初始化 1:true 2:false

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        //小于最大值先手可以直接拿
        if(desiredTotal<=maxChoosableInteger) return true;
        //前N项和还不够desiredTotal
        if((1+maxChoosableInteger)*(maxChoosableInteger)/2<desiredTotal) return false;
        //20位二进制 1<<21
        dp=new int[1<<21];
        return dfs(maxChoosableInteger,desiredTotal,0);
    }

    public boolean dfs(int max,int total,int state){
        if(dp[state]!=0){
            return dp[state]==1;
        }
        for (int i=max;i>=1;i--) {
            //参数传递的，就不用回溯了，代码变的简洁多了
            if((state>>i&1)==0 && (i>=total || !dfs(max,total-i,state|(1<<i)))){
                dp[state]=1;
                return true;
            }
        }
        dp[state]=2;
        return false;
    }
}