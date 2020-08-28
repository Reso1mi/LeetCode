public class LongestSubarray5402{
    public static void main(String[] args) {

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

    //同上，和我的写法是一样的，只是看见别人这样写的
    //UPDATE: 2020/6/29 改成最近总结的for-while滑窗模板
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
            while(nums[maxQue.getFirst()]-nums[minQue.getFirst()]>limit) {
                //不符合要求，左边界左移，当左边界是最值的时候que弹出
                if (left==maxQue.getFirst()) maxQue.removeFirst();
                if (left==minQue.getFirst()) minQue.removeFirst();
                left++;
            }
            res=Math.max(res,right-left+1);
        }
        return res;
    }
}