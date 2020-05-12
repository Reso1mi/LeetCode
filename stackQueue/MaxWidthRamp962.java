public class MaxWidthRamp962{

    //很巧妙的解法，和以往的单调栈不太一样
    public int maxWidthRamp(int[] A) {
        Deque<Integer> stack=new ArrayDeque<>();
        int res=0;
        for(int i=0;i<A.length;i++){
            if(stack.isEmpty() || A[stack.peek()]>=A[i]){
                stack.push(i);
            }
        }
        for(int i=A.length-1;i>=0;i--){
            while(!stack.isEmpty() && A[stack.peek()]<=A[i]){
                int cur=stack.pop();
                res=Math.max(res,i-cur);
            }
        }
        return res;
    }
}