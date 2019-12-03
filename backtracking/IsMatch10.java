public class IsMatch10{
    public static void main(String[] args) {
        IsMatch10 i=new IsMatch10();
        System.out.println(i.isMatch("mississippi","mis*is*p*."));//false
        System.out.println(i.isMatch("aaa","aaaa**********************"));//true
        System.out.println(i.isMatch("aaa","aaaa****a**a*a***a**a**a**a**a**a**a**")); //true
        System.out.println(i.isMatch("aaa","aaaa*"));//true
        System.out.println(i.isMatch("aaasdjsaldsajfiosdfhsidfisdfifhsadfa",".*")); //ture
        System.out.println(i.isMatch("","c*c*")); //true

        System.out.println(i.isMatch("ab",".*c")); //false
        // ..*c* ab
        System.out.println(i.isMatch("a",".*..a*")); //false
        System.out.println(i.isMatch("a","..a*"));
    }

    /*
    
    "aab"
    "c*a*b"
    "mississippi"
    "mis*is*p*."
    "ab"
    ".*"
    "dhsadiadiuahfsdiofhsdiofwgehifhsdfhisujhuidfshf"
    ".*"
    
    432/447
    ""
    "c*c*"

    "ab"
    ".*c"
    
    443/447
    "a"
    ".*..a*" false

     */

    public boolean isMatch(String s, String p) {
        return match(s,0,p,0);
    }

    public boolean match(String s,int sIdx, String p,int pIdx) {
        if (sIdx>=s.length() && pIdx>=p.length()) {
            return true;
        }
        if (pIdx>=p.length()) {
            return false;
        }

        //这里的判断其实不太对,也不能说不对,会稍微慢一点,因为题目中是不会给**这样的case的
        //可以直接一次跳两步判断是不是*
        if (sIdx == s.length()) {
            //后面没有*的情况 aaa aaaa
            if (pIdx==p.length()-1 && p.charAt(pIdx)!='*') { //p也到尽头,并且不为*
                return false;
            }
            while(pIdx<p.length()){ //p没到尽头,检查后面的是否有两个连续的非*
                if (p.charAt(pIdx) != '*' && (pIdx+1<p.length() && p.charAt(pIdx+1)!='*')) {
                    return false;
                }
                pIdx++;
            }
            //aaa aaa*c
            return p.charAt(pIdx-1)=='*';
        }

        if (pIdx+1 < p.length() && p.charAt(pIdx+1) =='*') { //pIdx下一个是 *
            //*匹配至少一个
            if ((s.charAt(sIdx) == p.charAt(pIdx) || p.charAt(pIdx)=='.') && match(s,sIdx+1,p,pIdx)) {
                return true;
            }
            //*匹配0个
            return match(s,sIdx,p,pIdx+2);
        }else{
            //pIdx下一个不是*
            if ((p.charAt(pIdx) == s.charAt(sIdx) || p.charAt(pIdx)=='.') && match(s,sIdx+1,p,pIdx+1)) {
                return true;
            }
            return false;
        }
    }


}