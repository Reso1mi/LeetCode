import java.util.*;
public class MinStack155_2{
    /** initialize your data structure here. */
    private Stack<Integer> stack=null;

    private int min=0;

    public MinStack155_2() {
        stack=new Stack<>();
    }
    
    public void push(int x) {
        if (stack.isEmpty()) {
            min=x;
            stack.push(0);
        }else{
            int diff=x-min;
            min=diff>0?min:x;
            stack.push(diff);
        }
    }
    
    public void pop() {
        int diff=stack.pop();
        //小于等于0说明 min就是当前真实的栈顶元素,也就是说 min-minPre=diff
        min=diff<=0?min-diff:min;
    }
    
    public int top() {
        int diff=stack.peek();
        return diff<=0?min:diff-min;
    }
    
    public int getMin() {
        return min;
    }
}