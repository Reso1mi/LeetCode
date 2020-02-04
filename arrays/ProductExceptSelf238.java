public class ProductExceptSelf238{
    public static void main(String[] args) {
        ProductExceptSelf238 p=new ProductExceptSelf238();
        System.out.println(p.productExceptSelf(new int[]{1,2,3,4}));
    }

    public int[] productExceptSelf(int[] nums) {
        if (nums==null || nums.length<=0) {
            return new int[0];
        }
        int[] left=new int[nums.length+1]; 
        left[0]=1;//left[i]: [0 ~ i-1]的累积
        int[] right=new int[nums.length+1];
        right[nums.length]=1; //right[i]: [i ~ nums.length-1]的累积
        for (int i=1;i<=nums.length;i++) {
            left[i]=left[i-1]*nums[i-1];
        }
        for (int i=nums.length-1;i>=0;i--) {
            right[i]=right[i+1]*nums[i];
        }
        printArray(left);
        printArray(right);
        int[] res=new int[nums.length];
        //1 2 3
        res[0]=right[1];
        for (int i=1;i<nums.length;i++) {
            res[i]=left[i]*right[i+1];
        }
        return res;
    }

    public void printArray(int[] arr){
        for (int i=0; i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}