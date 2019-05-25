public class SortClolrs75{
	public static void main(String[] args) {
		
	}

	public static void sortColors(int[] nums) {
		int [] bucket=new int[3];
        //基于桶排序
		for(int i=0;i<nums.length;i++){
			bucket[nums[i]]++;
		}
		int index=0;
        //重新构造出来
		for (int i=0;i<nums.length;i++) {
			while (bucket[index]<=0) {
				index++;
			}
			nums[i]=index;
			bucket[index]--;
		}
	}

	//快排的思想只跑一遍
	//0 0 1 0 1 2 2 0 1
	//2 0 1 --> 1 0 2
	public static void sortColors(int[] nums) {
		int less=-1,more=nums.length-1;
		int l=0;
		while(l<=more){
			if(nums[l]<1){
				swap(nums,++less,l++);
			}else if(nums[l]>1){
				swap(nums,more--,l);
			}else{
				l++;
			}
		}
	}

	public static swap(int []nums,int a,int b){
		int temp=nums[a];
		nums[a]=nums[b];
		nums[b]=temp;
	}
}