public class TranslateNumJZ_46{
    public static void main(String[] args) {
        
    }

    public int translateNum(int num) {
        String s=String.valueOf(num);
        int len=s.length();
        if(len==0 || len==1) return 1;
        int[] dp=new int[len];
        //1 2 2 5 8
        //1 2 3 5 5
        dp[0]=1;
        dp[1]=Integer.valueOf(s.substring(0,2))>25?1:2;
        for(int i=2;i<len;i++){
            int pre=Integer.valueOf(s.charAt(i-1))-48;
            int cur=Integer.valueOf(s.charAt(i))-48;
            if(pre!=0 && Integer.valueOf(pre*10+cur)<=25){
                dp[i]=dp[i-1]+dp[i-2];
            }else{
                dp[i]=dp[i-1];
            }
        }
        return dp[len-1];
    }
}