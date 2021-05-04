class Solution {
    public boolean canCross(int[] s) {
        int n = s.length;
        if (s[1] != 1) return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(s[i], i);
        }
        boolean[][] dp = new boolean[n][n];
        dp[0][1] = true;
        for (int i = 1; i < n; i++) {
            // 枚举上一个落脚点
            for (int j = i-1; j >= 0; j--) {
                int k = s[i]-s[j];
                if (dp[j][i]) {
                    // 枚举下一跳的落脚点
                    Integer a = map.get(s[i]+k-1), b = map.get(s[i]+k), c = map.get(s[i]+k+1);
                    if (a != null) dp[i][a] =  true;
                    if (b != null) dp[i][b] =  true;
                    if (c != null) dp[i][c] =  true;
                }
            }
            if (dp[i][n-1]) return true;
        }
        return false;
    }
}