public class IsMatch44{
    public static void main(String[] args) {

    }

    //s待匹配字符,p是字符模式
    //aa *
    //cb ?a
    public boolean isMatch(String s, String p) {
        //dp[i][j]代表s[0,i-1](s的前i个字符),p[0,j-1](p的前j个字符)是否匹配
        boolean[][] dp=new boolean[s.length()+1][p.length()+1];        
        //dp[i][0]=false dp[0][j] p[j]=="*"|"?"
        dp[0][0]=true;
        for (int j=1;j<=p.length();j++) {
            if (p.charAt(j-1)=='*') {
                dp[0][j]=dp[0][j-1]; //dp[0][j]=true是错的
            }
        }
        //1. p[i]=p[j] dp[i][j]=dp[i-1][j-1]
        //2. p[j]="?"  dp[i][j]=dp[i-1][j-1]
        //3. p[j]="*"  dp[i][j]=dp[i-1][j] | dp[i][j-1]
        for (int i=1;i<=s.length();i++) {
            for (int j=1;j<=p.length();j++) {
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1)=='?') {
                    dp[i][j]=dp[i-1][j-1];
                }else if (p.charAt(j-1)=='*') { //abc ab* | ab ab*
                    dp[i][j]=dp[i-1][j]|dp[i][j-1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}