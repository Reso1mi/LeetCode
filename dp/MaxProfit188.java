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
        int[] dp=new int[2*k+1];
        int n=prices.length;
        int res=0;
        Arrays.fill(dp,-0x3f3f3f3f);
        dp[0]=0;
        dp[1]=-prices[0];
        for(int i=1;i<n;i++){
            //k次交易,2*k+1种状态
            dp[0]=0;
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
}