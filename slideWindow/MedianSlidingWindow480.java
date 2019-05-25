import java.util.*;


public class MedianSlidingWindow480{
	

	public static void main(String[] args) {
		int []nums={1,3,-1,-3,5,3,6,7};
		double[] res= medianSlidingWindow2(nums,3);
		for (int i=0;i<res.length;i++) {
			System.out.println(res[i]);
		}
	}

	/*
	窗口位置                      中位数
	---------------               -----
   [1  3  -1] -3  5  3  6  7       1
 	1 [3  -1  -3] 5  3  6  7       -1
 	1  3 [-1  -3  5] 3  6  7       -1
 	1  3  -1 [-3  5  3] 6  7       3
 	1  3  -1  -3 [5  3  6] 7       5
 	1  3  -1  -3  5 [3  6  7]      6

	 */

		//之前的那一题是最大值，这一题是中位数
 	public static double[] medianSlidingWindow(int[] nums, int k) {
	 		//看了一圈评论区，大概知道思路了，还是要排序
	 		//List<Integer> list=new ArrayList<>(); 用链表还是不方便啊
 			int [] queue=new int[k];
	 		int head=0,tail=k-1; //头尾
	 		double [] res=new double[nums.length-k+1];
	 		for (int i=0;i<k;i++) {
	 			queue[i]=nums[i];
	 		}
	 		Arrays.sort(queue);
	 		printArray(queue);
	 		if (k%2==0) {
	 			res[0]=queue[(k-1)/2]/2.0+queue[(k-1)/2+1]/2.0; //注意除小数 .。。。。这里的测试用例Integer最大值，直接相加/2会越界
	 		}else {
	 			res[0]=queue[k/2];
	 		}

	 		for (int i=k;i<nums.length;i++) {
	 			//插入之前要移除上一次的头元素，这里用数组不好搞啊啊
	 			//System.out.println(nums[i-k]);
	 			deleHead(queue,nums[i-k]); 
	 			tail--;
	 			//printArray(queue);
	 			//二分找插入点
	 			int index=binarySearch(queue,0,tail,nums[i]);
	 			System.out.println(index);
	 			tail++; //插入元素，tail++;
	 			for (int j=tail;j>index;j--) { //后一个等于前一个，给插入的元素腾出位置
	 				queue[j]=queue[j-1];
	 			}
	 			queue[index]=nums[i];
	 			//求中点
	 			if (k%2==0) {
	 				res[i-k+1]=queue[head+(tail-head)/2]/2.0+queue[head+(tail-head)/2+1]/2.0;
	 			}else {
	 				res[i-k+1]=queue[head+(tail-head)/2];
	 			}
	 		}
	 		return res;
	 	}


	 	public static void deleHead(int []nums,int target){
	 		for (int j=0,i=0;j<nums.length;j++,i++) {
	 			if(nums[j]==target){
	 				if (i==nums.length-1) {
	 					return;
	 				}
	 				while(i<nums.length-1){
	 					nums[i]=nums[i+1];
	 					i++;
	 				}
	 				return;
	 			}
	 		}
	 	}

	 	public static double[] medianSlidingWindow2(int[] nums, int k) {
	 		//看了一圈评论区，大概知道思路了，还是要排序
	 		List<Integer> list=new ArrayList<>();
	 		int head=0,tail=k-1; //头尾
	 		double [] res=new double[nums.length-k+1];
	 		//Arrays.sort(nums,0,k);
	 		int []temp=new int[k];
	 		for (int i=0;i<k;i++) {
	 			temp[i]=nums[i];
	 		}
	 		Arrays.sort(temp);
	 		for (int i=0;i<k;i++) {
	 			list.add(temp[i]);
	 		}

	 		if (k%2==0) {
	 			res[0]=list.get((k-1)/2)/2.0+list.get((k-1)/2+1)/2.0;
	 		}else {
	 			res[0]=list.get(k/2);
	 		}

	 		for (int i=k;i<nums.length;i++) {
	 			//插入之前要移除上一次的头元素，这里用数组不好搞啊啊
	 			//list.remove((Object)nums[i-k]); 
	 			int dele=binarySearch(list,0,k-1,nums[i-k]);
	 			list.remove(dele);
	 			//System.out.println(list);
	 			//二分找插入点，找的区间为 [i-k+1, i-1]
	 			//int head=i-k+1,tail=i-1;
	 			int index=binarySearch(list,0,k-2,nums[i]);
	 			System.out.println(index);
	 			list.add(-1);
	 			for (int j=k-1;j>index;j--) { //后一个等于前一个，给插入的元素腾出位置
	 				list.set(j,list.get(j-1));
	 			}
	 			list.set(index,nums[i]);
	 			System.out.println(list);
	 			//求中点
	 			if (k%2==0) {
	 				res[i-k+1]=list.get((k-1)/2) / 2.0 + list.get((k-1)/2+1)/2.0;
	 			}else {
	 				res[i-k+1]=list.get(k/2);
	 			}
	 		}
	 		return res;
	 	}

	 	public  static int binarySearch(int []nums,int lo,int hi,int target){
	 		while(lo<=hi){
	 			int mid=lo+(hi-lo)/2;
	 			if(nums[mid]<target){
	 				lo=mid+1;
	 			}else if(nums[mid]>target){
	 				hi=mid-1;
	 			}else{
	 				return mid;
	 			}
	 		}
	 		return lo;
	 	}

	 	public  static int binarySearch(List<Integer> list,int lo,int hi,int target){
	 		while(lo<=hi){
	 			int mid=lo+(hi-lo)/2;
	 			if(list.get(mid)<target){
	 				lo=mid+1;
	 			}else if(list.get(mid)>target){
	 				hi=mid-1;
	 			}else{
	 				return mid;
	 			}
	 		}
	 		return lo;
	 	}


	 	public static void printArray(int [] arr) {
	 		if (arr == null) {
	 			return;
	 		}
	 		for (int i = 0; i < arr.length; i++) {
	 			System.out.print(arr[i] + " ");
	 		}
	 		System.out.println();
	 	}
	 }