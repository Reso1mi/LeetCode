public class RemoveElement27{
	public static void main(String[] args) {
		
	}

	public int removeElement(int[] nums, int val) {
		int i = 0;
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] != val) {
				nums[i++] = nums[j];
			}
		}
		return i;
	}

	public int removeElement2(int[] nums, int val) {
		int i = 0;
		int n = nums.length;
		while (i < n) {
			if (nums[i] == val) {
				nums[i] = nums[--n];
			} else {
				i++;
			}
		}
		return n;
	}

	public static void swap(int []nums,int a,int b){
		int temp=nums[a];
		nums[a]=nums[b];
		nums[b]=temp;
	}

}