import java.util.*;
public class WordBreak140{
    public static void main(String[] args) {

    }


    //暴力回溯TLE
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict=new HashSet<>(wordDict);
        dfs(s,0,"",dict);
        return res;
    }

    private List<String> res=new ArrayList<>();

    public void dfs(String s,int index,String word,HashSet<String> dict){
        if (index==s.length()) {
            res.add(word.substring(0,word.length()-1));
            return;
        }
        for (int i=index+1;i<=s.length();i++) {
            String str=s.substring(index,i);
            if (dict.contains(str)) {
                //word.append(str+" "); // app#pa# 
                dfs(s,i,word+str+" ",dict);
                //word.delete(word.length()-(i-),i);
            }
        }
    }

    //做记忆化
    HashMap<String,List<String>> cache=new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict=new HashSet<>(wordDict);
        return dfs(s,dict);
    }

    public List<String> dfs(String s,HashSet<String> dict){
        if (cache.containsKey(s)) {
            return cache.get(s);
        }
        List<String> res=new ArrayList<>();
        if (s.length()==0) {
            return res;
        }
        for (int i=0;i<=s.length();i++) {
            String word=s.substring(0,i);
            if (dict.contains(word)) {
               if (i==s.length()) {
                   res.add(word);
               }else{
                   List<String> temp=dfs(s.substring(i,s.length()),dict);
                   for (String tmp:temp) {
                       res.add(word+" "+tmp);
                   }
               }
           }
       }
       cache.put(s,res);
       return res;
   }
}
