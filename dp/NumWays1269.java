public class NumWays1269{
    public static void main(String[] args) {

    }

    int mod=1_000_000_007;

    //cache
    Long[][] cache;

    public int numWays(int steps, int arrLen) {
        int maxIndex=Math.min(steps,arrLen-1);
        cache=new Long[steps+1][maxIndex+1];
        return (int)dfs(steps,0,maxIndex);
    }

    public long dfs(int steps, int index,int maxIndex) {
        if (steps==0) {
            return index==0?1:0;
        }
        if (index<0 || index > maxIndex )  {
            return 0;
        }

        if (cache[steps][index]!=null) {
            return cache[steps][index];
        }
        //steps一直在递减,steps最多走到steps位置
        //为了节约时间可以在这里优化下
        maxIndex=Math.min(steps,maxIndex);
        long res=dfs(steps-1,index,maxIndex);
        res+=dfs(steps-1,index-1,maxIndex);
        res+=dfs(steps-1,index+1,maxIndex);
        return cache[steps][index]=res%mod;
    }


    public int numWays(int steps, int arrLen) {
        int mod=1_000_000_007;
        long[][] dp=new long[steps+1][steps+1];
        dp[0][0]=1;
        //dp[0][1]=1;
        for (int i=1;i<=steps;i++) {
            //i步能达到的最大距离就是i, 比如1,2就是不可能的,不用考虑
            //所以我们这里取一个最小值
            int k=Math.min(i,arrLen-1);
            for (int j=0;j<=k;j++) {
                if (j==0) {
                    dp[i][j]=(dp[i-1][j+1]+dp[i-1][j])%mod;
                }else if (j<k) {
                    dp[i][j]=(dp[i-1][j-1]+dp[i-1][j+1]+dp[i-1][j])%mod;
                }else{
                    dp[i][j]=(dp[i-1][j-1]+dp[i-1][j])%mod;
                }
            }
        }
        return (int)dp[steps][0];
    }
}