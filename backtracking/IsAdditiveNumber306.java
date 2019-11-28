import java.util.*;
public class IsAdditiveNumber306{
    public static void main(String[] args) {
        IsAdditiveNumber306 is=new IsAdditiveNumber306();
        System.out.println(is.isAdditiveNumber("11235813213455890144"));
        //System.out.println(is.addTwoStr("11235813213455890144","11235813213455890144"));
    }

    //溢出
    public boolean isAdditiveNumberOutOfRange(String num) {
        LinkedList<Long> list=new LinkedList<>();
        list.add(-1L);
        list.add(-1L);
        return dfsOutOfRange(num,0,list);
    }

    public boolean dfsOutOfRange(String num,int index,List<Long> list) {
        //System.out.println(list);
        if (index==num.length() && list.size()>4) {
            return true;
        }
        for(int i=index+1;i<=num.length();i++){
            if (num.charAt(index)=='0') {
                break;
            }
            long sub=Long.valueOf(num.substring(index,i));
            long a=list.get(list.size()-1);
            long b=list.get(list.size()-2);
            list.add(sub);
            if ((a==-1||b==-1 || a+b==sub) && dfsOutOfRange(num,i,list)) {
                return true;
            }
            list.remove(list.size()-1);
        }
        return false;
    }


    public boolean isAdditiveNumber(String num) {
        LinkedList<String> list=new LinkedList<>();
        list.add("-1");
        list.add("-1");
        return dfs(num,0,list);
    }

    public boolean dfs(String num,int index,List<String> list) {
        //System.out.println(list);
        if (index==num.length() && list.size()>4) {
            return true;
        }
        for(int i=index+1;i<=num.length();i++){
            //0开头应该直接break,除非是单独的0....
            if (num.charAt(index)=='0' && i>index+1) { //"101" .....
                break;
            }
            //剪枝
            if (i-index>num.length()/2) {
                return false;
            }
            String sub=num.substring(index,i);
            String a=list.get(list.size()-1);
            String b=list.get(list.size()-2);
            list.add(sub);
            if (("-1".equals(a)||"-1".equals(b) || addTwoStr(a,b).equals(sub)) && dfs(num,i,list)) {
                return true;
            }
            list.remove(list.size()-1);
        }
        return false;
    }

    //大数相加
    private String addTwoStr(String a,String b){
        StringBuilder res=new StringBuilder();
        int aIdx=a.length()-1;
        int bIdx=b.length()-1;
        int temp=0; //进位
        while(aIdx>=0 || bIdx>=0) {
            int as=aIdx>=0?a.charAt(aIdx)-48:0;
            int bs=bIdx>=0?b.charAt(bIdx)-48:0;
            int sum=as+bs+temp;
            temp=(sum)/10;
            res.append(sum%10);
            aIdx--;bIdx--;
        }
        if (temp==1) {
            res.append(1);
        }
        return res.reverse().toString();
    }
}