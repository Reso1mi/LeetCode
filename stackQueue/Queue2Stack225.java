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

/*   //形式上q1是负责进栈 q2负责出栈
    private LinkedList inQueue=new LinkedList(); 
    private LinkedList outQueue=new LinkedList();

    private  void  add(Object obj){
        inQueue.add(obj);
    }

    private Object pop(){
        // q1 ----> q2 留一个
        while(inQueue.size()>1){
            outQueue.add(inQueue.poll());
        }
        //交换q1,q2的引用
        LinkedList temp;
        temp=inQueue;
        inQueue=outQueue;
        outQueue=temp;
        return outQueue.poll();
    }

    private Object peek(){
        //q1 --->q2 留一个,最后一个不poll,最后poll
        while(inQueue.size()>1){
            outQueue.add(inQueue.poll());
            if(inQueue.size()==1){
                outQueue.add(inQueue.peek());
            }
        }
        //交换q1,q2的引用
        LinkedList temp;
        temp=inQueue;
        inQueue=outQueue;
        outQueue=temp;
        return outQueue.poll();
    }*/
}