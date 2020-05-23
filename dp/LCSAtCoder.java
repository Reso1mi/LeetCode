import java.util.*;
public class LCSAtCoder{
    //需要求出具体的字符串
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String A=sc.next();
            String B=sc.next();
            System.out.println(longestCommonSubsequence(A,B));
        }
    }

    public static String longestCommonSubsequence(String A, String B) {
        int lenA=A.length();
        int lenB=B.length();
        int[][] dp=new int[lenA+1][lenB+1];
        int[][] back=new int[lenA+1][lenB+1];
        for (int i=1;i<=lenA;i++) {
            for (int j=1;j<=lenB;j++) {
                if (A.charAt(i-1)==B.charAt(j-1)) {
                    dp[i][j]=dp[i-1][j-1]+1;
                    back[i][j]=1; //左上
                }else if(dp[i-1][j]>dp[i][j-1]){
                    dp[i][j]=dp[i-1][j];
                    back[i][j]=2; //上
                }else{
                    dp[i][j]=dp[i][j-1];
                    back[i][j]=0; //左
                }
            }
        }
        int i=lenA,j=lenB;
        StringBuilder res=new StringBuilder();
        while(i>0 && j>0){
            if (back[i][j]==1) {
                i--;j--;
                res.append(A.charAt(i));
            }else if(back[i][j]==2){
                i--;
            }else{
                j--;
            }
        }
        return res.reverse().toString();
    }

}

class Main{}