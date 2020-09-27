public class MeiTuan2020 {
    public static void main(String[] args) {
        int a = 2;
        int b= 3;
        int c = 4;
        int d = 5;
        int e = 6;
        int f = 7;
        int g = 8;
        Integer[][][][] dp = new Integer[a+1][b+1][c+1][d+1];
        System.out.println(dfs(a,b,c,d,dp, e,f,g));
    }

    public static int dfs(int a, int b, int c, int d, Integer[][][][] dp, int e, int f, int g) {
        if (dp[a][b][c][d] != null) {
            return dp[a][b][c][d];
        }
        int res = 0;
        if (a-1 >= 0 && d-1 >= 0) {
            res = Math.max(dfs(a-1, b, c, d-1,dp, e, f, g)+e, res);
        }

        if (b-1 >= 0 && d-1 >= 0) {
            res = Math.max(dfs(a, b-1, c, d-1,dp, e, f, g)+f, res);
        }

        if (c-1 >= 0 && d-1 >= 0) {
            res = Math.max(dfs(a, b, c-1, d-1,dp, e, f, g)+g, res);
        }
        return dp[a][b][c][d] = res;
    }
}