import java.util.*;
public class MaxCoins312{
    public static void main(String[] args) {
        MaxCoins312 m=new MaxCoins312();
        int res=m.maxCoins(new int[]{3,1,5,8});
        System.out.println(res);
    }

    //暴力回溯
    public int maxCoins(int[] nums) {
        LinkedList<Integer> list=new LinkedList<>();
        for (int n:nums) list.add(n);
        dfs(list,0);
        return max;
    }

    private int max=0;

    public void dfs(LinkedList<Integer> list,int sum) {
        if (list.size()==0) {
            max=Math.max(sum,max);
            return;
        }
        for (int i=0;i<list.size();i++) {
            int temp=list.get(i);
            //这个值要先算
            int cur=(i-1<0?1:list.get(i-1))*(i+1>=list.size()?1:list.get(i+1))*temp;
            list.remove(i);
            dfs(list,sum+cur);
            list.add(i,temp);
        }
    }
}