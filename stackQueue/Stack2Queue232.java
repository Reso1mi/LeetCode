import java.util.*;
public class Stack2Queue232{
    public static void main(String[] args) {

    }

    Stack<Integer> stack1=null;

    Stack<Integer> stack2=null;
    /** Initialize your data structure here. */
    public Stack2Queue232() {
        stack1=new Stack<>();
        stack2=new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        s2s();
        return stack2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        s2s();
        return stack2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack2.isEmpty() && stack1.isEmpty();
    }

    private void s2s(){
        if (stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }     
    }
}
