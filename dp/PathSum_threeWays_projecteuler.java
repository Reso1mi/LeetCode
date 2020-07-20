import java.util.*;
import java.io.*;
//https://projecteuler.net/problem=82  answer:260324
public class PathSum_threeWays_projecteuler{
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\priva\\Desktop\\p082_matrix.txt"));
        int index = 0;
        int m = 80, n = 80;
        int[][] matrix = new int[m][n];
        while (index < 80) {
            String[] line = reader.readLine().split(",");
            for (int j = 0; j < 80; j++) {
                matrix[index][j] = Integer.valueOf(line[j]);
            }
            index++;
        }
        int INF = 0x3f3f3f3f;
        int[][] dp = new int[m][n];
        for (int j = 0; j < m; j++) {
            dp[j][0] = matrix[j][0];
        }
        for (int j = 1; j < m; j++) {
            //只考虑向左和向下
            for (int i = 0; i < m; i++) {
                if (i==0){ //第一行，只能从左边转移
                    dp[i][j] = matrix[i][j] + dp[i][j-1];
                }else{ //从左边或者上边转移
                    dp[i][j] = matrix[i][j] + Math.min(dp[i][j-1], dp[i-1][j]);
                }                
            }
            for (int i = m-1; i >= 0; i--) {
                //三目写的太长看着挺不舒服...
                //dp[i][j] = i==m-1?dp[i][j]:Math.min(dp[i][j], matrix[i][j]+dp[i+1][j]);
                if (i<m-1) { //从下面转移和从上面转移的最小值
                    dp[i][j] = Math.min(dp[i][j], matrix[i][j]+dp[i+1][j]);
                }
                //最后一行，只能从左边或者上面转移，也是就是第一个循环的值
                //dp[i][j] = dp[i][j]
            }
        }
        int res = INF;
        for (int i = 0; i < m; i++) {
            res = Math.min(res, dp[i][m-1]);
        }
        System.out.println(res);
    }
}