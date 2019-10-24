public class GenerateParenthesis22{
    public static void main(String[] args) {

    }

    public List<String> generateParenthesis(int n) {
        //dfs(n,"",0,0);
        dfs(n,new StringBuilder(),0,0);
        return res;
    }

    private List<String> res=new LinkedList<>();
    
    public void dfs(int n,String sb,int left,int right) {
        if (left>n /*|| right>n*/ || right>left) {
            return;
        }
        if (left==n && right ==n) {
            res.add(sb.toString());   
            return;
        }
        dfs(n,sb+"(",left+1,right);
        dfs(n,sb+")",left,right+1);
    }

    public void dfs(int n,StringBuilder sb,int left,int right) {
        if (left>n /*|| right>n*/ || right>left) {
            return;
        }
        if (left==n && right ==n) {
            res.add(sb.toString());
            return;
        }
        dfs(n,sb.append("("),left+1,right);
        sb.delete(sb.length()-1,sb.length());
        dfs(n,sb.append(")"),left,right+1);
        sb.delete(sb.length()-1,sb.length());
    }
}