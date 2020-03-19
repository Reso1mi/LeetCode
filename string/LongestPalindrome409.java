public class LongestPalindrome409{
    public static void main(String[] args) {

    }

    public int longestPalindrome(String s) {
        if(s==null || s.length()<=0) return 0;
        int[] hash=new int[128];
        for(int i=0;i<s.length();i++){
            hash[s.charAt(i)]++;
        }
        int res=0;boolean flag=false;
        for(int i=hash.length-1;i>=0;i--){
            if(hash[i]!=0){
                if(hash[i]%2==0){
                    res+=hash[i];
                }else{
                    flag=true;
                    res+=(hash[i]-1);
                }
            }
        }
        return flag?res+1:res;
    }
}