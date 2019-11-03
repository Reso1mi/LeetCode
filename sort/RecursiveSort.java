public class RecursiveSort{
    public static void main(String[] args) {
        int[] nums={1,2,4,512,3,1,24,1,23,23,21,312,4,4512,321,3,412,3,345,234,23,23,21,4,3,213};
        mpSort(nums,0,0);
        for (int i=0;i<nums.length;i++) {
            System.out.println(nums[i]);
        }
    }

    public static void mpSort(int[] nums){
        for (int i=0;i<nums.length;i++) {
            for (int j=0;j<nums.length-i-1;j++) {
                if (nums[j]>nums[j+1]) {
                    swap(nums,j,j+1);
                }
            }
        }
    }

    //纯递归冒泡排序
    public static void mpSort(int[] nums,int idx,int index){
        if (idx==nums.length) {
            return;
        }
        if (index==nums.length-1) {
            mpSort(nums,idx+1,0);
            return;
        }
        if (nums[index]<nums[index+1]) {
            swap(nums,index+1,index);
        }
        mpSort(nums,idx,index+1);
    }

    public static void swap(int[] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}