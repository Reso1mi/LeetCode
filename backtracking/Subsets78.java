import java.util.*;
public class Subsets78{
    public static void main(String[] args) {
        Subsets78 s=new Subsets78();
        int[] nums={1,2,2};
        System.out.println(s.subsets(nums));
    }

    private List<List<Integer>> res=new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums==null || nums.length<=0) {
            return res;
        }
        subsets(nums,0,new ArrayList());
        return res;
    }

    public void subsets(int[] nums,int index,List<Integer> lis) {
        if (index<=nums.length) {
            res.add(new ArrayList(lis));
        }
        for (int i=index; i<nums.length;i++) {
            lis.add(nums[i]);
            subsets(nums,i+1,lis);
            lis.remove(lis.size()-1);
        }
    }

    //BFS的解法
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> queue=new ArrayList<>();
        if (nums==null || nums.length<=0) {
            return queue;
        }
        queue.add(new ArrayList());
        for (int i=0;i<nums.length;i++) {
            int next=queue.size();
            for (int j=0;j<next;j++) {
                List<Integer> temp=new ArrayList(queue.get(j));
                temp.add(nums[i]);
                queue.add(temp);
            }
        }
        return queue;
    }
}