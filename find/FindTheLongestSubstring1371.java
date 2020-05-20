public class FindTheLongestSubstring1371{
    public static void main(String[] args) {

    }

    public int findTheLongestSubstring(String s) {
        //a e i o u
        //32种状态
        int[] pre=new int[1<<5];
        Arrays.fill(pre,-1);
        pre[0]=0;
        int res=0;
        int state=0;
        for (int i=0;i<s.length();i++) {
            if(s.charAt(i)=='a') state^=16;
            if(s.charAt(i)=='e') state^=8;
            if(s.charAt(i)=='i') state^=4;
            if(s.charAt(i)=='o') state^=2;
            if(s.charAt(i)=='u') state^=1;
            if(pre[state]!=-1){
                res=Math.max(res,i+1-pre[state]);
            }else{
                pre[state]=i+1; //前i个字符的状态
            }
        }
        return res;
    }
}