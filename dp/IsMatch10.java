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

    //回溯的做法,略复杂
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


    //动态规划 ----------- 以后再写吧。。。。这题现在写了过两天也忘了。。。。
    //还是上面的递归好理解
    public boolean isMatch(String s, String p) {
        //dp[i][j] 代表s的前i个字符和p的前j个字符是否匹配
        boolean[][] dp=new boolean[s.length()+1][s.length()+1];
        //dp[0][0]=true;
        //dp[i][0]=false
        //dp[0][j]=dp[0][j-1] && p[j]="*"
        dp[0][0]=true;
        for (int j=2;j<=p.length();j++) {
            if (p.charAt(j-1)=='*') {
                dp[0][j]=dp[0][j-2];   
            }
        }
        for (int i=1;i<s.length();i++) {
            for (int j=1;j<p.length();j++) {
                if (p.charAt(i-1) == s.charAt(j-1) || p.charAt(j)=='.') {
                    dp[i][j]=dp[i-1][j-1];
                }else if (p.charAt(j-1)=='*' && p.charAt(j-2)==s.charAt() ) { //ab .* | ab ab*
                    dp[i][j]=dp[i][j-1] | dp[i-1][j];
                }
            }
        }
    }

    //他来了他来了，他带着dp解法来了
    //update: 2020.4.12
    public boolean isMatch(String text, String pattern) {
        //dp[i][j]代表 text[0,i)和pattern[0,j)是否匹配
        boolean[][] dp=new boolean[text.length()+1][pattern.length()+1];
        //都为空的时候肯定是匹配的
        dp[0][0]=true;
        //pattern为空，text不为空肯定是无法匹配,默认false,不用处理
        //text为空,pattern不为空需要额外判断
        for(int i=2;i<=pattern.length();i++){
            dp[0][i]=pattern.charAt(i-1)=='*'&&dp[0][i-2];
        }

        for(int i=1;i<=text.length();i++){
            for(int j=1;j<=pattern.length();j++){
                if(singleMatch(text,pattern,i-1,j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else if(pattern.charAt(j-1)=='*'){
                    //j一定是>=2的,p如果是*开头就是错误的语法,不过lc其实也没有这样的case
                    if(j<2) return false;
                    //ab abb*    --> '*'匹配0个b
                    //abbbbb ab* --> '*'匹配多个b
                    //注意dp[i-1][j]和text.charAt(i-1)的i-1含义是不一样的
                    //text.charAt(i-1)的i-1其实指的是当前元素,而dp[i-1][j]中的i-1是前一个元素
                    //abc ab*
                    dp[i][j]=dp[i][j-2] || (singleMatch(text,pattern,i-1,j-2) && dp[i-1][j]);
                }
            }
        }
        return dp[text.length()][pattern.length()];
    }

    public boolean singleMatch(String s,String p,int i,int j){
        return s.charAt(i)==p.charAt(j) || p.charAt(j)=='.';
    }
}