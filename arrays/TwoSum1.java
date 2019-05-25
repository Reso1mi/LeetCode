import java.util.*;
public class TwoSum1{
	public static void main(String[] args) {
		int []a=new int[]{5,2,1,4,3,4};
		int [] b= twoSum3(a,5);
		System.out.println(b[0]);
	}


	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer,Integer> map=new HashMap<>();
    	//第一遍把所有的元素和索引存到hashMap中
		for (int i=0;i<nums.length;i++) {
			map.put(nums[i],i);
		}
    	//再查找hash
		for (int i=0;i<nums.length;i++) {
			//不能重复所以 下标需要限制下
			if(map.containsKey(target-nums[i]) && map.get(target-nums[i])!=i){
				return new int[]{i,map.get(target-nums[i])};
			}
		}
		return new int[]{};
	}

	public int[] twoSum2(int[] nums, int target) {
		HashMap<Integer,Integer> map=new HashMap<>();
		for (int i=0;i<nums.length;i++) {
			//不能重复所以 下标需要限制下
			if(map.containsKey(target-nums[i]) && map.get(target-nums[i])!=i){
				return new int[]{i,map.get(target-nums[i])};
			}
			map.put(nums[i],i);
		}

		return new int[]{};
	}

	  public static int[] twoSum3(int[] nums, int target) {
        int index;
        int indexArrayMax=2047;
        int[] indexArrays=new int[indexArrayMax+1];
        
        int diff;
        
        for(int i=1;i<nums.length;i++){
            diff=target-nums[i];
            
            //i=0时索引无效,所以单独处理
            if(diff==nums[0]){
                return new int[]{0,i};
            }
            
            index=diff&indexArrayMax;
            System.out.println(index);
            if(indexArrays[index]!=0){
                return new int[]{indexArrays[index],i};
            }
            
            indexArrays[nums[i]&indexArrayMax]=i;
            
        }
        
        return new int[2];
    }


}