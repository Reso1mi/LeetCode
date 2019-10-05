import java.util.*;
public class Permute46{
    public static void main(String[] args) {
        Permute46 per=new Permute46();
        int[] nums={1,2,3};
        System.out.println(222);
        System.out.println(per.permute(nums));
    }

    public List<List<Integer>> permute(int[] nums) {
        if (nums==null || nums.length<=0) {
            return res;
        }
        boolean[] visit=new boolean[nums.length];
        permute(nums,0,new ArrayList(),visit);
        return res;
    }

    private List<List<Integer>> res=new ArrayList<>();

    public void permute(int[] nums,int index,List<Integer> lis,boolean[] visit) {
        if (index==nums.length) {
            res.add(new ArrayList(lis));
            return;
        }
        for (int i=0;i<nums.length;i++) {
            if (visit[i]) continue;
            lis.add(nums[i]);
            visit[i]=true;
            permute(nums,index+1,lis,visit);
            //回溯
            visit[i]=false;
            lis.remove(lis.size()-1);
        }
    }
}