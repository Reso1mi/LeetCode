import java.util.Arrays;
import java.util.Random;

public class Sorts{
    public static void main(String[] args) {
        /*int []nums={1,0,-1,-22,213,4,535,-112,99999};
        //ShellSort(nums);
        //MaoPaoSort(nums);
        //SelectSort(nums);
        //MergerSort(nums,0,nums.length-1);
        QuickSort(nums,0,nums.length-1);
        printArray(nums);*/

        int testTime = 10000;
        int maxSize = 10000;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            long time=System.currentTimeMillis();
            //冒泡
            //MaoPaoSort(arr1);
            //选择
            //SelectSort(arr1);
            //插入
            //InsertSort(arr1);
            //归并
            //MergerSort(arr1);
            //非递归归并
            //MergerSortNoRecurse(arr1);
            //希尔
            //ShellSort(arr1);
            //快排
            QuickSort(arr1,0,arr1.length-1);
            //堆排序
            //HeapSort(arr1);
            long time2=System.currentTimeMillis();
            if(i==0){
                System.out.println(time2-time);
            }
            //系统排序
            comparator(arr2);
            if(i==0){
                System.out.println(System.currentTimeMillis()-time2);
            }
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

//初级排序算法
//*************************************************************************************************************************************************************************
//*************************************************************************************************************************************************************************
//*************************************************************************************************************************************************************************
    //冒泡排序
    private static void MaoPaoSort(int []nums){
        for(int i=nums.length-1;i>=0;i--){
            for(int j=0;j<i;j++){
                if(nums[j]>nums[j+1]){
                    swap(nums,j,j+1);
                }
            }
        }
    }
//*************************************************************************************************************************************************************************
//*************************************************************************************************************************************************************************
//*************************************************************************************************************************************************************************
    //选择排序
    private static void SelectSort(int []nums){
        for(int i=0;i<nums.length;i++){
            int min=nums[i];
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]<min){
                    min=nums[j];
                    swap(nums,j,i);
                }
            }
        }
    }
//*************************************************************************************************************************************************************************
//*************************************************************************************************************************************************************************
//*************************************************************************************************************************************************************************
    //直接插入排序
    private static void InsertSort(int []nums){
        for(int i=1;i<nums.length;i++){
            for(int j=i;j>0&&nums[j]<nums[j-1];j--){
                swap(nums,j,j-1);
            }
        }
    }
//*************************************************************************************************************************************************************************
//*************************************************************************************************************************************************************************
//*************************************************************************************************************************************************************************
    //插入排序的改进
    private static void ShellSort(int [] nums){
        int h=nums.length>>1;
        while(h>0){
            for(int i=h;i<nums.length;i++){
                //实际上是增大了插入排序的间隙，最后还是对进行一次插入排序,不过那个时候的数据已经是高度有序了
                for (int j=i;j-h>=0&&nums[j]<nums[j-h];j-=h) {
                    swap(nums,j,j-h);
                }
            }
            h=h>>1; 
        }
    }
//*************************************************************************************************************************************************************************
//*************************************************************************************************************************************************************************
//*************************************************************************************************************************************************************************

    //归并排序
    private static void MergerSort(int []nums){
        help=new int[nums.length];
        MergerSort(nums,0,nums.length-1);
    }

    private static void MergerSort(int []nums,int left,int right){
        if(left>=right){
            return;
        }
        //不能直接在这里创建数组，严重影响性能，可以在上面再套一层方法，或者采用merger2的方式(也不好，应该保证辅助数组只初始化一次)
        //help=new int[nums.length];
        int mid=left+((right-left)>>1);
        MergerSort(nums,left,mid);
        MergerSort(nums,mid+1,right);
        merger(nums,left,mid,right);
    }

    //辅助数组
    private static int []help;
    //归并操作
    private static void merger(int []nums ,int left,int mid,int right){
        int i=left,j=mid+1;
        //其实没区别空间复杂度，都是O(N) 后面这个会更加耗费时间
        //int []help=new int[right-left+1];
        for(int k=left;k<=right;k++){
            //一边的到达尽头,先判断两个边界,不然就要想下面那样写
            if(i>mid){
                help[k]=nums[j++];
            }else if(j>right){
                help[k]=nums[i++];
            }else if(nums[i]>nums[j]){
                help[k]=nums[j++];
            }else{
                //相等的时候左边先进栈保证稳定性
                help[k]=nums[i++];
            }

            /*// 2 
            if( i<=mid &&j<=right && nums[i]>nums[j]){
                help[k]=nums[j++];
            }else if( i<=mid &&j<=right && nums[i]<=nums[j]){
                //相等的时候左边先进栈保证稳定性
                help[k]=nums[i++];
            }else if(i>mid){
                help[k]=nums[j++];
            }else if(j>right){ 
                help[k]=nums[i++];
            }*/
        }
        //复制
        for(int k=left;k<=right;k++){
            nums[k]=help[k];
        }

        //asddsdasdasdasd
        /*while (p1 <= m && p2 <= r) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }*/
    }

    //归并排序（非递归，方向不一样，时间复杂度一样都为O(NlogN)
    private static void MergerSortNoRecurse(int []nums){
        help=new int[nums.length];
        //控制合并的长度 
        for(int sz=1;sz<nums.length;sz*=2){
            //控制合并的向后移动
            for(int i=0;i<nums.length-sz;i+=2*sz){
                int r=i+2*sz-1<nums.length-1?i+2*sz-1:nums.length-1;
                merger(nums,i,i+sz-1,r);
            }
        }
    }
//*************************************************************************************************************************************************************************
//*************************************************************************************************************************************************************************
//*************************************************************************************************************************************************************************
    //快排 (不具有稳定性或者难以实现)
    private static void QuickSort(int []nums,int l,int r){
        if(l>=r){
            return;
        }
        //随机一个数和r交换 ---随机快排
        swap(nums, l + (int) (Math.random() * (r - l + 1)), r);     
        /*int []index=partition2(nums,l,r);
        QuickSort(nums,l,index[0]-1);
        QuickSort(nums,index[1]+1,r);*/

        int base=partition1(nums,l,r);
        QuickSort(nums,l,base-1);
        QuickSort(nums,base+1,r);
    }

    public static int partition1(int []nums ,int l,int r){      
        int base = l;
        //双指针
        int lo = l, hi = r;

        //这种partition的实现细节有点不好理解
        //这种partition不能随机基准元素。。。。
        //参照了左神的代码发现其实可以在partition之前随机一个变量和lo交换，也有同样的效果也消除了输入的影响
        while (lo < hi) {
            //必须先从右往左,主要是为了归位的时候不出现问题
            //比如这里选取的基准元素是 lo 也就是子数组的第一个元素，如果先从左往右最后交换的就是lo和一个比lo大的数然而比lo大的数应该放在右边
            //反之如果选的是hi为基准就要先从左往右
            // 7  0  1  2    10  11  22
            while (nums[hi] > nums[base] && lo < hi) {
                hi--;
            }
            while (nums[lo] <= nums[base] && lo < hi) {
                lo++;
            }
            if (lo < hi) {
                swap(nums, lo, hi);
            }
        }
        //归位 lo==hi
        swap(nums, hi, base);
        return lo;
    }


    //荷兰国旗优化的快排
    public static int[] partition2(int []arr ,int l,int r){
        // 7  0  1  2    10  11  22     
        //小于区为空
        int less=l-1;
        //l ----> more 为待定区
        int more=r;
        while(l<more){
            if(arr[l]<arr[r]){
                swap(arr,++less,l++);
            }else if(arr[l]>arr[r]){
                //大于基准时 , 大于区扩大(大于区的前一个元素和当前元素交换，但是不知道大于区的前一个元素是什么情况，所以不能l++)
                swap(arr,--more,l);
            }else{
                l++;
            }
        }
        //和大于区间的第一个交换 保证归位正确,如果选取的是以最左边为基准元素 这里就应该和less交换
        //到这里  [less+1,more-1]之间都是等于 基准元素 arr【r】 的
        swap(arr,more,r);
        //到这  [less+1,more]之间都是等于 基准元素 arr【r】 的
        return new int[]{less+1,more};
    }
//*************************************************************************************************************************************************************************
//*************************************************************************************************************************************************************************
//*************************************************************************************************************************************************************************
    //堆排序
    private static void HeapSort(int []nums){
        if(nums.length<2){
            return;
        }

        //构建大根堆
        for (int i=0; i<nums.length; i++) {
            heapInsert(nums,i); 
        }
        //交换堆顶和最后一个节点
        int size= nums.length;
        swap(nums,size-1,0);
        size--;
        while(size>1){
            //调整
            heapIfy(nums,0,size);
            //每次都和最后一个孩子节点交换，然后继续调整
            //--size相当与将 大根剔除
            swap(nums,--size,0);
        }
    }

    //向上爬
    private static void heapInsert(int []nums, int index){
        //迭代比较当前节点和父节点的值的大小
        while(nums[index]>nums[(index-1)/2]){
            swap(nums,index,(index-1)/2);
            index=(index-1)/2;
        }
    }

    //向下爬
    //index位置的值变小后继续调整为大根堆
    private static void heapIfy(int []nums,int index,int size){
        //左孩子
        int left=index*2+1;
        //节点有左孩子
        while(left<size){
            //判断是否有右孩子.....
            //左右孩子里的最大值 有右孩子且右孩子大于左孩子
            int largest=left+1<size && nums[left]<nums[left+1] ?left+1:left;
            largest=nums[largest]>nums[index]?largest:index;
            //最大值等于自己
            if(largest==index){
                break;
            }
            //交换大孩子节点和自己
            swap(nums,largest,index);
            //设置大孩子的index和左孩子
            index=largest;
            left=index*2+1;
        }
    }

//*************************************************************************************************************************************************************************
//*************************************************************************************************************************************************************************
//*************************************************************************************************************************************************************************
    private static void swap(int []nums,int a,int b){
        //不知道为啥快排交换的时候这样写会出现很多0
        //查询知道，当a==b时自己和直接交换，a异或自己4次后a==0.....
        /*nums[a]=nums[a]^nums[b];
        nums[b]=nums[a]^nums[b];
        nums[a]=nums[a]^nums[b];*/
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }

    // for test  对数器
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
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