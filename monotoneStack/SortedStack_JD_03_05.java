//面试题 03.05. 栈排序
public class SortedStack_JD_03_05 {
    
    Deque<Integer> stack = null;
    
    Deque<Integer> help = null;
    //单调栈排序
    //4 3 2 1 3 4 2
    public SortedStack() {
        stack = new ArrayDeque<>();
        help = new ArrayDeque<>();
    }
    
    public void push(int val) {
        //一开始写成pop了找半天的错
        while(!stack.isEmpty() && stack.peek() < val) {
            help.push(stack.pop());
        }
        stack.push(val);
        //再装回去
        while(!help.isEmpty()) {
            stack.push(help.pop());
        }
    }
    
    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
        }
    }
    
    public int peek() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek();
    }
    
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}