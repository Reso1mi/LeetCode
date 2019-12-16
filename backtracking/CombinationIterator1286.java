public class CombinationIterator1286{
    
    private LinkedList<String> res=new LinkedList<>();

    //abc
    public CombinationIterator(String characters, int combinationLength) {
        dfs("",combinationLength,0,0,characters);
    }
    
    public String next() {
        return res.pollFirst();
    }

    public void dfs(String cur,int len,int index,int count,String source) {
        if (count == len) {
            res.add(cur);
            return;
        }
        for (int i=index;i<source.length();i++) {
            dfs(cur+source.charAt(i),len,i+1,count+1,source);
        }
    }
    
    public boolean hasNext() {
        return !res.isEmpty();
    }
}