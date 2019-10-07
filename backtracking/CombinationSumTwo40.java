import java.util.*;
public class CombinationSumTwo40{
    public static void main(String[] args) {
        CombinationSum2_40 c= new CombinationSum2_40();
        int [] num2={10,1,2,7,6,1,5};
        int [] num={2,5,2,1,2};
        System.out.println(c.combinationSum2(num2,8));
    }

    private List<List<Integer>> res=new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates ==null || candidates.length<=0) {
            return res;
        }
        Arrays.sort(candidates);
        combinationSum2_2(candidates,target,0,new ArrayList());
        return res;
    }

    public void combinationSum2(int[] candidates, int target,int index,List<Integer> lis) {
        /*if (target<0) {
            return;
        }*/
        if (target==0) {
            res.add(new ArrayList(lis));
            return;
        }

        for (int i=index;i<candidates.length;i++) {
            //注意这里i>index
            if (i>index && candidates[i]==candidates[i-1]  ) continue;
            //排过序的,可以直接return
            if (target-candidates[i]<0) return;
            lis.add(candidates[i]);
            combinationSum2(candidates,target-candidates[i],i+1,lis);
            lis.remove(lis.size()-1);
        }
    }

    //不排序好像不太好做 参照全排列2哪一题的做法
    //明显是有问题的,那个只能保证在循环中没有重复的元素被选取
    //这一题即使循环中没有重复元素,也会导致结果重复(列表)
    public void combinationSum2_2(int[] candidates, int target,int index,List<Integer> lis) {
        HashSet<Integer> set=new HashSet<>();
        if (target<0) {
            return;
        }

        if (target==0) {
            res.add(new ArrayList(lis));
            return;
        }

        for (int i=index;i<candidates.length;i++) {
            if (set.contains(candidates[i])) {
                continue;
            }
            if (candidates[i]>target) continue;
            lis.add(candidates[i]);
            set.add(candidates[i]);
            combinationSum2_2(candidates,target-candidates[i],i+1,lis);
            lis.remove(lis.size()-1);
        }
    }
}
