public class Rotate189{
    public static void main(String[] args) {

    }



    public void rotate(int[] nums, int k) {
        if(nums==null||nums.length<=1||k==0){
            return;
        }
        int len=nums.length;
        k=k%len;
        for (int i=0;i<k;i++) {
            int temp=nums[len-1];
            for (int j=len-1;j>=0;j--) {
                nums[j]=nums[j-1];
            }
            nums[0]=temp;
        }
    }


    //翻转的方法
    public void rotate(int[] nums, int k) {
        if(nums==null||nums.length<=1||k==0){
            return;
        }
        int len=nums.length;
        k=k%len;
        if(k==0)return;
        reverse(nums,0,len-k-1);
        reverse(nums,len-k,len-1);
        reverse(nums,0,nums.length-1);
    }
    
    public void reverse(int []nums,int left,int right){
        while(left<right){
            swap(nums,left++,right--);
        }
    }
    
    public void swap(int []nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}