public class LexicalOrder386{
    public static void main(String[] args) {

    }

    List<Integer> res=new ArrayList<>();
    
    public List<Integer> lexicalOrder(int n) {
        for(int i=1;i<=9;i++){
            dfs(i,n);   
        }
        return res;
    }
    
    public void dfs(int cur,int n){
        if(cur>n) return;
        res.add(cur);
        for(int i=0;i<=9;i++){
            dfs(cur*10+i,n);   
        }
    }
}