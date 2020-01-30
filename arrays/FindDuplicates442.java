public class FindDuplicates442{
    public static void main(String[] args) {

    }

    public List<Integer> findDuplicates(int[] nums) {
        for (int i=0;i<nums.length;i++) {
            while(nums[i]!=i+1 && nums[i]!=nums[nums[i]-1]){
                int temp=nums[nums[i]-1];
                nums[nums[i]-1]=nums[i];
                nums[i]=temp;
            }
        }
        List<Integer> res=new LinkedList<>();
        for (int i=0;i<nums.length;i++) {
            if (nums[i]!=i+1) {
                res.add(nums[i]);
            }
        }
        return res;
    }

    //5 1 1 3 2
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res=new LinkedList<>();
        for (int i=0;i<nums.length;i++) {
            if (nums[Math.abs(nums[i])-1]<0) {
                res.add(Math.abs(nums[i]));
            }
            nums[Math.abs(nums[i])-1]=-Math.abs(nums[Math.abs(nums[i])-1]);
        }
        return res;
    }
}