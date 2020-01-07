public class MinInsertions1312{
    public static void main(String[] args) {
        
    }

    public int minInsertions(String s) {
        if (s==null || s.length()<=0) {
            return 0;
        }
        int n=s.length();
        int[][] dp=new int[n][n];
        for (int i=n-1;i>=0;i--) {
            for (int j=i+1;j<n;j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j]=dp[i+1][j-1];   
                }else{
                    //不相等就可以在中间插入一个字符 +1
                    dp[i][j]=1+Math.min(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];
    }
}