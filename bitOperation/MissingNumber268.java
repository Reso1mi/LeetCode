public class MissingNumber268{
    public static void main(String[] args) {

    }

    public int missingNumber(int[] nums) {
        int N=nums.length;
        int sum=0;
        for (int i=0;i<N;i++) {
            sum+=nums[i];
        }
        return N*(N+1)/2-sum; //可能会溢出
    }

    public int missingNumber(int[] nums) {
        int res=0;
        //3 0 1 
        for (int i=0;i<nums.length;i++) {
            res^=nums[i];
            res^=i;
        }
        //3^0^1^0^1^2^3=2
        return res^nums.length;
    }
}