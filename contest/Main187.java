import java.util.*;
import java.util.function.*;
public class Main187{
    public static void main(String[] args) {
        Main187 m=new Main187();
        //m.longestSubarray(new int[]{8,2,4,7},4);
        m.longestSubarray(new int[]{2,4,7,2},5);
    }

    public String destCity(List<List<String>> paths) {
        HashSet<String> set=new HashSet<>();
        for (List<String> lis:paths) {
            set.add(lis.get(0));
        }
        for (List<String> lis:paths) {
            if(!set.contains(lis.get(1))){
                return lis.get(1);
            }
        }
        return "";
    }

    public boolean kLengthApart(int[] nums, int k) {
        int last=-1;
        for (int i=0;i<nums.length;i++) {
            if (nums[i]==1) {
                if (last==-1) {
                    last=i;
                }else{
                    if (i-last-1<k) {
                        return false;
                    }
                    last=i;
                }
            }
        }
        return true;
    }

    //8 2 4 7
    public int longestSubarray2(int[] nums, int limit) {
        if (nums==null || nums.length<=0) {
            return 0;
        }
        int left=0,right=0;
        int min=0,max=0;
        int res=1;
        PriorityQueue<Integer> minpq=new PriorityQueue<>();
        minpq.add(nums[0]);
        PriorityQueue<Integer> maxpq=new PriorityQueue<>((a,b)->b-a);
        maxpq.add(nums[0]);
        //7 2
        while(left<=right && right<nums.length){
            while (right< nums.length && maxpq.peek()-minpq.peek()<=limit) {
                res=Math.max(right-left+1,res);
                right++;
                if (right<nums.length) {
                    maxpq.add(nums[right]);
                    minpq.add(nums[right]);   
                }
            }
            maxpq.remove(nums[left]);
            minpq.remove(nums[left]);
            left++;
        }
        return res;
    }


    public int longestSubarray(int[] nums, int limit) {
        if (nums==null || nums.length<=0) {
            return 0;
        }
        int left=0;
        int min=0,max=0;
        int res=1;
        //单调队列记录区间最值索引
        LinkedList<Integer> maxQue=new LinkedList<>();
        LinkedList<Integer> minQue=new LinkedList<>();
        for(int right=0;right<nums.length;right++){
            while(!maxQue.isEmpty() && nums[maxQue.getLast()]<nums[right]){
                maxQue.removeLast();
            }
            maxQue.addLast(right);
            while(!minQue.isEmpty() && nums[minQue.getLast()]>nums[right]){
                minQue.removeLast();
            }
            minQue.addLast(right);
            max=maxQue.getFirst();
            min=minQue.getFirst();
            if(nums[max]-nums[min]<=limit) {
                res=Math.max(res,right-left+1);
            }else{
                //不符合要求，左边界左移，当左边界是最值的时候que弹出
                if (left==max) maxQue.removeFirst();
                if (left==min) minQue.removeFirst();
                left++;
            }
        }
        return res;
    }

    //同上，只是看见别人这样写的
    public int longestSubarray(int[] nums, int limit) {
        if (nums==null || nums.length<=0) {
            return 0;
        }
        int left=0;
        int min=0,max=0; //[left,right]区间最大/小值
        int res=1;
        LinkedList<Integer> maxQue=new LinkedList<>();
        LinkedList<Integer> minQue=new LinkedList<>();
        for(int right=0;right<nums.length;right++){
            while(!maxQue.isEmpty() && nums[maxQue.getLast()]<nums[right]){
                maxQue.removeLast();
            }
            maxQue.addLast(right);
            while(!minQue.isEmpty() && nums[minQue.getLast()]>nums[right]){
                minQue.removeLast();
            }
            minQue.addLast(right);
            while(!maxQue.isEmpty() && !minQue.isEmpty() && nums[maxQue.getFirst()]-nums[minQue.getFirst()]>limit){
                if (left>=maxQue.getFirst()) {
                    maxQue.removeFirst();
                }
                if (left>=minQue.getFirst()) {
                    minQue.removeFirst();
                }
                left++;
            }
            res=Math.max(res,right-left+1);
        }
        return res;
    }
}