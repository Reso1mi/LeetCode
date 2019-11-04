public class SubarraySum560{
    public static void main(String[] args) {

    }

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);//初始化头哨兵,避免下标转换
        int sum=0,res=0;
        for (int i=0;i<nums.length;i++) {
            sum+=nums[i];
            //-1 -1 1 | 0
            if (/*sum>=k && */map.containsKey(sum-k)) {
                res+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return res;
    }
}