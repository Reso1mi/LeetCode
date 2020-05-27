public class FindDuplicate287{
    public static void main(String[] args) {

    }

    public int findDuplicate(int[] nums){
        int left=1,right=nums.length-1;
        //这里实际上是对【1,2,3,4,...n-1】这个区间进行二分
        //在过程中对mid检测每个数在nums数组中出现的次数
        //1 3 4 2 2实际上是对【1,2,3,4】区间进行二分
        while(left<right){
            int mid=left+(right-left)/2+1;
            //小于mid的数大于mid,排除mid
            if(count(nums,mid)>=mid){ 
                right=mid-1;
            }else{
                left=mid;
            }
        }
        return left;
    }

    //n-1个整数 , 1~n有n个数     
    //1 2 2 3 4     1~4之间, 1 2 3 4
    public int count(int[] nums,int n){
        int res=0;
        for (int i=0;i<nums.length;i++) {
            if (nums[i]<n) {
                res++;          
            }
        }
        return res;
    }

    //技巧性很强的快慢指针
    public int findDuplicate(int[] nums){
        int slow=0,fast=0;
        boolean isMeet=false;
        while(true){
            fast=isMeet?nums[fast]:nums[nums[fast]];
            slow=nums[slow];
            if (fast==slow) {
                if (isMeet) {
                    return slow;
                }
                fast=0;
                isMeet=true;
            }
        }
    }
}