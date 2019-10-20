public class CoinChange322{
    public static void main(String[] args) {

    }

    /*
    int coinChange(vector<int>& coins, int amount) {
        if (amount == 0) return 0;
        int ans = INT_MAX;
        for (int coin : coins) {
            // 金额不可达
            if (amount - coin < 0) continue;
            int subProb = coinChange(coins, amount - coin);
            // 子问题无解
            if (subProb == -1) continue;
            ans = min(ans, subProb + 1);
        }
    return ans == INT_MAX ? -1 : ans;
    }

     */
    
    public int coinChange(int[] coins,int amount){
        int[] dp=new int[amount+1];
        for (int i=0;i<coins.length;i++) {
            for (int j=amount;j>=coins[i];j--) {
                if (i==0) {
                    dp[j]= amount%coins[i]==0? amount/coins[i] :-1;
                }else{
                    dp[j]=Math.min(dp[j-coins[i]]+1,dp[j]);
                }
            }
        }
        return dp[amount];
    }


    //记忆化递归AC 50%左右
    private Integer[] cache=null;

    public int coinChange(int[] coins,int amount){
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
    public int coinChange(int[] coins, int amount) {
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