import java.util.*;

public class MinStack155 {

    /** initialize your data structure here. */
    private Stack<Integer> stack=null;

    private Stack<Integer> helpStack=null;

    public MinStack155() {
        stack=new Stack<>();
        helpStack=new Stack<>();
    }
    
    /*  
    public void push(int x) {
        stack.push(x);
        if (helpStack.isEmpty()) {
            helpStack.push(x);
        }else{
            if (helpStack.peek()>x) {
                helpStack.push(x);
            }else{
                helpStack.push(helpStack.peek());
            }
        }
    }
    */

    public void push(int x) {
        stack.push(x);
        if (helpStack.isEmpty()) {
            helpStack.push(x);
        }else if (x<=helpStack.peek()) {
            //相等的也要入栈,不然不好控制后面出栈
            helpStack.push(x);
        }
    }
    
    public void pop() {
        int top=stack.pop();
        if(top==helpStack.peek()){
            helpStack.pop();
        }
        /*
        if(stack.pop()==helpStack.peek()){
            helpStack.pop();
        }*/
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return helpStack.peek();
    }
}