import java.util.*;
public class PermuteUnique47{
    public static void main(String[] args) {
        PermuteUnique47 p=new PermuteUnique47();
        int[] nums={1,1,2};
        System.out.println(p.permuteUnique(nums));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums==null || nums.length<=0) {
            return res;
        }
        //Arrays.sort(nums); 解法二需要先排序
        boolean[] visit=new boolean[nums.length];
        permuteUnique2(nums,new ArrayList(),visit);
        return res;
    }

    private List<List<Integer>> res=new ArrayList<>();

    public void permuteUnique(int[] nums,List<Integer> lis,boolean[] visit){
        HashSet<Integer> set=new HashSet<>();
        if (lis.size()==nums.length) {
            res.add(new ArrayList(lis));
            return;
        }
        for (int i=0;i<nums.length;i++) {
            if (!visit[i] && !set.contains(nums[i])) {
                lis.add(nums[i]);
                visit[i]=true;
                set.add(nums[i]);
                permuteUnique(nums,lis,visit);
                visit[i]=false;
                lis.remove(lis.size()-1);
            }
        }
    }

    public void permuteUnique2(int[] nums,List<Integer> lis,boolean[] visit){
        /*if (lis.size()==nums.length) {
            res.add(new ArrayList(lis));
            return;
        }*/
        res.add(new ArrayList(lis));
        for (int i=0;i<nums.length;i++) {
            //剪枝去重
            if (i>0&&nums[i]==nums[i-1] && visit[i-1]) 
                continue;
            if (!visit[i]) {
                lis.add(nums[i]);
                visit[i]=true;
                permuteUnique2(nums,lis,visit);
                visit[i]=false;
                lis.remove(lis.size()-1);
            }
        }
    }
}