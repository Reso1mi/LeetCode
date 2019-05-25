import java.util.*;
public class MaxSlidingWindow239{
	
	public static void main(String[] args) {
		int []nums={1,3,-1,-3,5,3,6,7};
		int []nums1={7,2,4};
		printArrays(maxSlidingWindow2(nums1,2));

	}


	/* k=3
   [1  3  -1] -3  5  3  6  7       3
 	1 [3  -1  -3] 5  3  6  7       3
 	1  3 [-1  -3  5] 3  6  7       5
 	1  3  -1 [-3  5  3] 6  7       5
 	1  3  -1  -3 [5  3  6] 7       6
 	1  3  -1  -3  5 [3  6  7]      7
	 */

	//双端队列
 	public static int[] maxSlidingWindow(int[] nums, int k) {
 		//题目上说的不为空，还是给我来了个空。。。。
 		if(nums.length==0){
 			return new int[]{};
 		}
 		if(k==1) return nums;
 		LinkedList<Integer> list=new LinkedList<Integer>();
 		int []res=new int[nums.length-k+1];
 		int index=0;
 		list.add(nums[0]);
 		for (int i=1;i<nums.length;i++) {
 			while(!list.isEmpty() && list.getLast()<nums[i]){
 				//小于nums[i]的元素 从右边(尾)出队列 控制最左边(头)最大
 				list.removeLast();
 			}
 			//然后将它加到队列中，从右边(尾)
 			list.addLast(nums[i]);

 			//如果队列满了
 			if(i-index+1==k){
 				System.out.println(list.getFirst());
 				list.removeFirst();
 			}

 			if(i>=k-1){
 				res[index++]=list.getFirst();
 			}
 		}
 		return res;
 	}

 	//双端队列
 	public static int[] maxSlidingWindow2(int[] nums, int k) {
 		//题目上说的不为空，还是给我来了个空。。。。
 		if(nums.length==0){
 			return new int[]{};
 		}
 		if(k==1) return nums;
 		LinkedList<Integer> list=new LinkedList<Integer>();
 		int []res=new int[nums.length-k+1];
 		int index=0;
 		list.add(0);
 		for (int i=1;i<nums.length;i++) {
 			while(!list.isEmpty() && nums[list.getLast()]<nums[i]){
 				//小于nums[i]的元素 从右边(尾)出队列 控制最左边(头)最大
 				list.removeLast();
 			}
 			//然后将它加到队列中，从右边(尾)
 			list.addLast(i);

 			//如果队列溢出了就从右边移除一个（头）
 			if(i-list.getFirst()==k){
 				list.removeFirst();
 			}

 			if(i>=k-1){
 				res[index++]=nums[list.getFirst()];
 			}
 		}
 		return res;
 	}

 	public static int[] maxSlidingWindow3(int[] nums, int k) {
 		//题目上说的不为空，还是给我来了个空。。。。
 		int len = nums.length;
        if (len == 0) return new int[]{};
        if (len == 1) return new int[]{nums[0]};
        int localMax = Integer.MIN_VALUE;
        int[] result = new int[len - k + 1];
        for (int i = 0; i < k; i++) {
        	//找到第一个窗口的最大值
            localMax = max(nums[i], localMax);
        }
        result[0] = localMax;

        for (int i = 1; i < len - k + 1; i++) {
        	//窗口的下一个元素 k=3 , i=1 下一个元素下标为 3
            if (nums[i + k - 1] > localMax) {
            	//判断当前窗口最大值和下一个元素的大小
            	//如果比当前窗口的最大值还要大 就不用找了 就是它了
                localMax = nums[i + k - 1];
            } else if (nums[i - 1] == localMax) {
            	//很不巧，最大值刚好是当前窗口的最左边的元素，也就是马上要超过窗口
                localMax = nums[i];
                //所以就要重新找最大值
                for (int x = i; x < i + k; x++) {
                    localMax = max(nums[x], localMax);
                }
            }
            //copy到结果中
            result[i] = localMax;
        }
        return result;
 	}

 	public static int max(int a,int b){
 		if(a>=b)return a;
 		return b;
 	}


 	public static void printArrays(int []nums){
 		for (int i=0;i<nums.length;i++) {
 			System.out.println(nums[i]);
 		}
 	}

 }