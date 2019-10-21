import java.util.*;
public class CoinChange322{
    public static void main(String[] args) {
        CoinChange322 c=new CoinChange322();
        int[] coins={1,2,5};
        System.out.println(c.coinChange4(coins,11));
    }

    //一维
    public int coinChange(int[] coins,int amount){
        int[] dp=new int[amount+1];
        //填充初始值为Integer.MAX_VALUE,代表不可达
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0; //除了dp[0]
        for (int i=0;i<coins.length;i++) {
            //注意这里不能逆序！
            for (int j=coins[i];j<=amount;j++) {
                if (dp[j-coins[i]]!=Integer.MAX_VALUE) {
                    dp[j]=Math.min(dp[j-coins[i]]+1,dp[j]);   
                }
            }
        }
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }

    public int coinChange4(int[] coins,int amount){
        int[][] dp=new int[coins.length][amount+1];
        for (int j=0;j<=amount;j++) {
            dp[0][j]=j%coins[0]==0?j/coins[0]:Integer.MAX_VALUE;
            //System.out.println(dp[0][j]);
        }
        for (int i=1;i<coins.length;i++) {
            for (int j=0;j<=amount;j++) {
                if (j<coins[i] || dp[i][j-coins[i]]==Integer.MAX_VALUE) {
                    dp[i][j]=dp[i-1][j];
                }else {
                    dp[i][j]=Math.min(dp[i][j-coins[i]]+1,dp[i-1][j]);
                }
                //System.out.print(dp[i][j]+",");
            }
            //System.out.println();
        }
        return dp[coins.length-1][amount]!=Integer.MAX_VALUE?dp[coins.length-1][amount]:-1;
    }



    //记忆化递归AC 50%左右
    private Integer[] cache=null;

    public int coinChange2(int[] coins,int amount){
        cache=new Integer[amount+1];
        //Arrays.fill(cache,-1); 这里fill直接tle了。。。。
        return takeCoins(coins,amount);
    }

    public int takeCoins(int[] coins, int amount) {
        if (amount==0) {
            return 0;
        }
        if (cache[amount]!=null) {
            return cache[amount];
        }
        //int t1=coins(coins,amount,index+1);
        int res=Integer.MAX_VALUE;
        for (int i=0;i<coins.length;i++) {
            if (amount<coins[i]) continue;
            int sub=takeCoins(coins,amount-coins[i]);
            if (sub!=-1) {
                res=Math.min(sub+1,res);
            }
        }
        cache[amount]= res==Integer.MAX_VALUE?-1:res;
        return cache[amount];
    }



    //dfs时间复杂度相当恐怖
    //主要是我没写好的问题,按照板子写的
    //其实改成记忆化递归和上面的是一样的
    public int coinChange3(int[] coins, int amount) {
        dfs(coins,amount,0);
        return min==Integer.MAX_VALUE?-1:min;
    }

    private int min=Integer.MAX_VALUE;

    public void dfs(int[] coins, int amount,int count) {
        if (amount<0) return;
        if (amount==0) {
            min=Math.min(count,min);
            return;
        }
        for (int i=0;i<coins.length;i++) {
            dfs(coins,amount-coins[i],count+1);
        }
    }
}