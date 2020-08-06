public class StoneGameIII1406{

    //后缀数组
    int[] sufSum = null;
    
    Integer[] dp = null;

    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        sufSum = new int[n+1];
        dp = new Integer[n+1];
        for (int i = n-1; i >= 0; i--){
            sufSum[i] = sufSum[i+1] + stoneValue[i];
        }
        int alice = dfs(stoneValue, 0);
        int bob = sufSum[0]-alice;
        if (alice == bob) {
            return "Tie";
        }
        return alice > bob ? "Alice" : "Bob";
    }
    
    public int dfs(int[] sv, int start){
        if (start > sv.length) {
            return 0;
        }
        if (dp[start]!=null) {
            return dp[start];
        }
        int sum = sufSum[start];
        return dp[start] = Math.max(sum-dfs(sv, start+1), Math.max(sum-dfs(sv, start+2), sum-dfs(sv, start+3)));
    }
}