import java.util.PriorityQueue;
public class FindKthLargest215{
	public static void main(String[] args) {
		int []nums={3,2,3,1,2,4,5,5,6};
		//构建了大根堆
		for (int i=0;i<nums.length;i++){
			heapInsert(nums,i);
		}
		printArray(nums);

		System.out.println(findKthLargest(nums,10));
	}

	public static int findKthLargest(int[] nums, int k) {
		//构建了大根堆
		for (int i=0;i<nums.length;i++){
			heapInsert(nums,i);
		}
		int size=nums.length-1;
		for (int i=0;i<k-1;i++) {
			swap(nums,0,size);
			heapSwim(nums,0,--size);
		}
		return nums[0];
	}

	public static void heapInsert(int[] nums,int i){
		while(nums[i]>nums[(i-1)/2]){
			swap(nums,i,(i-1)/2);
			i=(i-1)/2;
		}
	}

    //i 变小 下沉
	public static void heapSwim(int[] nums,int i,int size){
    	//判断有没有子节点（左孩子）
		int left=i*2+1;
		while(left<size){
			int right=left+1;
    		//左右节点最大值
    		//int larger=right>size||(right<size &&nums[right]<nums[left])?left:right;
			int larger=left+1<size && nums[left]<nums[left+1] ?left+1:left;
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