public class LCS{
    public static void main(String[] args) {

    }

    public int longestCommonSubsequence(String A, String B) {
        int[][] dp=new int[A.length()+1][B.length()+1];
        for (int i=1;i<=A.length();i++) {
            for (int j=1;j<=B.length();j++) {
                if (A.charAt(i-1)==B.charAt(j-1)) {
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[A.length()][B.length()];
    }
}