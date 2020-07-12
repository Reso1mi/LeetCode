public class CalculateMinimumHP174{
    public static void main(String[] args) {

    }

    public int calculateMinimumHP(int[][] dungeon) {
        int left = 0;
        int right = Integer.MAX_VALUE;
        int res = 0;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(check(dungeon, mid)){
                res = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return res;
    }
    
    public boolean check(int[][] dungeon, int live){
        int m = dungeon.length;
        int n = dungeon[0].length;
        int INF = Integer.MIN_VALUE;
        //live的血量从左上到dungeon[i][j]的剩余最多血量
        int[][] dp = new int[m+1][n+1];
        //地牢外围加上INF的围墙，简化逻辑
        Arrays.fill(dp[0], INF);
        dp[0][1] = live;
        for(int i = 1; i <= m; i++){
            dp[i][0] = INF;
            for(int j = 1; j <= n; j++){
                if(dp[i-1][j] <= 0 && dp[i][j-1] <=0 ){
                    dp[i][j] = INF; //无法到达这里
                }else{
                    dp[i][j] = dungeon[i-1][j-1] + Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[m][n] > 0;
    }

    /*
    -2  -3  3
    -5 -10  1
    10  30 -5 1
            
    7   5   2
    6  11   5
    1   1   6
     */
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int INF = Integer.MAX_VALUE;
        //从dungeon[i-1][j-1]到右下角至少要多少血量
        int[][] dp = new int[m+1][n+1];
        Arrays.fill(dp[m], INF);//末行
        dp[m][n-1] = 1; //初始血量
        for (int i = m-1; i >= 0; i--) {
            dp[i][n] = INF; //首列和尾列
            for (int j = n-1; j >= 0; j--) {
                dp[i][j] = Math.max(Math.min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j], 1);
            }
        }
        return dp[0][0];
    }
}