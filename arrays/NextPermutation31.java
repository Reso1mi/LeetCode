public class NextPermutation31{

	public static void main(String[] args) {
			

	
	}

	public void nextPermutation(int[] nums) {
		int len=nums.length;
		if(nums==null||len<=1){
			return;
		}
		
		for (int i=len-2;i>=0;i--) {
			while(i>=0 &&nums[i]>=nums[i+1]){
     			//从右向左找到峰值左边的第一个
				i--;
			}
     		//逆序的, 没有最大值
			if(i==-1){
				reverse(nums,0);
				return;
			}

     		//找到峰值右边 [i+1 , len-1] 最后一个比i 大的元素
			for (int j=len-1;j>i;j--) {
				if(nums[j]>nums[i]){
					swap(nums,j,i);
					reverse(nums,i+1);
					return;
				}
			}
		}
	}

    //翻转数组
	private void reverse(int[] nums, int start) {
		for (int i=start,j=nums.length-1;i<j;i++,j--) {
			swap(nums,i,j);
		}
	}

	private  static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}