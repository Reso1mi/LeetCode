public class GcdOfStrings1071{
    public static void main(String[] args) {

    }

    //输入：str1 = "ABCABC", str2 = "ABC"
    //输出："ABC"
    //输入：str1 = "ABABAB", str2 = "ABAB"
    //输出："AB"
    //6 4 gcd(6,4)=gcd(4,2)=gcd(2,0) return 2
    public String gcdOfStrings(String str1, String str2) {
        if(str1.equals(str2)){
            return str1;
        }
        int index1=0,index2=0;
        //用减法替代除法求余数
        while(str1.length()>=str2.length() && index1<str1.length() && index2<str2.length()){
            if(str1.charAt(index1)!=str2.charAt(index2)) return "";
            index2++;
            index1++;
        }
        //gcd(str2,余数)
        return gcdOfStrings(str2,str1.substring(index1,str1.length()));
    }
}