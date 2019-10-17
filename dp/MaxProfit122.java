public class MaxProfit122{
    public static void main(String[] args) {

    }

    //dp的思路
    public int maxProfit(int[] prices) {
        if (prices==null || prices.length<=0) {
            return 0;
        }
        int[][] dp=new int[prices.length][2];
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        for (int i=1;i<prices.length;i++) {
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return dp[prices.length-1][0];
    }

    public int maxProfit(int[] prices) {
        if (prices==null || prices.length<=0) {
            return 0;
        }
        int hlod=-prices[0];
        int empty=0;
        for (int i=1;i<prices.length;i++) {
            int temp=empty;
            empty=Math.max(empty,hlod+prices[i]);
            hlod=Math.max(hlod,temp-prices[i]);
        }
        return empty;
    }

    //正常人的思路
    //股票买卖
    //1. 连续上涨交易日：第一天买,最后一天卖最有价值(或者说除了第一天,每天都卖了又买,这样用代码更容易表述)
    //2. 单独交易日：明天比今天价格高
    //3. 连续下降交易日：不买卖最有利
    public int maxProfit(int[] prices) {
        if (prices==null || prices.length<=0) {
            return 0;
        }
        int ans=0;
        for (int i=1;i<prices.length;i++) {
            if (prices[i]>prices[i-1]) {
                ans+=prices[i]-prices[i-1];
            }
        }
        return ans;
    }
}