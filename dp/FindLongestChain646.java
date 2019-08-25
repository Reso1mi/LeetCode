import java.util.*;
public class FindLongestChain646{
    public static void main(String[] args) {

    }

    /*
    输入: [[1,2], [2,3], [3,4]]
    输出: 2
    解释: 最长的数对链是 [1,2] -> [3,4]
     */
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->a[0]-b[0]);
        int[] dp=new int[pairs.length];
        int res=0;
        for (int i=0;i<pairs.length;i++) {
            dp[i]=1;
            for (int j=0;j<i;j++) {
                if (pairs[i][0]>pairs[j][1]) {
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            res=res>dp[i]?res:dp[i];
        }
        return res;
    }

    //贪心
    public int findLongestChain2(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->a[1]-b[1]);
        int res=0;
        int tail=pairs[0][1];
        for (int i=1;i<pairs.length;i++) {
            if (pairs[i][0]>tail) {
                res++;
                tail=pairs[i][1];
            }
        }
        return res;
    }
}