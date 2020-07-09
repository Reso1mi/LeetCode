import java.util.*;
public class Respace17_13{
    public static void main(String[] args) {

    }

    public int respace(String[] dictionary, String s) {
        int BASE = 131;
        long MOD = Integer.MAX_VALUE;
        HashSet<Long> set = new HashSet<>();
        for (String word : dictionary ) {
            set.add(hash(word, BASE, MOD));
        }
        int n = s.length();
        int[] dp = new int[n+1];
        for (int i = 1; i <=n ; i++) {
            dp[i] = dp[i-1] + 1;
            long rollhash = 0;
            for (int j = i; j >= 1; j--) {
                rollhash = (rollhash * BASE + s.charAt(j-1)) % MOD;
                if(set.contains(rollhash)){
                    //注意这里是dp[j-1]，对应s.charAt(j-1)的前一个字符
                    dp[i] = Math.min(dp[i], dp[j-1]);
                }
                if(dp[i] == 0){
                    break;
                }
            }
        }
        return dp[n];
    }

    //注意需要逆向hash，上面计算的时候是j--，是逆向的
    public long hash(String s, int BASE, long MOD){
        long h = 0;
        for (int i = s.length()-1; i >=0 ; i--) {
            h = (h * BASE + s.charAt(i)) % MOD;
        }
        return h;
    }
}