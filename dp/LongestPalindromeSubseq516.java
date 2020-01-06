public class LongestPalindromeSubseq516{
    public static void main(String[] args) {

    }

    public int longestPalindromeSubseq(String s) {
        if (s==null || s.length()<=0) {
            return 0;
        }
        int n=s.length();
        int[][] dp=new int[n][n]; //dp[i][j] 代表i~j的最长回文子串
        for (int i=0;i<n;i++) {
            dp[i][i]=1;
        }
        //bbbab
        for (int i=n-1;i>=0;i--) {
            for (int j=i+1;j<n;j++) { //j==i用于初始化
                if (s.charAt(i)==s.charAt(j)) {
                    dp[i][j]=dp[i+1][j-1]+2;
                }else{
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];
    }

    //递归解法,自底向上
    private Integer[][] cache=null;
    
    public int longestPalindromeSubseq(String s) {
        if (s==null || s.length()<=0) {
            return 0;
        }
        int n=s.length();
        cache=new Integer[n][n];
        return helper(s,0,n-1);
    }

    public int helper(String s,int left,int right){
        if (left>right) {
            return 0;
        }
        if (left==right) {
            return 1;
        }
        if (cache[left][right]!=null) {
            return cache[left][right];
        }
        if (s.charAt(left) == s.charAt(right)) {
            return cache[left][right]=helper(s,left+1,right-1)+2;
        }
        return cache[left][right]=Math.max(helper(s,left+1,right),helper(s,left,right-1));
    }

    //LCS的解法
    public int longestPalindromeSubseq(String s) {
        if (s==null || s.length()<=0) {
            return 0;
        }
        int n=s.length();
        int[][] dp=new int[n+1][n+1]; //dp[i][j] 代表s[0,i]~rs[0,j]的最长子序列
        String rs=new StringBuilder(s).reverse().toString();
        for (int i=1;i<=s.length();i++) {
            for (int j=1;j<=rs.length();j++) {
                if (s.charAt(i-1)==rs.charAt(j-1)) {
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][n];
    }
}