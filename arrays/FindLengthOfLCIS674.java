public class FindLengthOfLCIS674{
    public static void main(String[] args) {

    }

    public int findLengthOfLCIS(int[] nums) {
        if(nums==null || nums.length<=0) return 0;
        int i=1,res=1;
        while(i<nums.length){
            int count=1;
            while(i<nums.length && nums[i]>nums[i-1]){
                count++;
                i++;
            }
            res=Math.max(count,res);
            i++;
        }
        return res;
    }

    public int findLengthOfLCIS(int[] nums) {
        if(nums==null || nums.length<=0) return 0;
        int count=1,res=1;
        for (int i=1;i<nums.length;i++) {
            if (nums[i]>nums[i-1]) {
                count++;
            }else{
                count=1;
            }
            res=Math.max(count,res);
        }
        return res;
    }
}