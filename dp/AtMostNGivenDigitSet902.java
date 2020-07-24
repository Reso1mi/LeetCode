public class AtMostNGivenDigitSet902 {

    public static void main(String[] args) {
    
    }

    boolean[] dict;

    int[] nums;
    
    Integer[] dp;

    public int atMostNGivenDigitSet(String[] D, int N) {
        int pos = -1;
        nums = new int[64];
        while (N > 0) {
            nums[++pos] = N % 10;
            N /= 10;
        }
        dict = new boolean[10];
        dp = new Integer[pos + 1];
        for (int i = 0; i < D.length; i++) {
            dict[Integer.valueOf(D[i])] = true;
        }
        return dfs(pos, true, true);
    }

    //从pos~0有多少个合法的数
    public int dfs(int pos, boolean leadZero, boolean limit) {
        if (pos == -1) {
            //枚举完所有的数位，没有前导0说明找到了一个合法的数
            return leadZero ? 0 : 1;
        }
        if (!leadZero && !limit && (dp[pos] != null)) {
            return dp[pos];
        }
        int res = 0;
        int up = limit ? nums[pos] : 9;
        for (int i = 0; i <= up; i++) {
            //前面全是0 || 当前位在dict中
            if ((leadZero && (i == 0)) || dict[i]) {
                res += dfs(pos - 1, leadZero && (i == 0), limit && (i == up));
            }
        }
        if (!leadZero && !limit) {
            dp[pos] = res;
        }
        return res;
    }
}
