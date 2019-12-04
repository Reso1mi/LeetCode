import java.util.*;
public class NextGreaterElements503{
    public static void main(String[] args) {

        int []a=nextGreaterElements(new int[]{3,1,2});
        for (int i=0;i<a.length;i++) {
            System.out.println(a[i]);
        }
    }

    //todo 没有优化的憨憨做法
    public static int[] nextGreaterElements(int[] nums) {
        if (nums==null || nums.length<=0) {
            return new int[]{};
        }
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        int[] loopNums=new int[nums.length*2];
        int[] res=new int[nums.length];
        int maxIndex=0;
        System.arraycopy(nums,0,loopNums,0,nums.length);
        System.arraycopy(nums,0,loopNums,nums.length,nums.length);
        for (int i=1;i<loopNums.length;i++) {
            maxIndex=loopNums[i]>loopNums[maxIndex]?i:maxIndex;
            while(!stack.isEmpty()&&loopNums[stack.peek()]<loopNums[i]) {
                res[stack.pop()%nums.length]=loopNums[i];
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int temp=stack.pop()%nums.length;
            if (nums[temp]==nums[maxIndex]) {
                res[temp]=-1;   
            }
        }
        return res;
    }

    //1 2 -1 3 1 2 -1 3
/*    public int[] nextGreaterElements(int[] nums) {
        if (nums==null || nums.length<=0) {
            return null;
        }
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        int[] res=new int[nums.length];
        for (int i=0;i<nums.length;i++) {
            while(!stack.isEmpty()&&) {
                
            }
            stack.push(i);

        }
        return res;
    }*/
}