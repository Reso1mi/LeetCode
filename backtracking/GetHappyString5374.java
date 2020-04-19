public class GetHappyString5374{
    public static void main(String[] args) {
        GetHappyString5374 g=new GetHappyString5374();
        System.out.println(g.getHappyString(3,9));
    }

    public String getHappyString(int n, int k) {
        dfs("a",n,k);
        dfs("b",n,k);
        dfs("c",n,k);
        return res;
    }

    private int count=0;

    private String res="";
    
    public void dfs(String cur,int n,int k){
        if(!"".equals(res)) return;
        if(cur.length()==n){
            count++;
            if(count==k){
                res=cur;
            }
            return;
        }
        char last=cur.charAt(cur.length()-1);
        if(last=='a'){
            dfs(cur+'b',n,k);
            dfs(cur+'c',n,k);
        }
        if(last=='b'){
            dfs(cur+'a',n,k);
            dfs(cur+'c',n,k);
        }
        if(last=='c'){
            dfs(cur+'a',n,k);
            dfs(cur+'b',n,k);
        }
    }
}