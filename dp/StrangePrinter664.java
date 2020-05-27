public class StrangePrinter664{
    public static void main(String[] args) {

    }

    public int strangePrinter(String s) {
        if(s==null || s.length()<=0) return 0;
        int N=s.length();
        int[][] dp=new int[N][N];
        for (int i=0;i<N;i++) {
            dp[i][i]=1;
        }
        //aa        1
        //aab       2
        //aaba      2
        //aabab     3
        //aababa    3
        for (int len=2;len<=N;len++) {
            for (int left=0;left+len-1<N;left++) { //左端点
                int right=left+len-1; //右端点
                //和前一个区间[left,right-1]的第一个字符相等,可以直接顺带打印出来
                if(s.charAt(right)==s.charAt(left)){ 
                    //至少是dp[left][right-1]
                    dp[left][right]=dp[left][right-1];
                    continue;
                }
                //最多是前一个区间+1(直接打印right位置的字符)
                dp[left][right]=dp[left][right-1]+1; 
                //枚举[left,right)中的所有字符,如果有和right相等的就考虑从这个位置分割整个字符
                //比如 abc b 这个最后的b就可以连同前面的bc一起顺带打印出来
                //所以当前区间的值就是可以是dp[a][a]+dp[b][c],我们从所有的这种情况中取最小值就ok了
                for (int i=left;i<right;i++) { 
                    if(s.charAt(right)==s.charAt(i)){
                        dp[left][right]=Math.min(dp[left][i-1]+dp[i][right-1],dp[left][right]);
                    }
                }
            }
        }
        return dp[0][N-1];
    }

    //优化代码逻辑
    public int strangePrinter(String s) {
        if(s==null || s.length()<=0) return 0;
        int N=s.length();
        //ababa: 4
        int[][] dp=new int[N+1][N+1];
        for (int i=1;i<=N;i++) {
            dp[i][i]=1;
        }
        for (int len=2;len<=N;len++) {
            for (int left=1;left+len-1<=N;left++) { //左端点
                int right=left+len-1; //右端点
                dp[left][right]=dp[left][right-1]+1; //至少是前一个区间+1(直接打印right字符)
                for (int i=left;i<right;i++) { //枚举[left,right)
                    if(s.charAt(right-1)==s.charAt(i-1)){
                        dp[left][right]=Math.min(dp[left][i-1]+dp[i][right-1],dp[left][right]);
                    }
                }
            }
        }
        return dp[1][N];
    }

    //其实还可以再优化的，不过我觉得没必要了，已经很清晰了

}