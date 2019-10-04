import java.util.*;
public class Partition131{
    public static void main(String[] args) {
        Partition131 p=new Partition131();
        System.out.println(p.partition("aab"));
    }

    public List<List<String>> partition(String s) {
        partition(s,0,new ArrayList());
        return res;
    }   

    List<List<String>> res=new ArrayList<>();

    public void partition(String s,int index,List<String> lis) {
        if (index==s.length()) {
            res.add(new ArrayList(lis));
            return;
        }
        for (int i=index+1;i<=s.length();i++) {
            String temp=s.substring(index,i);
            System.out.println(index+"="+i+"="+temp);
            if (isPalind(temp)) {
                lis.add(temp);
                partition(s,i,lis);
                //不能直接remove(temp),主要是会有重复的字符,所以会导致最后的顺序不一致,而且效率也很低
                //lis.remove(temp);
                lis.remove(lis.size()-1);
            }
        }
    }

    public boolean isPalind(String s){
        for (int i=0,j=s.length()-1;i<=j;i++,j--) {
            if (s.charAt(i)!=s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}