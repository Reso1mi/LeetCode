public class Queue2Stack225{
    public static void main(String[] args) {

    }

    private ArrayDeque<Integer> queue=null;


    /** Initialize your data structure here. */
    public Queue2Stack225() {
        queue=new ArrayDeque();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        int size=queue.size();
        while(size-- >1){
            queue.add(queue.pop());
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
       return  queue.pop();
    }
    
    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }

/*    //形式上q1是负责进栈 q2负责出栈
    private LinkedList queue1=new LinkedList(); 
    private LinkedList queue2=new LinkedList();

    private  void  add(Object obj){
        queue1.add(obj);
    }

    private Object pop(){
        // q1 ----> q2 留一个
        while(queue1.size()>1){
            queue2.add(queue1.poll());
        }
        //交换q1,q2的引用
        LinkedList temp;
        temp=queue1;
        queue1=queue2;
        queue2=temp;
        return queue2.poll();
    }

    private Object peek(){
        //q1 --->q2 留一个,最后一个不poll,最后poll
        while(queue1.size()>1){
            queue2.add(queue1.poll());
            if(queue1.size()==1){
                queue2.add(queue1.peek());
            }
        }
        //交换q1,q2的引用
        LinkedList temp;
        temp=queue1;
        queue1=queue2;
        queue2=temp;
        return queue2.poll();
    }*/
}