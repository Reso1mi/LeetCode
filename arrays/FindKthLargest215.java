import java.util.PriorityQueue;
public class FindKthLargest215{
    public static void main(String[] args) {
        //int []nums={3,2,1,5,6,4};
        
        int []nums={3,2,3,1,2,4,5,5,6,23,-123,1323,41223,232,1,-213,2};
        //NlogN 构建大根堆
        /*for (int i=0;i<nums2.length;i++){heapInsert(nums2,i);}
        printArray(nums2);
        */
        //heapSort(nums);
        quickSort(nums,0,nums.length-1);
        printArray(nums);
        System.out.println(findKthLargest2(nums,5));
    }


    //快排的思想
    public static int findKthLargest2(int[] nums, int k) {
        int n=nums.length;
        int left=0,right=nums.length-1;
        while(left<right){
            int base=partion(nums,left,right);
            if(base<n-k){
                left=base+1;
            }else if(base>n-k){
                right=base-1;
            }else{
                return nums[base];
            }
            //System.out.println(left+","+base+","+right);
        }
        return -1;
    }


    //试一下快排
    public static void quickSort(int []nums,int left,int right){
        if(left>=right){
            return;
        }
        int base=partion(nums,left,right);
        quickSort(nums,left,base-1);
        quickSort(nums,base+1,right);
    }

    public static int partion(int []nums,int left,int right){
        //随机取值
        swap(nums,left,left+(int) (Math.random() * (right - left + 1)));
        int base=left;
        while(left<right){
            while(left<right&&nums[right]>nums[base]){
                right--;
            }
            while(left<right&&nums[left]<=nums[base]){
                left++;
            }
            if(left<right){
                swap(nums,left,right);
            }
        }
        //归位
        swap(nums,left,base);
        return left;
    }



    //堆排序的做法
    public static void heapSort(int []nums){
        int last=nums.length-1;
        //N构建大根堆
        for (int i=nums.length/2-1 ;i>=0;i--){
            siftDown(nums,i,last);
        }
        //printArray(nums);
        while(last>=1){
            swap(nums,0,last--);
            siftDown(nums,0,last);
        }
    }




    public static int findKthLargest(int[] nums, int k) {
        //构建了大根堆
        /*for (int i=0;i<nums.length;i++){
            heapInsert(nums,i);
        }*/
        //小根堆
        int last=nums.length-1;
        for (int i=nums.length/2-1;i>=0;i--) {
            siftDown(nums,i,last);
        }
        for (int i=0;i<k-1;i++) {
            swap(nums,0,last);
            siftDown(nums,0,--last);
        }
        return nums[0];
    }


    public static void siftUp(int[] nums,int i){
        while(nums[i]>nums[(i-1)/2]){
            swap(nums,i,(i-1)/2);
            i=(i-1)/2;
        }
    }

    //i 变小 下沉
    public static void siftDown(int[] nums,int i,int last){
        //判断有没有子节点（左孩子）
        int left=i*2+1;
        while(left<=last){
            int right=left+1;
            //左右节点最大值
            int larger=right<=last && nums[right] > nums[left]?right:left;
            if(nums[larger]>nums[i]){
                swap(nums,larger,i);
                i=larger;
                left=larger*2+1;
            }else{
                break;
            }
        }
    }
    
    public static  void  swap(int []nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }

    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}