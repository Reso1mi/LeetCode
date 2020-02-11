public class CanWinNim292{

    public static void main(String[] args) {

    }

    public boolean canWinNim(int n) {
        boolean[] dp=new boolean[n];
        dp[0]=true;
        dp[1]=true;
        dp[2]=true;
        //t t t f t t t f .....
        //每个状态取决于前3个状态
        for (int i=3;i<n;i++) {
            //分别拿1,2,3个看对面能不能赢
            dp[i]=!dp[i-1] || !dp[i-2] || !dp[i-3];
        }
        return dp[n-1];
    }

    public boolean canWinNim(int n) {
        return n%4!=0;
    }
}