import java.util.*;
public class WordBreak139{
    public static void main(String[] args) {
        WordBreak139 w=new WordBreak139();
        System.out.println(w.wordBreak("leetcode",Arrays.asList("leet","code")));
    }


    //记忆化递归
    Boolean[] cache=null;

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s==null || s.length()<=0) {
            return false;
        }
        cache=new Boolean[s.length()];
        HashSet<String> set=new HashSet<>(wordDict);
        return dfs(s,set,0);
    }

    //判断【index,s.len】中的字符是否能拆分
    public boolean dfs(String s, HashSet<String> dict,int index) {
        //这里的终止条件还是有点迷惑的,这里index只有在字典中存在当前元素的时候才会向后移动
        //所以当index移动到s==length的是偶就说明前面的单词都匹配上了
        if (index==s.length()) {
            return true;
        }
        if (cache[index]!=null) {
            return cache[index];
        }
        for (int i=index+1;i<=s.length();i++) {
            //System.out.println(s.substring(index,i));
            if (dict.contains(s.substring(index,i)) && dfs(s,dict,i)){

                return cache[index]=true;
            }
        }
        return cache[index]=false;
    }

    //BFS,需要一个visit保证不会重复访问
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s==null || s.length()<=0) {
            return false;
        }
        HashSet<String> dict=new HashSet<>(wordDict);
        //queue中存index
        LinkedList<Integer> queue=new LinkedList<>();
        boolean[] visit=new boolean[s.length()];
        queue.add(0);
        while(!queue.isEmpty()){
            int index=queue.poll();
            if (!visit[index]) {
                for (int i=index+1;i<=s.length();i++) {
                    if(dict.contains(s.substring(index,i))){
                        if (i==s.length()) {
                            return true;
                        }
                        queue.add(i);
                    }
                }
                visit[index]=true;
            }
        }
        return false;
    }
}