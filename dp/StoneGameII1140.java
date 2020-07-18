public class StoneGameII1140{
    public static void main(String[] args) {
        
    }

    int n = 0;
    
    Integer[][] cache;
    
    public int stoneGameII(int[] piles) {
        n = piles.length;
        int[] preSum = new int[n+1];
        cache = new Integer[n+1][n+1];
        preSum[0] = 0;
        for(int i = 1; i <=n; i++){
            preSum[i] = preSum[i-1] + piles[i-1];
        }
        return dfs(preSum, 0, 1);
    }
    
    public int dfs(int[] preSum, int start, int M){
        if(cache[start][M]!=null){
            return cache[start][M];
        }
        int res = 0;
        for(int len = 1; start + len - 1 < n && len <= 2*M; len++){
            //start=0 len=2 (0,1)
            int temp = preSum[n] - preSum[start] - dfs(preSum, start + len, Math.max(M, len));
            res = Math.max(res, temp);
        }
        return cache[start][M] = res;
    }
}