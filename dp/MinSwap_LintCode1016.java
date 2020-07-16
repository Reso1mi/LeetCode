public class MinSwap_LintCode1016{
    public static void main(String[] args) {

    }

    public int minSwap(int[] A, int[] B) {
        if (A == null || B == null || A.length <=0 || B.length <= 0){
            return 0;
        }
        // Write your code here
        int n = A.length;
        int INF = 0x3f3f3f3f;
        //dp[i][0]: A和B前i个字符都保持有序，并且不交换第i个元素的最小交换次数
        //dp[i][1]: A和B前i个字符都保持有序，并且交换第i个元素的最小交换次数
        int[][] dp = new int[n][2];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], INF);
        }
        dp[0][0] = 0; dp[0][1] = 1;
        for(int i = 1; i < n; i++){
            //很巧妙的分类讨论
            if(A[i] > A[i-1] && B[i] > B[i-1]){
                //前后都不交换
                dp[i][0] = dp[i-1][0];
                //前后都交换
                dp[i][1] = dp[i-1][1]+1; 
            }
            if(A[i] > B[i-1] && B[i] > A[i-1]){
                //当前不交换，交换前面的
                dp[i][0] = Math.min(dp[i][0], dp[i-1][1]);
                //当前交换，前面不交换
                dp[i][1] = Math.min(dp[i][1], dp[i-1][0]+1);
            }
        }
        int res = Math.min(dp[n-1][0],dp[n-1][1]);
        return  res == INF ? 0 : res;
    }
}