public class MaxProfit123{
    public static void main(String[] args) {

    }


    public int maxProfit(int[] prices) {
        if (prices ==null|| prices.length<=0) {
            return 0;
        }
        int[][][] dp=new int[prices.length][3][2];
        for (int i=0;i<prices.length;i++) {
            for (int k=2;k>0;k--) {
                if(i==0){
                    dp[i][k][0]=0;
                    dp[i][k][1]=-prices[i];
                }else{
                    dp[i][k][0]=Math.max(dp[i-1][k][0],dp[i-1][k][1]+prices[i]);
                    dp[i][k][1]=Math.max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i]);
                }
            }
        }
        return dp[prices.length-1][2][0];
    }

    public int maxProfit(int[] prices){
        if (prices==null || prices.length<=0) {
            return 0;
        }
        //当天第一次买入的最大收益
        int firstBuy=Integer.MIN_VALUE;
        //当天第一次卖出的最大收益
        int firstSell=0;
        //当天第二次买入的最大收益
        int secondBuy=Integer.MIN_VALUE;
        //当天第二次卖出的最大收益
        int secondSell=0;
        for (int i=0;i<prices.length;i++) {
            firstBuy=Math.max(-prices[i],firstBuy);
            firstSell=Math.max(prices[i]+firstBuy,firstSell);
            secondBuy=Math.max(firstSell-prices[i],secondBuy);
            secondSell=Math.max(prices[i]+secondBuy,secondSell);
        }
        return secondSell;
    }
}