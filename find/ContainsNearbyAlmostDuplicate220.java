import java.util.*;
public class ContainsNearbyAlmostDuplicate220{
    public static void main(String[] args) {

    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set=new TreeSet<>();
        for (int i=0;i<nums.length;i++) {
            //大于nums[i]的最小元素
            Integer ceiling=set.ceiling(nums[i]);
            //小于nums[i]的最大元素
            Integer floor=set.floor(nums[i]);
            //防止溢出
            long temp1=Long.valueOf(nums[i])+Long.valueOf(t);
            long temp2=Long.valueOf(nums[i])-Long.valueOf(t);
            if((ceiling!=null && ceiling<=temp1) || (floor!=null && floor>=temp2)) {
                return true;
            }
            set.add(nums[i]);
            if (set.size()>k) {
                //移除左边界
                set.remove(nums[i-k]);
            }
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        TreeSet<Long> set=new TreeSet<>();
        for (int i=0;i<nums.length;i++) {
            //大于nums[i]的最小元素
            Long ceil=set.ceiling((long)nums[i]-(long)t);
            if(ceil!=null && ceil<=(long)nums[i]+(long)t) {
                return true;
            }
            set.add((long)nums[i]);
            if (set.size()>k) {
                set.remove((long)nums[i-k]);
            }
        }
        return false;
    }
}