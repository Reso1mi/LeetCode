public class MinSubArrayLen209{

	public static void main(String[] args) {
		int []nums={8,3,1,2,4,3};
		System.out.println(minSubArrayLen2(7,nums));
	}
	
	public static int minSubArrayLen(int s, int[] nums) {
		int len=nums.length;
		if(len==0)return 0;
		
		int minLen=Integer.MAX_VALUE;
		for(int i=1;i<len;i++){
			if(nums[i-1]>=s) return 1;
			int index=i-1;
			int sum=nums[i];
			while(sum<s&&index>=0){
				sum+=nums[index--];
			}
			if(sum>=s){
				minLen=minLen>i-index?i-index:minLen;
			}else if(i==len-1){
				return 0;
			}
		}
		return minLen;
	}

	public static int minSubArrayLen2(int s, int[] nums) {
		int len =nums.length;
		if(len==0)return 0;
		int head=0,tail=-1;
		int minLen=Integer.MAX_VALUE;
		int sum=0;
		// 2,3,1,2,4,3 | 7
		while (tail<len) {
			if(sum>=s){
				minLen=minLen>tail-head+1?tail-head+1:minLen;
				//System.out.println(minLen);
				sum-=nums[head++];
			}else{
				//尾指针到达边界了
				if(tail==len-1) break;
				sum+=nums[++tail];
				//如果有元素大于s直接返回，节约时间
				if(nums[tail]>=s){
					return 1;
				}
			}
		}
		return minLen==Integer.MAX_VALUE?0:minLen;
	}
}