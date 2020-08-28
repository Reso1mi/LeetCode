public class LongestWPI1124{

    //前缀和+单调栈
    //hours:  0 1 1 -1 -1 -1 -1  1
    //  pre:  0 1 2  1  0 -1 -2 -1
    public int longestWPI(int[] hours) {
        int[] pre=new int[hours.length+1];
        for(int i=1;i<=hours.length;i++){
            pre[i]=pre[i-1]+(hours[i-1]>8?1:-1);
        }
        Deque<Integer> stack=new ArrayDeque<>();
        for(int i=0;i<pre.length;i++){
            if(stack.isEmpty() || pre[i]<pre[stack.peek()]){
                stack.push(i);
            }
        }
        int res=0;
        for(int i=pre.length-1;i>=0;i--){
            while(!stack.isEmpty() && pre[i]-pre[stack.peek()]>0){
                res=Math.max(res,i-stack.pop()); //不用+1
            }
        }
        return res;
    }

}