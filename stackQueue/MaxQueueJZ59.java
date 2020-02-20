import java.util.*;
public class MaxQueueJZ59{
    public static void main(String[] args) {

    }

    public MaxQueue() {

    }

    Deque<Integer> queue=new LinkedList<>();

    Deque<Integer> maxQueue=new ArrayDeque<>();

    public int max_value() {
        return maxQueue.isEmpty()?-1:maxQueue.getFirst();
    }

    public void push_back(int value) {
        queue.addLast(value);
        while(!maxQueue.isEmpty() && value>maxQueue.getLast()){
            maxQueue.removeLast();
        }
        maxQueue.addLast(value);
    }

    public int pop_front() {
        if(queue.isEmpty()) return -1;
        int temp=queue.removeFirst();
        if(temp==maxQueue.getFirst()){
            maxQueue.removeFirst();
        }
        return temp;
    }
}