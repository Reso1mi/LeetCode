public class NumsSort{

	public static void main(String[] args) {
		int []nums={1,2,3,-2,-4,5,3,-2,4,1,-5,3,-7};
		sortColors(nums);
		printArray(nums);
	}

	public static void sortColors(int[] nums) {
		int j=0;//指向未遍历数据中的正数
        int k=0;//指向未遍历数据中的第一个符数
        for(int i=0;i<nums.length;i++,k++)
        {
            while(j<nums.length&&nums[j]>=0)
                j++;
            while(k<nums.length&&nums[k]<0)
                k++;
            if(j==nums.length||k==nums.length) break;
            else if(j>k) continue;
            else
            {
                int temp=nums[j];
                nums[j]=nums[k];
                nums[k]=temp;
                j++;
            }
        }
	}

	public static void swap(int []nums,int a,int b){
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