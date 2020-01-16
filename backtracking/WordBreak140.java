public class WordBreak140{
    public static void main(String[] args) {
        
    }


    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict=new HashSet<>(wordDict);
        dfs(s,0,"",dict);
        return res;
    }

    private List<String> res=new ArrayList<>();

    public void dfs(String s,int index,String word,HashSet<String> dict){
        if (index==s.length()) {
            res.add(word.substring(0,word.length()-2));
            return;
        }
        for (int i=index+1;i<s.length();i++) {
            String str=s.substring(index,i);
            if (dict.contains(str)) {
                //word.append(str+" "); // app#pa# 
                dfs(s,i+1,word+str+" ",count+1,dict);
                //word.delete(word.length()-(i-),i);
            }
        }
    }

}