import java.util.*;
public class SubsetsWithDup90{
    public static void main(String[] args) {
        int[] nums={4,4,4,1,4};
        SubsetsWithDup90 s=new SubsetsWithDup90();
        System.out.println(s.subsetsWithDup(nums));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums==null || nums.length<=0) {
            return res;
        }
        Arrays.sort(nums);
        subsets(nums,0,new ArrayList());
        return res;
    }

    private  List<List<Integer>> res=new ArrayList<>();
    
    public void subsets(int[] nums,int index,List<Integer> lis) {
        res.add(new ArrayList(lis));
        for (int i=index;i<nums.length;i++) {
            if (i>index && nums[i] == nums[i-1]) {
                continue;
            }
            lis.add(nums[i]);
            subsets(nums,i+1,lis);
            lis.remove(lis.size()-1);
        }
    }

    //4 4 4 1 4
    //1 4 4 4 4
    public void subsets2(int[] nums,int index,List<Integer> lis) {
        HashSet<Integer> set=new HashSet<>();
        res.add(new ArrayList(lis));
        for (int i=index;i<nums.length;i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            lis.add(nums[i]);
            set.add(nums[i]);
            subsets2(nums,i+1,lis);
            lis.remove(lis.size()-1);
        }
    }
}