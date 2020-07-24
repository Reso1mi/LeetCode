public class Largest1BorderedSquare1139{
    public static void main(String[] args) {
        Largest1BorderedSquare1139 l = new Largest1BorderedSquare1139();
        int[][] grid2 = {{1,1,1},
                        {1,0,1},
                        {1,1,1}};
        //WA1: [[1,1,0],[1,1,1],[1,1,1],[1,1,1]]
        int[][] grid3 = {{1,1,0},
                        {1,1,1},
                        {1,1,1},
                        {1,1,1}};
        //WA2: [[0,1,1,1,1,0],
        //      [1,1,0,1,1,0],
        //      [1,1,0,1,0,1],
        //      [1,1,0,1,1,1],
        //      [1,1,0,1,1,1],
        //      [1,1,1,1,1,1],
        //      [1,0,1,1,1,1],
        //      [0,0,1,1,1,1],
        //      [1,1,1,1,1,1]]
        System.out.println(l.largest1BorderedSquare(grid));
    }

    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //dp[i][j][0]: i,j左边连续的1的个数
        //dp[i][j][1]: i,j上边连续的1的个数
        int[][][] dp = new int[m+1][n+1][2];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (grid[i-1][j-1] == 1){
                    dp[i][j][0] = 1 + dp[i][j-1][0];
                    dp[i][j][1] = 1 + dp[i-1][j][1];
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //WA点2：最短的那条边不一定是边长，可以更短所以需要遍历所有小于最短边长的长度
                //所以题目的数据范围是不会骗人的，给的100那么时间复杂度一定不是N2的
                for (int side = Math.min(dp[i][j][0], dp[i][j][1]); side >= 1; side--){
                    //WA点1：大于等于
                    if (dp[i][j-side+1][1] >= side && dp[i-side+1][j][0] >= side){
                        res = Math.max(res, side);
                        break; //更短的就没必要考虑了
                    }
                }
            }
        }
        return res * res;
    }
}