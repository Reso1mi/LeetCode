public class FindLength718{
    public static void main(String[] args) {

    }

    //简单的DP，一开始写着写着写成了lcs
    public int findLength(int[] A, int[] B) {
        int lenA=A.length;
        int lenB=B.length;
        int[][] dp=new int[lenA+1][lenB+1];
        int res=0;
        for(int i=1;i<=lenA;i++){
            for(int j=1;j<=lenB;j++){
                if(A[i-1]==B[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                    res=Math.max(dp[i][j],res);
                }
            }
        }
        return res;
    }
}