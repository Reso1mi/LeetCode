public class NumSubseq1498{
    public static void main(String[] args) {

    }

    //双指针
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int MOD = (int)(1e9+7);
        int n = nums.length;
        //预处理出幂值表
        int[] pow = new int[n];
        pow[0] = 1;
        for (int i = 1; i < n; i++){
            pow[i] = (pow[i-1] << 1) % MOD;
        }
        int left = 0, right = n-1;
        long count = 0;
        while(left <= right){
            while(left <= right && nums[left] + nums[right] > target) {
                right--;
            }
            if (left <= right) {
                //nums[left] + nums[right] <>= target 
                //包含left的子序列个数: left固定，在[left+1,right]选若干个，就有 2^(right-left) 种选法
                count = (count + pow[right-left]) % MOD ;
            }
            left++;
        }
        return (int)count%MOD;
    }

    //二分
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int MOD = (int)(1e9+7);
        int n = nums.length;
        //预处理出幂值表
        int[] pow = new int[n];
        pow[0] = 1;
        for (int i = 1; i < n; i++){
            pow[i] = (pow[i-1] << 1) % MOD;
        }
        long count = 0;
        for (int i = 0; i < n; i++) {
            if (target-nums[i] < 0){
                break;
            }
            int right = search(nums, target-nums[i]);
            if (right >= i){
                count = (count + pow[right-i]) % MOD;
            }
        }
        return (int) count % MOD;
    }

    //搜索最后一个小于等于target的值
    public int search(int[] nums, int target){
        int left = 0, right = nums.length-1;
        int res = -1;
        while (left <= right) {
            int mid = left + (right-left)/2;
            if (nums[mid] <= target){
                res = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return res;
    }
}