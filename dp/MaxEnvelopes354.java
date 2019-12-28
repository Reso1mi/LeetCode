import java.util.*;
public class MaxEnvelopes354{
    public static void main(String[] args) {
        MaxEnvelopes354 m=new MaxEnvelopes354();
        int[][] envelopes={{3,4},{5,6},{7,8},{1,2}};
        System.out.println(m.maxEnvelopes(envelopes));
    }

    public int maxEnvelopes(int[][] envelopes) {
        int [] dp=new int[envelopes.length];
        //lamdba会比较慢
        Arrays.sort(envelopes,(a,b)->(a[0]-b[0])); //保证后面的不会被前面的装进去就行了
        int res=0;
        for (int i=0;i<envelopes.length;i++) {
            dp[i]=1;
            for (int j=0;j<i;j++) {
                if (envelopes[i][0]>envelopes[j][0] && envelopes[i][1]>envelopes[j][1]){
                    dp[i]=Math.max(dp[j]+1,dp[i]);
                }
            }
            res=Math.max(res,dp[i]);
        }
        return res;
    }

    //贪心+二分的实在看不懂
}