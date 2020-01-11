public class CountSubstrings647{

    public static void main(String[] args) {

    }

    public int countSubstrings(String s) {
        if (s==null || s.length()<=0) {
            return 0;
        }
        int n=s.length();
        //aaaba
        //dp[i][j] i~j 是不是回文
        boolean [][] dp=new boolean[n][n];
        int res=n; //下面的循环没有统计单个字符的情况
        for (int i=n-1;i>=0;i--) {
            for (int j=i+1;j<n;j++) { //统一写法
                if (s.charAt(i) == s.charAt(j) && (j-i<=2 || dp[i+1][j-1])) {
                    dp[i][j]=true;
                    res++;
                }
            }
        }
        return res;
    }

    //修改了一点点
    public int countSubstrings(String s) {
        if (s==null || s.length()<=0) {
            return 0;
        }
        int n=s.length();
        //aaaba
        //dp[i][j] i~j 是不是回文
        boolean [][] dp=new boolean[n][n];
        int res=0;
        for (int i=n-1;i>=0;i--) {
            for (int j=i;j<n;j++) { //这样也可以
                if (s.charAt(i) == s.charAt(j) && (j-i<=2 || dp[i+1][j-1])) {
                    dp[i][j]=true;
                    res++;
                }
            }
        }
        return res;
    }

    //中心扩展法
    public int countSubstrings(String s) {
        if (s==null || s.length()<=0) {
            return 0;
        }
        int n=s.length();
        int count=0;
        for (int i=0;i<n;i++) {
            count+=spread(s,i,i+1)+spread(s,i,i);
        }
        return count;
    }

    public int spread(String s,int i,int j){
        int res=0;
        while(i>=0 && j<s.length()){
            if (s.charAt(i)==s.charAt(j)) {
                i--;j++;
                res++;
            }else{
                return res;
            }
        }
        return res;
    }
}