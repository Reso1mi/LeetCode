public class LongestPalindrome5{
    public static void main(String[] args) {

    }

    public String longestPalindrome(String s) {
        if (s==null || s.length()<=0) {
            return "";
        }
        String res=s.charAt(0)+"";//只有1个字符
        for (int i=1;i<s.length();i++) {
            String even=palindrome(s,i-1,i); //偶数长度回文,从两个字符中间开始扩散
            String odd=palindrome(s,i,i); //奇数长度回文,从某一个字符开始扩散
            String temp=odd.length()>even.length()?odd:even;
            if (temp.length()>res.length()) {
                res=temp;
            }
        }
        return res;
    }

    public String palindrome(String s,int i,int j){
        while(i>=0 && j<=s.length()-1 && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        return s.substring(i+1,j);
    }
}