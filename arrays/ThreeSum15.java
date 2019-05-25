import java.util.*;
public class ThreeSum15{

	public static void main(String[] args) {
		int []num={-1,0,1,2,-1,-4};

		System.out.println(threeSum(num));
		printArray(num);
	}


	/**
	 * 
	 * @param  nums [description]
	 * @return      [description]
	 *  [-1, 0, 1, 2, -1, -4]
	 *  [-4, -1, -1, 0, 1, 2]
	 */
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> list=new ArrayList<>();
		int len=nums.length;
		//先将数据排个序，这里为了回顾常见的排序，手写三向切分的快排
		quickSort(nums,0,len-1);
		//找到正负的界限
		int z=0,f=0;
		for (int i=0;i<len;i++) {
			if(nums[i]>=0){
				z=i;
				break;
			}
		}
		f=z-1;
		//System.out.println(f+","+z);
		if(z==0){
			return null;
		}

		int zf=0;
		while(z<len && f>=0){
			if(nums[z]+nums[f]+zf>0){
				zf=nums[f--];
			}else if(nums[z]+nums[f]+zf<0){
				zf=nums[z++];
			}else if(nums[z]+nums[f]+zf==0){
				//有问题
				System.out.println(zf);
				List<Integer> list2=new ArrayList<>();
				list2.add(nums[z]);
				list2.add(nums[f]);
				list2.add(zf);
				list.add(list2);
				--f;
				++z;
				zf=0;
			}
		}
		return list;
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> list = new ArrayList();
        Arrays.sort(nums);                                  // 先排序  o(nlogn)
        int len = nums.length;
        if(nums == null || len < 3) return list;    // 完备性
        for (int i = 0; i < len-2; i++) {
        	if(nums[i]>0){
        		break;
        	}
        	//遍历数组
            if(i > 0 && nums[i] == nums[i-1]) continue;    // 一次去重优化
            //当前元素的下一个元素。
            int L = i+1; 
            //尾元素
            int R = len-1;
            while(L<R){
            	int sum = nums[i] + nums[L] + nums[R];
            	if(sum == 0){
            		list.add(Arrays.asList(nums[i],nums[L],nums[R]));
            		//-4 -1 -1 0 1 2
                    while (L<R && nums[L] == nums[L+1]) L++; //###二次去重优化
                    while (L<R && nums[R] == nums[R-1]) R--;
                    L++;
                    R--;
                }
                else if (sum < 0) L++; //小于0所以要增大L,逼近0
                else R--;  //大于0就，减小R
            }
        }        
        return list;
    }



    public static void quickSort(int []nums,int l,int r){
    	if(l>=r){
    		return;
    	}
		//取一个随机的元素和最后一个交换，随机划分切分点
		//返回相等的区间
    	swap(nums,l+(int)(Math.random()*(r-l+1)),r);
    	int []equals=partion(nums,l,r);
    	quickSort(nums,l,equals[0]-1);
    	quickSort(nums,equals[1]+1,r);
    }

    private static int[] partion(int []nums,int l,int r){
		//小于区为空
    	int less=l-1;
        //l ----> more 为待定区
    	int more=r;
		//基准元素
    	int base=nums[r];
    	while(l<more){
    		if(nums[l]<base){
				//注意这里
    			swap(nums,++less,l++);
    		}else if (nums[l]>base) {
				//这里l不要++，从待定区换过来的不一定是小于base的，需要二次判断
    			swap(nums,--more,l);
    		}else{
    			l++;
    		}
    	}
    	swap(nums,r,more);
    	return new int[]{less+1,more};
    }

    public static void swap(int []nums,int a,int b){
    	int temp=nums[a];
    	nums[a]=nums[b];
    	nums[b]=temp;
    }

		// for test
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