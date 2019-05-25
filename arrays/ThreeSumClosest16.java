public class ThreeSumClosest16{
	public static void main(String[] args) {

	}


	public int threeSumClosest(int[] nums, int target) {
		int len=nums.length;	    
		if(nums==null||len<3) return 0;
		Arrays.sort(nums);
		int closest=nums[0]+nums[1]+nums[2];
		for (int i=0;i<len-2;i++) {
    		if(i!=0&&nums[i]==nums[i-1])continue; //跳过重复元素提高效率
    		int L=i+1;
    		int R=len-1;
    		while(L<R){
    			int sum=nums[L]+nums[R]+nums[i];
    			closest=Math.abs(closest-target)>Math.abs(sum-target)?sum:closest;
    			if(sum==target){
    				return target;
    			}else if(sum>target){
    				while(L<R && nums[R]==nums[R-1])R--;
    				R--;
    			}else{
    				while(L<R && nums[L]==nums[L+1])L++;
    				L++;
    			}
    		}
    	}
    	return closest;
    }
}