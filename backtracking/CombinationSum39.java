import java.util.*;
public class CombinationSum39{
    public static void main(String[] args) {
        CombinationSum39 c= new CombinationSum39();
        int[] num={2,3,6,7};
        System.out.println(c.combinationSum(num,7));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates==null || candidates.length<=0) {
            return res;
        }
        //排序,进行大幅度剪枝
        Arrays.sort(candidates);
        combinationSum(candidates,target,0,0,new ArrayList());
        return res;
    }

    private List<List<Integer>> res=new ArrayList<>();


    //剪枝优化2
    public void combinationSum(int[] candidates, int target,int index,int sum,List<Integer> lis) {
        if (sum>target) {
            return;
        }
        if (target==sum) {
            res.add(new ArrayList(lis));
            return;
        }
        //其实主要就是搞清楚每次从哪里开始,以及每次循环的作用
        //这里一次循环其实就确定了包含i的所有可能解
        //所以后面的循环就不能再使用这个i了,所以我们这里传递一个变量index来控制遍历的起点
        for (int i=index;i<candidates.length;i++) {
            if (sum+candidates[i]>target) return;
            sum+=candidates[i];
            lis.add(candidates[i]);
            //注意这里传递进去的index是i
            combinationSum(candidates,target,i,sum,lis);
            sum-=candidates[i];
            lis.remove(lis.size()-1);
        }
    }

    //剪枝优化
    public void combinationSum3(int[] candidates, int target,int index,int sum,List<Integer> lis) {
        if (sum>target) {
            return;
        }
        if (target==sum) {
            res.add(new ArrayList(lis));
            return;
        }
        for (int i=index;i<candidates.length;i++) {
            //小小的剪枝
            if (candidates[i]>target) continue;
            sum+=candidates[i];
            lis.add(candidates[i]);
            combinationSum3(candidates,target,i,sum,lis);
            sum-=candidates[i];
            lis.remove(lis.size()-1);
        }
    }

    //未剪枝
    public void combinationSum2(int[] candidates, int target,int index,int sum,List<Integer> lis) {
        if (target<sum) {
            return;
        }
        if (target==sum) {
            res.add(new ArrayList(lis));
            return;
        }
        for (int i=index;i<candidates.length;i++) {
            sum+=candidates[i];
            lis.add(candidates[i]);
            combinationSum2(candidates,target,i,sum,lis);
            sum-=candidates[i];
            lis.remove(lis.size()-1);
        }
    }
}