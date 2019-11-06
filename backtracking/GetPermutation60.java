import java.util.*;
public class GetPermutation60{
    public static void main(String[] args) {
        GetPermutation60 g=new GetPermutation60();
        System.out.println(g.getPermutation(3,3));
    }

    public String getPermutation(int n, int k) {
        boolean[] visit=new boolean[n+1];
        getPermutation(n,k,0,visit,new StringBuilder(""));
        return res.get(k-1).toString();
    }

    private List<StringBuilder> res=new LinkedList<>();

    public void getPermutation(int n, int k,int count,boolean[] visit,StringBuilder str) {
        if (count == n) {
            res.add(new StringBuilder(str));
            return;
        }
        if (res.size()==k) {
            return;
        }
        for (int i=1;i<=n;i++) {
            if (!visit[i]) {
                str.append(i);
                visit[i]=true;
                getPermutation(n,k,count+1,visit,str);
                visit[i]=false;
                str.delete(str.length()-1,str.length());
            }
        }
    }
}