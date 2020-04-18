public class StoneGame877{
    public static void main(String[] args) {

    }

    //数学
    public boolean stoneGame(int[] piles) {
        return true;
    }

    //通用的区间DP
    public boolean stoneGame(int[] piles) {
        //[5,3,4,5]
        int N=piles.length;
        //(i~j) 先手(0),后手(1)的最大收益
        int[][][] dp=new int[N][N][2];
        //base init len=1的情况
        for(int i=0;i<N;i++){
            dp[i][i][0]=piles[i];
            dp[i][i][1]=0;
        }
        for (int len=2;len<=N;len++) { //枚举区间长度
            for (int left=0;left<=N-len;left++) {
                //left+len-1<N
                int right=left+len-1;
                int firLeft=piles[left]+dp[left+1][right][1];
                int firRight=piles[right]+dp[left][right-1][1];
                if(firLeft>firRight){
                    dp[left][right][0]=firLeft;
                    dp[left][right][1]=dp[left+1][right][0];
                }else{
                    dp[left][right][0]=firRight;
                    dp[left][right][1]=dp[left][right-1][0];
                }
            }
        }
        return dp[0][N-1][0]-dp[0][N-1][1]>0;
    }
}