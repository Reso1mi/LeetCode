import java.util.*;
public class Combine77{
    public static void main(String[] args) {
        Combine77 c= new Combine77();
        System.out.println(c.combine(4,2));
    }

    public List<List<Integer>> combine(int n, int k) {
        if (k>n || n<=0 ||k<=0) {
            return res;
        }
        //boolean[] visit=new boolean[n+1];
        combine(n,k,1,new ArrayList(),0);
        return res;
    }   

    private List<List<Integer>> res=new ArrayList<>();


    //剪枝优化
    public void combine(int n, int k,int index,List<Integer> lis,int count) {
        if (count==k) {
            res.add(new ArrayList(lis));
            return;
        }
        //1 2 3 4 | 3
        //index = 3 k=3  n=4 count=0 (3为头,显然是不行的,肯定会和前面重复) --> 3<=3
        //index = 3 k=3  n=4 count=1 (3为第二个,是可行的) --> 3 <= 2
        if (n-index+2<=k-count) {
            return;
        }
        for (int i=index;i<=n;i++) {
            lis.add(i);
            combine(n,k,i+1,lis,count+1);
            //回溯的关键
            lis.remove(lis.size()-1);
        }
    }


    public void combine4(int n, int k,int index,List<Integer> lis,int count) {
        if (count==k) {
            res.add(new ArrayList(lis));
            return;
        }
        //循环的区间至少要有k-count个元素 也就是[i,N]之间至少要有k-count个元素
        //N-i+1>=k-count ---> i<=n-(k-count)+1
        for (int i=index;i<=n-(k-count)+1;i++) {
            lis.add(i);
            combine4(n,k,i+1,lis,count+1);
            //回溯的关键
            lis.remove(lis.size()-1);
        }
    }

    //这里其次count其实也不需要,直接用lis的size就行了
    public void combine2(int n, int k,int index,List<Integer> lis,int count) {
        if (count==k) {
            res.add(new ArrayList(lis));
            return;
        }
        for (int i=index;i<=n;i++) {
            lis.add(i);
            combine2(n,k,i+1,lis,count+1);
            //回溯的关键
            lis.remove(lis.size()-1);
        }
    }

    //冗余代码
    public void combine3(int n, int k,int index,List<Integer> lis,boolean[] visit,int count) {
        if (count==k) {
            res.add(new ArrayList(lis));
            return;
        }
        for (int i=index;i<=n;i++) {
            if (!visit[i]) {
                lis.add(i);
                visit[i]=true;
                combine3(n,k,i+1,lis,visit,count+1);
                lis.remove(lis.size()-1);    
                visit[i]=false;
            }
        }
    }
}