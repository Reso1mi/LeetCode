public class QuickSort{
    public static void main(String[] args) {
        int[] nums={1,2,0,-1,1,214,23,4,12,43,51,2312,451,23,4,1,32,412,12,4,124,124,124,314,31,4,232321,-123};   
        quickSort(nums,0,nums.length-1);
        for (int i=0;i<nums.length;i++) {
            System.out.println(nums[i]);
        }
    }

    public static void quickSort(int[] nums,int left,int right){
        if(left>=right){
            return;
        }
        int[] mid=partition2(nums,left,right);
        quickSort(nums,left,mid[0]-1);
        quickSort(nums,mid[1]+1,right);
    }

    public static int[] partition(int []nums,int left,int right){
        int less=left-1,more=right-1;
        int i=left,base=right;
        while(i<=more){
            if (nums[i]>nums[base]) {
                swap(nums,more--,i);
            }else if(nums[i]<nums[base]){
                swap(nums,++less,i++);
            }else{
                i++;
            }
        }
        // (less,more]
        //right归位
        swap(nums,more+1,right);
        return new int[]{++less,more};
    }


    public static int[] partition2(int []nums,int left,int right){
        int less=left-1,more=right;
        int i=left;
        while(i<more){
            if (nums[i]>nums[right]) {
                swap(nums,--more,i);
            }else if(nums[i]<nums[right]){
                swap(nums,++less,i++);
            }else{
                i++;
            }
        }
        // (less,more)
        //right归位
        swap(nums,more,right);
        return new int[]{++less,more};
    }

    public static void swap(int[] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}