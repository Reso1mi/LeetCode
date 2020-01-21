public class MinTaps1326{
    public static void main(String[] args) {

    }

    //动态规划
    public int minTaps(int n, int[] ranges) {
        int[] dp=new int[n+1]; //浇溉i位置前需要最少的水龙头
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for (int i=0;i<=n;i++) {
            int left=Math.max(0,i-ranges[i]);
            int right=Math.min(n,i+ranges[i]);
            if (dp[left]==Integer.MAX_VALUE) { //左边界不可达
                continue;
            }
            for (int j=left+1;j<=right;j++) {
                dp[j]=Math.min(dp[j],dp[left]+1); //范围内的区域dp值
            }
        }
        return dp[n]==Integer.MAX_VALUE?-1:dp[n];
    }

    //贪心
    public int minTaps(int n,int[] ranges){
        

    }
}