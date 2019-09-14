public class ContainsDuplicate217{
    public static void main(String[] args) {

    }

    public static boolean containsDuplicate(int[] nums) {
        if (nums==null) return false;
        HashSet<Integer> set=new HashSet<>();
        for (int i=0;i<nums.length;i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }

    public static boolean containsDuplicate(int[] nums) {
        if (nums==null) return false;
        HashSet<Integer> set=new HashSet<>();
        for (int i=0;i<nums.length;i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}