import java.util.*;
public class SplitIntoFibonacci842{
    public static void main(String[] args) {
        SplitIntoFibonacci842 s = new SplitIntoFibonacci842();
        System.out.println(s.splitIntoFibonacci("123456579"));
    }

    public List<Integer> splitIntoFibonacci(String S) {
        LinkedList<Integer> res=new LinkedList<>();
        dfs(S,0,res);
        return res;
    }

    public boolean dfs(String S,int index,List<Integer> lis){
        if (index == S.length()) {
            return lis.size()>2;
        }
        for (int i=index+1;i<=S.length();i++) {
            String temp=S.substring(index,i);
            //长度大于10,或者Long解析出来大于INT_MAX了就直接break
            if (S.charAt(index) == '0' && i>index+1 || temp.length()>10 || Long.valueOf(temp)>Integer.MAX_VALUE) {
                break;
            }
            int str=Integer.valueOf(temp);
            int one=lis.size()>=2 ? lis.get(lis.size()-1):-1;
            int two=lis.size()>=2 ? lis.get(lis.size()-2):-1;
            lis.add(str);
            if ((one==-1 || two==-1 || one+two==str) && dfs(S,i,lis)) {
                return true;
            }
            lis.remove(lis.size()-1);
        }
        return false;
    }

/*    public String addBigNum(String a,String b){
        StringBuilder sb=new StringBuilder();
        int aIdx=a.length()-1;
        int bIdx=b.length()-1;
        int carry=0;
        while(aIdx >=0 && bIdx>=0){
            int sum=(aIdx>=0?a.charAt(aIdx)-48:0)+(bIdx>=0?b.charAt(bIdx)-48:0)+carry;
            carry=sum/10;
            sb.append(sum%10);
            aIdx--;bIdx--;
        }
        if (carry==1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }*/
}