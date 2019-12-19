import java.util.*;
public class GrayCode89{
    public static void main(String[] args) {
        GrayCode89 g=new GrayCode89();
        System.out.println(g.grayCode2(2));
    }

    //TLE, case n==10 6/12,所以我这种做法肯定是错的,后面n可能会很大,那样就直接溢出了
    public List<Integer> grayCode3(int n) {
        List<Integer> res=new ArrayList<>();
        res.add(0);
        int max=(1<<n)-1; //注意优先级
        boolean[] visit=new boolean[max+1];
        grayCode3(max,res,visit);
        return res;
    }

    public boolean grayCode3(int max,List<Integer> lis,boolean[] visit) {
        if (lis.size()>max) { // list.size()==max+1 eg. when max=3 the list.size()=4
            return true;
        }
        int last=lis.get(lis.size()-1);
        for (int i=1;i<=max;i++) {
            if (!visit[i] && Integer.bitCount(i^last)==1) {
                lis.add(i);
                visit[i]=true;
                if(grayCode3(max,lis,visit)){
                    return true;
                }
                lis.remove(lis.size()-1);
                visit[i]=false;
            }
        }
        return false;
    }

    //常规回溯
    public List<Integer> grayCode2(int n) {
        List<Integer> res=new ArrayList<>();
        boolean[] visit=new boolean[1<<n];
        res.add(0);
        visit[0]=true;
        grayCode2(n,res,visit,0);
        return res;
    }

    public boolean grayCode2(int n,List<Integer> lis,boolean[] visit,int last) {
        if (lis.size()>=(1<<n)) { // list.size()==max+1 eg. when max=3 the list.size()=4
            return true;
        }
        for (int i=0;i<n;i++) {
            //直接生成下一个
            int next=last^(1<<i); //这一步其实就是从后往前,依次改变last一位
            if (!visit[next]) {
                lis.add(next);
                visit[next]=true;
                if(grayCode2(n,lis,visit,next)){
                    return true;
                }
                lis.remove(lis.size()-1);
                visit[next]=false;
            }
        }
        return false;
    }

    //最优解,规律
    public List<Integer> grayCode(int n) {
        List<Integer> res=new ArrayList<>();
        for (int i=0;i<1<<n;i++) {
            res.add(i^(i>>1));
        }
        return res;
    }

}