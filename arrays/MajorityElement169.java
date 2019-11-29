public class MajorityElement169{
    public static void main(String[] args) {

    }

    //摩尔投票法
    public int majorityElement(int[] nums) {
        int sum=1;
        int res=nums[0]; 
        for (int i=1;i<nums.length;i++) {
            if (sum==0) {
                res=nums[i];
            }
            //将众数看做1,其他的看作-1,最后和一定是大于0的
            if (res!=nums[i]) {
                sum--;
            }else{
                sum++;
            }
        }
        return res;
    }

    //分治
    public int majorityElement(int[] nums) {
        return majorityElement(nums,0,nums.length-1);
    }

    public int majorityElement(int[] nums,int lo,int hi) {
        if (lo==hi) {
            return nums[lo];
        }
        int mid=lo+(hi-lo)/2;
        int leftMode=majorityElement(nums,lo,mid);
        int rightMode=majorityElement(nums,mid+1,hi);
        if (leftMode==rightMode) {
            return rightMode;
        }
        return countMode(nums,lo,mid,leftMode)>countMode(nums,mid+1,hi,rightMode)?leftMode:rightMode;
    }

    public int countMode(int[] nums,int left,int right,int mode){
        int count=0;
        for (int i=left;i<=right;i++) {
            if (mode==nums[i]) {
                count++;
            }
        }
        return count;
    }
}