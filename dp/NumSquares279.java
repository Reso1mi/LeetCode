import java.util.*;

public class  NumSquares279{
    public static void main(String[] args) {
        System.out.println(numSquares(9));
    }
    // 1    1
    // 2    1 1s
    // 3    1 1 1
    // 4    4               [1,4,9,16,25,36,49]
    // 5    4 1
    // 6    4 1 1 
    // 7    4 1 1 1 
    // 8    4 4
    // 9    9
    // 10   9 1
    // 11   9 1 1
    // 12   4 4 4   
    // 13   4 9     
    // 14   4 9 1   (5 9)
    // 15   4 9 1 1 (6 9)
    // 16   4 4 4 4
    // 17   9 4 4
    // 18   9 9
    // dp[i] =min(dp[i],i^2 +dp[i-i^2]);
    public static int numSquares(int n) {
        int[] dp=new int[n+1];
        dp[0]=0;
        for (int i=1;i<=n;i++) {
            dp[i]=Integer.MAX_VALUE; //dp[i]初始化
            for (int j=1;i>=j*j;++j){
                dp[i]=Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
}