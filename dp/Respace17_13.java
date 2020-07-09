import java.util.*;
public class Respace17_13{
    public static void main(String[] args) {

    }

    //922ms 接近tle的边缘
    public int respace2(String[] dictionary, String s) {
        HashSet<String> set = new HashSet<>();
        for (String word : dictionary ) {
            set.add(word);
        }
        int n = s.length();
        int[] dp = new int[n+1];
        for (int i = 1; i <=n ; i++) {
            dp[i] = dp[i-1] + 1;
            for (int j = i-1; j >=0 ; j--) {
                //substring拖慢了速度(改成stringbuilder也没快多少)
                //我们需要一个O(1)的转移
                if(set.contains(s.substring(j,i))){
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }
        return dp[n];
    }

    //Trie+dp 14ms,很强
    public int respace(String[] dictionary, String s) {
        Node root = new Node();
        for (String word : dictionary ) {
            root.insert(word);
        }
        int n = s.length();
        int[] dp = new int[n+1];
        for (int i = 1; i <=n ; i++) {
            dp[i] = dp[i-1] + 1;
            Node cur = root;
            for (int j = i-1; j >=0 ; j--) {
                int c = s.charAt(j)-'a';
                //很大的优化点
                if(cur.next[c] == null){
                    break;
                }
                if(cur.next[c].isWord){
                    dp[i] = Math.min(dp[i], dp[j]);
                }
                if(dp[i] == 0){
                    break;
                }
                cur = cur.next[c];
            }
        }
        return dp[n];
    }

    class Node{
        Node[] next = new Node[26];
        
        boolean isWord;

        public void insert(String s){
            Node cur = this;
            for (int i = s.length()-1; i >= 0; i--) {
                int c = s.charAt(i)-'a';
                if(cur.next[c] == null){
                    cur.next[c] = new Node();
                }
                cur = cur.next[c];
            }
            cur.isWord = true;
        }
    }
}