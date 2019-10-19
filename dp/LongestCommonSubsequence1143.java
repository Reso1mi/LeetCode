public class LongestCommonSubsequence1143{
    public static void main(String[] args) {

    }

    Integer[][] cache=null;

    public int longestCommonSubsequence(String text1, String text2) {
        if(text2==null || text1==null || text1.length()<=0 ||text2.length()<=0){
            return 0;
        }
        int len1=text1.length();
        int len2=text2.length();
        cache=new Integer[len1][len2];
        return lcs(text1,len1-1,text2,len2-1);
    }

    //lcs定义: 求text1[0,a]和text2[0,b]的最长公共子序列
    public int lcs(String text1, int a,String text2,int b) {
        if(a==-1 || b==-1){
            return 0;
        }
        if (cache[a][b]!=null) {
            return cache[a][b];
        }
        if (text1.charAt(a)==text2.charAt(b)) {
            cache[a][b]=lcs(text1,a-1,text2,b-1)+1;
            return cache[a][b];
        }else{
            cache[a][b]=Math.max(lcs(text1,a-1,text2,b),lcs(text1,a,text2,b-1));
            return cache[a][b];
        }
    }





    //动态规划
    public int longestCommonSubsequence2(String text1, String text2) {
        if(text2==null || text1==null || text1.length()<=0 ||text2.length()<=0){
            return 0;
        }
        int[][] dp=new int[text1.length()+1][text2.length()+1];
        for(int i=1;i<=text1.length();i++){
            for(int j=1;j<=text2.length();j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }


/*  从0开始不太好处理base 。。。。。
    public int longestCommonSubsequence(String text1, String text2) {
        if(text2==null || text1==null || text1.length()<=0 ||text2.length()<=0){
            return 0;
        }
        int[][] dp=new int[text1.length()][text2.length()];
        for(int i=0;i<text1.length();i++){
            for(int j=0;j<text2.length();j++){
                if (i==0) {
                    dp[i][j]=j>0&&dp[i][j-1]==1&&text1.charAt(0)==text2.charAt(j)?1:1;
                }else if (j==0) {
                    dp[i][j]=text1.charAt(i)==text2.charAt(0)?1:0;
                }else if(text1.charAt(i)==text2.charAt(j)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()-1][text2.length()-1];
    }*/
}