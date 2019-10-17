public class MaxProfit309{
    public static void main(String[] args) {

    }

    //1
    public int maxProfit(int[] prices) {
        if (prices==null || prices.length<=0) {
            return 0;
        }
        //dp[i][0] 代表第i天不持有股票的最大利润
        //dp[i][1] 代表第i天持有股票的最大利润
        //dp[i][2] 代表第i天冷冻的最大利润
        int[][] dp=new int[prices.length][3];
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        dp[0][2]=0;
        for (int i=1;i<prices.length;i++) {
            //这些玩意想起还是蛮打脑阔的
            dp[i][0]=dp[i-1][1]+prices[i];
            dp[i][1]=Math.max(dp[i-1][2]-prices[i],dp[i-1][1]);
            dp[i][2]=Math.max(dp[i-1][0],dp[i-1][2]);
        }
        //最后结果是最后一天
        return Math.max(dp[prices.length-1][2],dp[prices.length-1][0]);
    }

    //2
    public int maxProfit(int[] prices) {
        if (prices==null || prices.length<=0) {
            return 0;
        }
        //dp[i][0] 代表第i天不持有股票的最大利润
        //dp[i][1] 代表第i天持有股票的最大利润
        //dp[i][2] 代表第i天冷冻的最大利润
        int[][] dp=new int[prices.length][3];
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        dp[0][2]=0;
        for (int i=1;i<prices.length;i++) {
            //这些玩意想起还是蛮打脑阔的
            dp[i][0]=Math.max(dp[i-1][1]+prices[i],dp[i-1][0]);
            dp[i][1]=Math.max(dp[i-1][2]-prices[i],dp[i-1][1]);
            dp[i][2]=dp[i-1][0];
        }
        return dp[prices.length-1][0];
    }

    //还是这种好理解
    public int maxProfit(int[] prices) {
        if (prices==null || prices.length<=0) {
            return 0;
        }
        //dp[i][0] 代表第i天不持有股票的最大利润
        //dp[i][1] 代表第i天持有股票的最大利润
        int[][] dp=new int[prices.length][2];
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        for (int i=1;i<prices.length;i++) {
            //这些玩意想起还是蛮打脑阔的
            dp[i][0]=Math.max(dp[i-1][1]+prices[i],dp[i-1][0]);
            //dp[i][1]=Math.max(i<2?-prices[i]:dp[i-2][0]-prices[i],dp[i-1][1]);
            dp[i][1]=Math.max(i<2?-prices[1]:dp[i-2][0]-prices[i],dp[i-1][1]);
        }
        return dp[prices.length-1][0];
    }

    public int maxProfit(int[] prices) {
        if (prices==null || prices.length<=0) {
            return 0;
        }
        int hold=-prices[0];
        int empty=0;
        //前一天买出的最大收益
        int prePre=0;
        for (int i=1;i<prices.length;i++) {
            int temp=empty;
            empty=Math.max(hold+prices[i],empty);
            hold=Math.max(i<2?-prices[1]:prePre-prices[i],hold);
            //到这里pre就变成了前一天
            prePre=temp;
        }
        return empty;
    }
}
