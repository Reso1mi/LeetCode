public class RemoveDuplicates26{
	
	public static void main(String[] args) {

	}

	//我好蠢啊
	public int removeDuplicates(int[] nums) {
		int len=nums.length;
		if(nums==null||len<=0) return 0;
		//0 0 1 1 1 2 2 3 3 4
		//0 0 1 1 1 2 2 3 4 3
		int count= 0;
        //原地删除重复的元素
		int maxTail=len-1;
		for (int i=len-1;i>0;i--) {
			if(nums[i]==nums[i-1]){
				count++;
				int index=i;
				while(nums[i]!=nums[len-1] && index<maxTail){
					swap(nums,index,++index);
				}
				maxTail--;
			}else if (nums[i]!=nums[i-1]) {
				continue;
			}
		}
		return len-count;
	}


	public int removeDuplicates(int[] nums) {
		int len=nums.length;
		if(nums==null||len<=0){
			return 0;
		}
		int next=1;
		//1 1 2
		for (int i=0;i<len-1;i++) {
			if(nums[i]!=nums[i+1]){
				nums[next++]=nums[i+1];	
			}
		}
		return next;
	}

	public static void swap(int []nums,int a,int b){
		int temp=nums[a];
		nums[a]=nums[b];
		nums[b]=nums[a];
	}


}