import java.util.*;
public class UniquePaths62{

    //
    public static void main(String[] args) {
        System.out.println(uniquePaths3(7,3));
    }

    //dp[i,j]=dp[i,j-1]+dp[i-1,j]
    public static int uniquePaths(int m, int n) {
        if(m<0||n<0){
            return 0;
        }
        int[][] dp=new int[n][m];
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if(i==0&&j!=0){
                    dp[i][j]=1;
                }else if(j==0 && i!=0){
                    dp[i][j]=1;
                }else if(j!=0&&i!=0){
                    dp[i][j]=dp[i][j-1]+dp[i-1][j];
                }else{
                    dp[i][j]=1;
                }
            }
        }
        return dp[n-1][m-1];
    }

    public static int uniquePaths2(int m, int n) {
        if(m<0||n<0){
            return 0;
        }
        int[] dp=new int[n]; 
        Arrays.fill(dp,1); //第一行，第一列均为 1
        for (int i=1;i<m;i++) { //一行一行向下走
            for (int j=1;j<n;j++) {
                dp[j]=dp[j]+dp[j-1]; //求每一行每个元素的dp值
            }
        }
        return dp[n-1]; //最后一行最后一个dp值就是结果
    }

    public static int uniquePaths3(int m, int n) {
        if(m<0||n<0){
            return 0;
        }
        int step=m+n-2;
        int down=n-1;
        long res=1;
        for (int i=1;i<=down;i++) {
            res=res*(step-down+i)/i; //递推
        }
        return (int)res;
    }
}