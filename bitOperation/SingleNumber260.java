public class SingleNumber260{
    public static void main(String[] args) {

    }

    public int[] singleNumber(int[] nums) {
        if(nums==null || nums.length<=0) return new int[0];
        int xor=nums[0];
        for (int i=1;i<nums.length;i++) {
            xor^=nums[i];
        }
        int index=0; //ab不同的index
        while((xor&1)==0){
            xor>>>=1;
            index++;
        }
        int a=0,b=0;
        for (int i=0;i<nums.length;i++) {
            //根据index位置的二进制0,1分组
            if(((nums[i]>>>index)&1)==1){ 
                a^=nums[i];
            }else{
                b^=nums[i];
            }
        }
        return new int[]{a,b};
    }
}