public class BalancedString1234{
    public static void main(String[] args) {

    }

    public int balancedString(String s) {
        if (s=null|| s.length()<=0) {
            return 0;
        }
        int len=s.length();
        int balance=len/4;
        //映射字符
        int[] count=new int[128];
        //统计4个字符串出现的次数
        for (int i=0;i<len;i++) {
            count[s.charAt(i)]++;
        }
        int left=0,right=0,res=len;
        for(int i=0;i<len;i++){
            left=i;
            while(left<len){
                count[s.charAt(right)]--;
                if (count['Q']<=balance && count['W']<=balance && count['E'] <=balance && count['R']<=balance) {
                    ++right;
                    res=Math.min(res,right-left);
                }
                left++;
            }
        }
    }
}