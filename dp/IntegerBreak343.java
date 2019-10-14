public class IntegerBreak343{
    public static void main(String[] args) {
        System.out.println(integerBreak4(10));
    }

    // F(n) = Max(i*F(n-i));
    // 10---》 1 3 6 
    // 暴力递归 TLE
    public static int integerBreak(int n) {
        //递归出口
        if (n==2) {
            return 1;
        }
        int res=-1;
        for (int j=1;j<n;j++) {
            res=Math.max(res, Math.max((n-j)*j,integerBreak(n-j)*j));
        }
        return res;
    }


    private  Integer[] cache=null;
    //只顶向下,记忆化递归
    public  int integerBreak(int n) {
        cache=new Integer[n+1];
        return breakInteger(n);
    }
    public  int breakInteger(int n) {
        if (cache[n]!=null) {
            return cache[n];
        }
        //递归出口
        if (n==2) {
            return 1;
        }
        int res=-1;
        for (int j=1;j<n;j++) {
            res=Math.max(res, Math.max((n-j)*j,breakInteger(n-j)*j));
        }
        cache[n]=res;
        return res;
    }

    //dp解法
    public static int integerBreak2(int n) {
        if (n==2) {
            return 1;
        }
        int [] dp=new int[n+1];
        dp[2]=1;
        for (int i=3;i<=n;i++) {
            for (int j=1;j<i;j++) {
                dp[i]=Math.max(dp[i],Math.max(dp[i-j]*j,(i-j)*j));
            }
        }
        return dp[n];
    }

    //找规律
    public static int integerBreak3(int n) {
        int[] base={1,2,4,6,9,12};
        if(n<=7){
            return base[n-2];
        }
        int[] dp=new int[n+1];
        dp[2]=base[0];
        dp[3]=base[1];
        dp[4]=base[2];
        dp[5]=base[3];
        dp[6]=base[4];
        dp[7]=base[5];
        for (int i=8;i<=n;i++) {
            dp[i]=dp[i-3]*3;
        }
        return dp[n];
    }

    //找规律
    public static int integerBreak4(int n) {
        int[] base={1,2,4};
        if(n<=4){
            return base[n-2];
        }
        int res=1;
        while(n>5){
            res*=3;
            n-=3;
        }
        res*=n;
        return res;
    }
}