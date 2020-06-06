public class New21Game837{
    public double new21Game(int N, int K, int W) {
        if(K==0) return 1;
        //随机抽牌和为i的概率，背包问题
        double[] dp=new double[N+1];
        dp[0]=1;
        dp[1]=1.0/W;
        // i<=K
        //dp[i] = 1/W(dp[i-1]+dp[i-2]+...+dp[i-W]);
        //dp[i-1] = 1/W(dp[i-2]+dp[i-3]+...+dp[i-W-1])
        //==> dp[i]=(1 + 1/W)*dp[i-1]-(1/W)*dp[i-W-1]
        for(int i=2;i<=K;i++){
            if(i-W-1>=0){
                dp[i]=(1+1.0/W)*dp[i-1]-1.0/W*dp[i-W-1];
            }else{
                dp[i]=(1+1.0/W)*dp[i-1];
            }
        }
        // i>K 从i-W ~ i区间选小于K的部分
        //dp[i] = 1/W(dp[K-1]+dp[K-2]+...+dp[i-W]) or dp[i]=1/W(dp[i-W]+dp[i-W+1]+..+dp[K-1])
        //dp[i-1] = 1/W(dp[k-1]+dp[K-2]+...+dp[i-W-1]) or dp[i+1] = 1/W(dp[i-W+1]+dp[i-W+2]...+dp[K-1])
        //==> dp[i] = dp[i-1]-1/W*dp[i-W-1] or dp[i]=1/W*dp[i-W]+dp[i+1] 两个是等价的
        for (int i=K+1;i<=N;i++) {
            if(i-W-1>=0){
                dp[i]=dp[i-1]-1.0/W*dp[i-W-1];  
            }else{
                dp[i]=dp[i-1]; //1/W
            }
        }
        double res=0;
        for (int i=K;i<=N;i++) {
            res+=dp[i];
        }
        return res;
    }
}