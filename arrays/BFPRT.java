public class BFPRT{
    public static void main(String[] args) {
        int []nums={3,2,3,1,2,4,5,5,6,23,-123,1323,41223,232,1,-213,2};
        //NlogN 构建大根堆
        /*for (int i=0;i<nums2.length;i++){heapInsert(nums2,i);}
        printArray(nums2);
        */
        //heapSort(nums);
        //quickSort(nums,0,nums.length-1);
        //printArray(nums);
        System.out.println(findKthLargest(nums,1));
    }

    public static int findKthLargest(int []nums,int k){
        return findKthLargest(nums,0,nums.length-1,k);
    }

    public static int findKthLargest(int[] nums,int l,int r,int k) {
        int mid=findMid(nums,l,r);
        swap(nums,mid,l);
        int m=partition(nums,l,r);
        if(m==nums.length-k){
            return nums[m];
        }
        if(m>nums.length-k){
            return findKthLargest(nums,l,m-1,k);
        }
        return findKthLargest(nums,m+1,r,k);
    }

    //中位数的中位数
    public static int  findMid(int []nums,int l,int r){
        int leftSub=l;
        //分组求中位数，5等分
        for (int i=l;i<r-4;i+=5) {
            insertSort(nums,i,i+4);
            //将中位数统一放到左侧，用于递归
            swap(nums,leftSub++,i+2);
        }
        //处理剩下的不足5个的
        if (r-l<4) {
            insertSort(nums,l,r);
            swap(nums,leftSub,l+(r-l)/2);
        }
        if(l==leftSub){
            return l;
        }
        return findMid(nums,l,leftSub);
    }


    //五等分的插入
    public static void insertSort(int []nums,int l,int r){
        for (int i=0;i<r;i++) {
            for (int j=i+1;j>=l&&nums[j]<nums[i];j--) {
                swap(nums,j,i);
            }
        }
    }

    //快排partion
    public static int partition(int []nums,int left,int right){
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

    public static void swap(int []nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}