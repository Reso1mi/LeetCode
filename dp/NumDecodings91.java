import java.util.*;
public class NumDecodings91{
    public static void main(String[] args) {

        System.out.println(numDecodings2("12120"));
    }
    
    //2 2 7          --  2
    //2 2 6          --  3
    //1 2 3 1 2      --  6
    //1 3 2 2 1 6 2  --  10
    //1 2 2 2 1 1 2  --  21
    //
    //规律找到了,斐波拉契数列
    public static int numDecodings(String s) {
        if (s.startsWith("0")) {
            return 0;
        }
        int[] s_nums=new int[s.length()];
        for (int i=0;i<s.length();i++) {
            s_nums[i]=Integer.valueOf(s.charAt(i)-48);
        }

        int[] dp =new int[s_nums.length];
        Arrays.fill(dp,1);
        dp[0]=1;
        int res=1;
        for (int j=1;j<s_nums.length;j++) {
            if(s_nums[j]==0 && s_nums[j-1]==0 || (s_nums[j]==0 && s_nums[j-1]>2)){
                return 0;
            }
            if( s_nums[j]==0 || s_nums[j-1]==0 || (j<s_nums.length-1 &&s_nums[j+1]==0)){
                res*=dp[j-1];
                continue;
            }
            if(s_nums[j-1]*10+s_nums[j]<=26){
                if(j==1){
                    dp[j]=2;
                }else{
                    dp[j]=dp[j-1]+dp[j-2];    
                }
            }else{
                res*=dp[j-1];
                dp[j-1]=1;
                dp[j]=1;
            }
        }
        res*=dp[s_nums.length-1];
        return res;
    }

    public static int numDecodings2(String s) {
        if (s.startsWith("0")) {
            return 0;
        }
        int[] s_nums=new int[s.length()];
        for (int i=0;i<s.length();i++) {
            s_nums[i]=Integer.valueOf(s.charAt(i)-48);
        }
        int[] dp=new int[s.length()+1];
        dp[0]=1;
        dp[1]=1;
        for (int i=2;i<=s.length();i++) {
            int a=s_nums[i-1];
            if(a!=0){
                //到这里dp[i]==0,没有初始化,默认就是0
                //其实等价于dp[i]=dp[i-1],延续前一个字符的状态
                dp[i]+=dp[i-1];
            }

            if(s_nums[i-2]==0){
                //如果前前一个字符为0那么就不用dp了,保持i-1的状态就OK
                continue;
            }

            //前前一个字符和
            int b=s_nums[i-2]*10+s_nums[i-1];
            if(b<=26){
                dp[i]+=dp[i-2]; //上下这两个dp必须执行一个否则最后就 return 0
            }
        }
        return dp[s_nums.length];
    }
}