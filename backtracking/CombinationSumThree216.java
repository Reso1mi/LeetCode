public class CombinationSumThree216{
    public static void main(String[] args) {

    }

    private List<List<Integer>> res=new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        combinationSum3_2(k,n,1,0,new ArrayList());
        return res;
    }

    //n=9 1 2 6, 1 3 5, 2 3 4
    public void combinationSum3(int k, int n,int index,int count,List<Integer> lis) {
        if (count==k && n==0) {
            res.add(new ArrayList(lis));
            return;
        }
        for (int i=index;i<=9;i++) {
            lis.add(i);
            combinationSum3(k,n-i,i+1,count+1,lis);
            lis.remove(lis.size()-1);
        }
    }

    //剪枝1
    public void combinationSum3_2(int k, int n,int index,int count,List<Integer> lis) {
        if (count==k && n==0) {
            res.add(new ArrayList(lis));
            return;
        }
        for (int i=index;i<=9;i++) {
            //有序的,可以直接return
            if (n-i<0) return;
            lis.add(i);
            combinationSum3_2(k,n-i,i+1,count+1,lis);
            lis.remove(lis.size()-1);
        }
    }
}