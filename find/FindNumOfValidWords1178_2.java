import java.util.*;

public class FindNumOfValidWords1178_2 {
    public static void main(String[] args) {

    }

    class Node {
        Node[] next;
        int cnt;
        public Node() {
            next = new Node[26];
        }
    }

    Node root;

    public void add(Node node, String str, int index) {
        if (index == str.length()) {
            node.cnt++;
            return;
        }
        int c = str.charAt(index)-'a';
        if (node.next[c] == null) {
            node.next[c] = new Node();
        }
        add(node.next[c], str, index+1);
    }

    public int dfs(Node cur, char[] puzz, char req, int idx) {
        if (cur == null) return 0;
        if (idx == puzz.length) {
            return cur.cnt;
        }
        int res = 0;
        //选择当前元素
        res += dfs(cur.next[puzz[idx]-'a'], puzz, req, idx+1);
        //不选择当前元素（req必须选）
        if (puzz[idx] != req) {
            res += dfs(cur, puzz, req, idx+1);
        }
        return res;
    }

    //2^26
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        root = new Node();
        for (int i = 0; i < words.length; i++) {
            char[] word = words[i].toCharArray();
            Arrays.sort(word);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < word.length; j++) {
                if (j==0 || word[j]!=word[j-1]) {
                    sb.append(word[j]);
                }
            }
            add(root, sb.toString(), 0);
        }
        //dfs分解puzz子集
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < puzzles.length; i++) {
            char[] puzz = puzzles[i].toCharArray();
            Arrays.sort(puzz);
            res.add(dfs(root, puzz, puzzles[i].charAt(0), 0));
        }
        return res;
    }
}