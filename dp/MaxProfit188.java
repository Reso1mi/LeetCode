public class MaxProfit188{
    public static void main(String[] args) {

    }

    public int maxProfit(int k, int[] prices) {
        if (prices==null || prices.length<=0 || k<=0) {
            return 0;
        }
        if(k>prices.length/2){
            return maxProfit(prices);
        }
        //k次交易,2*k+1种状态
        int[] dp=new int[2*k+1];
        int n=prices.length;
        int res=0;
        Arrays.fill(dp,-0x3f3f3f3f);
        dp[0]=0;
        dp[1]=-prices[0];
        for(int i=1;i<n;i++){
            //注意倒推
            for(int j=2*k;j>0;j--){
                if((j&1)==1){
                    dp[j]=Math.max(dp[j-1]-prices[i],dp[j]);
                }else{
                    dp[j]=Math.max(dp[j-1]+prices[i],dp[j]);
                    res=Math.max(dp[j],res);
                }
            }
        }
        return res;
    }

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


    //常规2维解法
    public int maxProfit(int k, int[] prices) {
        if (prices==null || prices.length<=0 || k<=0) {
            return 0;
        }
        if(k>prices.length/2){
            return maxProfit(prices);
        }
        //第k次交易,持股/不持股
        int[][] dp=new int[k+1][2];
        int n=prices.length;
        int res=0;
        int INF=-0x3f3f3f3f;
        for(int i=0;i<=k;i++){
            Arrays.fill(dp[i],INF);
        }
        //其实这题难搞的就是对于初始状态的init
        //第一天没有交易和第一天有一次交易的初始值
        dp[0][0]=0;dp[0][1]=INF;
        dp[1][0]=0;dp[1][1]=-prices[0];
        for(int i=1;i<n;i++){
            //注意倒推
            for(int j=k;j>0;j--){
                //这里将买入和卖出作为一个状态,所以这里买入新股票，肯定就是属于下一次交易了
                //所以这里的j需要减一，代表上一次交易卖出时候的收益
                dp[j][0]=Math.max(dp[j][1]+prices[i],dp[j][0]);
                dp[j][1]=Math.max(dp[j-1][0]-prices[i],dp[j][1]);
                res=Math.max(dp[j][0],res);
            }
        }
        return res;
    }

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