public class NumberOfArrays5375{
    public static void main(String[] args) {

    }

    public int numberOfArrays(String s, int k) {
        int mod=1_000_000_000 + 7;
        int[] dp=new int[s.length()+1];        
        dp[0]=1;
        //dp[i]=dp[i-1]+dp[i-2]+...+dp[0];
        for (int i=1;i<=s.length();i++) {
            for (int j=i-1;j>=0 && i-j<=9;j--) {
                if(s.charAt(j)!='0' && valid(s,j,i,k)){
                    dp[i]=(dp[i]+dp[j])%mod;
                }
            }
        }
        return dp[s.length()];
    }

    //10 0000 0000
    public boolean valid(String s,int j,int i,int k){
        long value=Long.valueOf(s.substring(j,i));
        return value<=k && value>=1;
    }

    public int numberOfArrays(String s, int k) {
        int mod=1_000_000_000 + 7;
        int[] dp=new int[s.length()+1];        
        dp[0]=1;
        for (int i=1;i<=s.length();i++) {
            for (int j=i-1;j>=0 && i-j<=9;j--) {
                if(s.charAt(j)=='0') continue;
                long value=Long.valueOf(s.substring(j,i));
                if(value>k) break; //这一步其实是对上面解法的优化
                dp[i]=(dp[i]+dp[j])%mod;
            }
        }
        return dp[s.length()];
    }
}