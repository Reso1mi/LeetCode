public class MinDistance72{
    public static void main(String[] args) {

    }

    Integer[][] cache=null;

    public int minDistance(String word1, String word2) {
        cache=new Integer[word1.length()][word2.length()];
        return minDistance(word1,word1.length()-1,word2,word2.length()-1);
    }

    //递归的定义: word1[0,idx1] 和 word2[0,idx2] 的最短编辑距离
    public int minDistance(String word1,int idx1,String word2,int idx2) {
        if (idx1<0) {
            return idx2+1;
        }
        if (idx2<0) {
            return idx1+1;
        }
        if (cache[idx1][idx2]!=null) {
            return cache[idx1][idx2];
        }
        if (word1.charAt(idx1) == word2.charAt(idx2)) {
            return cache[idx1][idx2]=minDistance(word1,idx1-1,word2,idx2-1);
        }else{
            return cache[idx1][idx2]=1+Math.min(minDistance(word1,idx1-1,word2,idx2),Math.min(minDistance(word1,idx1,word2,idx2-1),minDistance(word1,idx1-1,word2,idx2-1)));
        }
    }

    public int minDistance2(String word1, String word2) {
        if (word1.length()<=0 || word2.length()<=0) {
            return word2.length()==0?word1.length():word2.length();
        }
        int[][] dp=new int[word1.length()+1][word2.length()+1];
        for (int i=1;i<=word2.length();i++) {
            dp[0][i]=i;
        }
        for (int i=1;i<=word1.length();i++) {
            dp[i][0]=i;
        }
        for (int i=1; i<=word1.length();i++) {
            for (int j=1;j<=word2.length();j++) {
                if (word1.charAt(i-1)==word2.charAt(j-1)) {
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=1+Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}