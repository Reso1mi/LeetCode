public class MaxProfit121{
    public static void main(String[] args) {
        
    }

    //动态规划的板子,还是可以看的懂得
    public int maxProfit(int[] prices) {
        if (prices==null || prices.length<=0) {
            return 0;
        }
        int[][] dp=new int[prices.length][2];
        dp[0][0]=0;
        dp[0][1]= -prices[0];
        for (int i=1;i<prices.length;i++) {
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],-prices[i]);
        }
        return dp[prices.length-1][0];
    }

    //非递归的思路
    public int maxProfit2(int[] prices) {
        if (prices==null || prices.length<=0) {
            return 0;
        }
        int min=Integer.MAX_VALUE,max=0;
        for (int i=0;i<prices.length;i++) {
            //当天价格减去*之前*价格最低的买入时机
            max=Math.max(max,prices[i]-min);
            //统计价格最低的买入时机
            min=Math.min(min,prices[i]);
        }
        return max;
    }

    //头条面筋,记录索引
    public int[] maxProfit3(int[] prices) {
        if (prices==null || prices.length<=0) {
            return new int[0];
        }
        int[] res=new int[2];
        int min=0,max=-1; //最小值索引和最大收益
        for (int i=0;i<prices.length;i++) {
            //当天价格减去*之前*价格最低的买入时机
            int temp=prices[i]-prices[min];
            if(temp>max){
                max=temp;
                res[0]=min;
                res[1]=i;
            }
            //统计价格最低的买入时机
            min=prices[i]<min?i:min;
        }
        return res;
    }
}