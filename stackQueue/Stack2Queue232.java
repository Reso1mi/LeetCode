import java.util.*;
public class Stack2Queue232{
    public static void main(String[] args) {

    }

    Stack<Integer> inStack=null;

    Stack<Integer> outStack=null;
    /** Initialize your data structure here. */
    public Stack2Queue232() {
        inStack=new Stack<>();
        outStack=new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        inStack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        s2s();
        return outStack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        s2s();
        return outStack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return outStack.isEmpty() && inStack.isEmpty();
    }

    private void s2s(){
        if (outStack.isEmpty()) {
            while(!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }     
    }
}
