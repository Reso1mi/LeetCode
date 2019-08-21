public class NumberOfArithmeticSlices413{

    public static void main(String[] args) {

    }

    public int numberOfArithmeticSlices(int[] A) {
        if(A.length<3){
            return 0;
        }
        //dp[i]=dp[i-1]+1;
        int []dp=new int[A.length]; //以 A[i] 结尾的等差数列有多少个
        for (int i=2;i<A.length;i++) {
            if(A[i]-A[i-1]==A[i-1]-A[i-2]){
                dp[i]=dp[i-1]+1;
            }
        }
        int res=0;
        for (int i=0;i<dp.length;i++) {
            res+=dp[i];
        }
        return res;
    }

    public int numberOfArithmeticSlices2(int[] A) {
        if(A.length<3){
            return 0;
        }
        //dp[i]=dp[i-1]+1;
        int dp=0;
        int res=0;
        for (int i=2;i<A.length;i++) {
            if(A[i]-A[i-1]==A[i-1]-A[i-2]){
                dp=dp+1;
                res+=dp;
            }else{
                dp=0;
            }
        }
        return res;
    }

    //同上
    public int numberOfArithmeticSlices3(int[] A) {
        if(A.length<3){
            return 0;
        }
        int diff=A[1]-A[0];
        int res=0;
        int t_res=0;
        for (int i=2;i<A.length;i++) {
            int t_diff=A[i]-A[i-1];
            if(t_diff==diff){
               t_res++;
               res+=t_res;
           }else{
                diff=t_diff;
                t_res=0;
           }
       }
       return res;
   }
}