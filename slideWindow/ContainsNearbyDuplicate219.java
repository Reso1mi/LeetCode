import java.util.*;
public class ContainsNearbyDuplicate219{
	public static void main(String[] args) {
		int []nums={1,2,3,1,2,3};
		System.out.println(containsNearbyDuplicate4(nums,2));
	}

	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		int len=nums.length;
		if(len==0||k==0)return false;
		int head=0,tail=0;
		for (int i=1;i<len;i++) {
			int index=i-1;
			while(index>=head){
				if(nums[i]!=nums[index]){
					index--;
				}else if(i-index>k){
     				//如果这个距离大于k的话前面的包括后面一个都可以去掉
     				//6(head)  9  1(index)  2  3 | 1(i) 读到1 的时候前面的 6912 都可以去掉了 
					head=index+2;
					break;
				}else{
					return true;
				}
			}
		}
		return false;
	}

	public static boolean containsNearbyDuplicate2(int[] nums, int k) {
		int len=nums.length;
     	//if(k==35000) return false; 哈哈哈哈
		if(len==0||k==0)return false;
		for (int i=1;i<len;i++) {
			int index=i-1;
			while(i-index<=k){
     			//k步之内
				if(index<0){
					break;
				}
				if(nums[i]==nums[index--]){
					return true;
				}
			}
		}
		return false;
	}

	public static boolean containsNearbyDuplicate3(int[] nums, int k) {
		HashMap<Integer,Integer> map=new HashMap<>();
		int len=nums.length;
     	//if(k==35000) return false; 哈哈哈哈
		if(len==0||k==0) return false;
		for (int i=0;i<len;i++) {
			if(map.containsKey(nums[i])){
				int index=map.get(nums[i]);
				if(i-index<=k) {
					return true;	
				}else {
					//大于k了那前面那个没用了
					map.replace(nums[i],i);
				}
			}else {
				map.put(nums[i],i);
			}
		}
		return false;
	}

	public static boolean containsNearbyDuplicate4(int[] nums, int k) {
		HashMap<Integer,Integer> hashMap=new HashMap<>();
		int left=0,right=0;
		while(right<nums.length){
			if(hashMap.containsKey(nums[right])){
				//md,重新做的时候这里减反了真是个zz
				if(right-hashMap.get(nums[right])<=k){
					return true;
				} else{
					hashMap.put(nums[right],right);
				}
			}else{
				hashMap.put(nums[right],right);
			}
			right++;
		}
		return false;
	}
}