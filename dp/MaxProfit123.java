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

    //2020.3.28新增状态机解法
    public int maxProfit(int[] prices){
        if (prices==null || prices.length<=0) {
            return 0;
        }
        //状态定义：
        //j=0 什么都不做
        //j=1 第一次买入
        //j=2 第一次卖出
        //j=3 第二次买入
        //j=4 第二次卖出
        int[][] dp=new int[prices.length][5];
        //这样会溢出
        //Arrays.fill(dp[0],Integer.MIN_VALUE);
        //这样可以过,但是感觉还是判断一下好
        //Arrays.fill(dp[0],-0x3f3f3f3f);
        int INF=Integer.MIN_VALUE,n=prices.length;
        Arrays.fill(dp[0],INF); //不可达状态
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        for(int i=1;i<n;i++){
            dp[i][0]=0;
            dp[i][1]=Math.max(-prices[i],dp[i-1][1]);
            dp[i][2]=Math.max(dp[i-1][1]+prices[i],dp[i-1][2]);
            dp[i][3]=Math.max(dp[i-1][2]!=INF?dp[i-1][2]-prices[i]:INF,dp[i-1][3]);
            dp[i][4]=Math.max(dp[i-1][3]!=INF?dp[i-1][3]+prices[i]:INF,dp[i-1][4]);
        }
        return Math.max(Math.max(dp[n-1][0],dp[n-1][2]),dp[n-1][4]);
    }

    public int maxProfit(int[] prices){
        if (prices==null || prices.length<=0) {
            return 0;
        }
        //状态机：
        //j=0 什么都不做
        //j=1 第一次买入
        //j=2 第一次卖出
        //j=3 第二次买入
        //j=4 第二次卖出
        int[] dp=new int[5];
        //这样会溢出
        //Arrays.fill(dp[0],Integer.MIN_VALUE);
        //这样可以,但是感觉还是判断一下好
        //Arrays.fill(dp[0],-0x3f3f3f3f);
        int INF=Integer.MIN_VALUE,n=prices.length;
        Arrays.fill(dp,INF); //不可达状态
        dp[0]=0;
        dp[1]=-prices[0];
        for(int i=1;i<n;i++){
            //逆序递推(其实正着写也是对的,相邻的状态不会同时更新)
            dp[4]=Math.max(dp[3]!=INF?dp[3]+prices[i]:INF,dp[4]);
            dp[3]=Math.max(dp[2]!=INF?dp[2]-prices[i]:INF,dp[3]);
            dp[2]=Math.max(dp[1]+prices[i],dp[2]);
            dp[1]=Math.max(-prices[i],dp[1]);
            dp[0]=0;
        }
        return Math.max(Math.max(dp[0],dp[2]),dp[4]);
    }

    public int maxProfit(int[] prices){
        if (prices==null || prices.length<=0) {
            return 0;
        }
        int[] dp=new int[5];
        int n=prices.length;
        Arrays.fill(dp,-0x3f3f3f3f);
        dp[0]=0;
        dp[1]=-prices[0];
        for(int i=1;i<n;i++){
            //逆序递推避免覆盖(其实正着写也是对的,这题相邻的状态不会同时更新,但是为了规范最好还是逆序写)
            dp[4]=Math.max(dp[3]+prices[i],dp[4]);
            dp[3]=Math.max(dp[2]-prices[i],dp[3]);
            dp[2]=Math.max(dp[1]+prices[i],dp[2]);
            dp[1]=Math.max(-prices[i],dp[1]);
            dp[0]=0;
        }
        return Math.max(Math.max(dp[0],dp[2]),dp[4]);
    }
}