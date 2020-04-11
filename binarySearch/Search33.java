public class Search33 {
    public static void main(String[] args) {
        int[] nums = {1};
        int index = search(nums, 1);
        System.out.println(index);
    }

    public static int search2(int[] nums, int target) {
        int len = nums.length;

        if ((nums == null) || (len <= 0)) {
            return -1;
        }

        int lo = 0;
        int hi = len - 1;

        while (lo <= hi) {
            int mid = lo + ((hi - lo) / 2);
            // 左, 右 指的是旋转点左右
            if (nums[mid] > target) { //首先是大于target的情况
                if (target < nums[lo]) {
                    //target在右边
                    //mid未知还需要判断下 画一个折线图就很清楚了
                    if (nums[mid] <= nums[hi]) { //mid也在右边
                        hi = mid - 1;
                    } else {
                        //mid在左边
                        lo = mid + 1;
                    }
                } else if (target > nums[lo]) {
                    //说明mid在左边, target也在左边
                    hi = mid - 1;
                } else {
                    return lo;
                }
            } else if (nums[mid] < target) { //小于target的情况
                if (target < nums[hi]) {
                    //mid在右边，target在右边
                    lo = mid + 1;
                } else if (target > nums[hi]) {
                    //target在左边
                    //mid未知还需要判断下
                    if (nums[mid] > nums[hi]) { //mid在左边
                        lo = mid + 1;
                    } else {
                        hi = mid - 1;
                    }
                } else {
                    return hi;
                }
            } else {
                return mid;
            }
        }
        return -1;
    }

    //logN*logN
    public static int search(int[] nums, int target) {
        int lo=0,hi=nums.length-1;
        if(nums==null||nums.length<=0){
            return  -1;
        }
        int index=-1;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(nums[mid]>=nums[lo]){ //左半部分有序
                index=binarySearch(nums,target,lo,mid); //对右半部分二分
                if(index==-1){
                    lo=mid+1; //lo-->mid 没找到就对右半部分继续划分
                }else return index;
            }else if(nums[mid]<nums[lo]){//右半部分有序
                index=binarySearch(nums,target,mid,hi);
                if(index==-1){
                    hi=mid-1;
                }else return index;
            }
        }
        return  index;
    }

    public static int binarySearch(int []nums,int target,int lo,int hi){
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(nums[mid]>target){
                hi=mid-1;
            }else if(nums[mid]<target){
                lo=mid+1;
            }else return mid;
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        if(nums==null || nums.length<=0) return -1;
        int left=0,right=nums.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            int midNum=(nums[mid]>=nums[0])==(target>=nums[0])?nums[mid]:
            nums[mid]>=nums[0]?Integer.MIN_VALUE:Integer.MAX_VALUE;
            if(midNum<target){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return nums[left]!=target?-1:left;
    }
}
