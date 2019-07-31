public class FirstMissingPositive41{
    
    public static void main(String[] args) {
        FirstMissingPositive41 s=new FirstMissingPositive41();
        int []num={-1,4,2,1,9,10};
        int a=s.firstMissingPositive(num);
        System.out.println(a);
    }


    //思路就是将数组按照 值去和对应位置+1 的元素交换，然后遍历这个数组
    public int firstMissingPositive(int[] nums) {
        
        if(nums==null||nums.length<=0){
            return 1;
        }
        
        for(int i=0;i<nums.length;++i){
            //一次到位
            while(nums[i]>=1&&nums[i]<=nums.length&&nums[nums[i]-1]!=nums[i])
            {
                int temp=nums[nums[i]-1];
                nums[nums[i]-1]=nums[i];
                nums[i]=temp;
            }
        }
        for(int i=0;i<nums.length;++i){
            if(nums[i]!=i+1)
                return i+1;
            return nums.length+1;
        }
    }

    public int firstMissingPositive2(int[] nums) {
        if(nums==null||nums.length<=0){
            return 1;
        }
        int [] bucket=new int[nums.length];
        for(int i=0;i<nums.length;++i){
            if(nums[i]>0 && nums[i]<=nums.length){
                bucket[nums[i]-1]=1; //代表这个桶有元素了
            }
        }
        for(int i=0;i<bucket.length;++i){
            if(bucket[i]==0)
                return i+1;
        }
        return nums.length+1;
    }
}