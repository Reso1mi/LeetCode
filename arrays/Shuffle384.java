public class Shuffle384{
    public static void main(String[] args) {

    }

    int[] origin=null;

    int[] nums=null;
    
    Random random=new Random();
    
    public Solution(int[] nums) {
        this.nums=nums;
        origin=nums.clone();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return origin;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i=nums.length-1;i>=0;i--) {
            //从尾部开始这样对于Java会简单一点点
            int rand=(int)(random.nextInt(i+1)); //随机【0,i】的元素
            swap(nums,i,rand);
        }
        return nums;
    }

    public void swap(int[] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}