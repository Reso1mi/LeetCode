public class MinAddToMakeValid921{
    public static void main(String[] args) {

    }

    public int minAddToMakeValid(String S) {
        int left=0,right=0;
        int wa=0;
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='('){
                left++;
            }else{
                if(left>0){
                    left--;
                }else{
                    wa++;
                }
            }
        }
        return wa+left;
    }
}