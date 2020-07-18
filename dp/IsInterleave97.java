public class IsInterleave97{
    public static void main(String[] args) {
        
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int ns1 = s1.length(), ns2 = s2.length(), ns3 = s3.length();
        if(ns1+ns2!=ns3) return false;
        boolean[][] dp = new boolean[ns1+1][ns2+1];
        for(int i = 1; i <= ns1 && s1.charAt(i-1)==s3.charAt(i-1); i++){
            dp[i][0] = true;
        }
        for(int i = 1; i <= ns2 && s2.charAt(i-1)==s3.charAt(i-1); i++){
            dp[0][i] = true;
        }
        dp[0][0] = true;
        for(int i = 1; i <= ns1; i++){
            for(int j = 1; j <= ns2; j++){
                char sc = s3.charAt(i+j-1);
                dp[i][j] = (sc == s1.charAt(i-1) && dp[i-1][j]) 
                    || sc == s2.charAt(j-1) && dp[i][j-1];
            }
        }
        return dp[ns1][ns2];
    }
}