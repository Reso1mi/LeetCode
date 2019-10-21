public class CoinChange518{

    public static void main(String[] args) {

    }

    public int change(int amount, int[] coins) {
        if (coins==null || coins.length<=0) {
            return amount==0?1:0;
        }
        int[][] dp=new int[coins.length][amount+1];
        for (int i=0;i<coins.length;i++) {
            for (int j=0;j<=amount;j++) {
                if (i==0) {
                    dp[0][j]=j%coins[i]==0?1:0;
                }else if (j==0) {
                    dp[i][0]=1;
                }else{
                      dp[i][j]= j>=coins[i]?dp[i-1][j]+dp[i][j-coins[i]]:dp[i-1][j];
                    //dp[i][j]= j>=coins[i]?dp[i-1][j]+dp[i-1][j-coins[i]]:dp[i-1][j];
                }
            }
        }
        return dp[coins.length-1][amount];
    }

    //直接理解一维dp还是不太容易,但是知道递推公式后先写个二维dp再改为一维就很容易
    public int change(int amount, int[] coins) {
        int[] dp=new int[amount+1];
        dp[0]=1;
        //这种方式相当于对dpTable从左向右,一行行的递推
        for (int i=0;i<coins.length;i++) {
            for (int j=0;j<=amount;j++) {
                //写个+=给我自己看懵了
                //dp[j]+= dp[j-coins[i]]:0;
                dp[j]=j-coins[i]>=0?dp[j]+dp[j-coins[i]]:dp[j];
            }
        }

        /* 交换一下内外顺序就变成了另一个问题的解,这种方式相当于从上往下
           先固定了target,内循环就相当于
        for (int j=0;j<=amount;j++) {
            for (int i=0;i<coins.length;i++) {
                dp[j]+= j-coins[i]>=0?dp[j-coins[i]]:0;
            }
        }*/
        return dp[amount];
    }

    public int change(int amount, int[] coins) {

    }
}