import java.util.*;
public class MedianFinder295{
    public static void main(String[] args) {

    }

    /** initialize your data structure here. */
    PriorityQueue<Integer> minQue=null;

    PriorityQueue<Integer> maxQue=null;

    public MedianFinder295() {
        minQue=new PriorityQueue<>();
        maxQue=new PriorityQueue<>((a,b)->b-a);
    }
    
    public void addNum(int num) {
        minQue.add(num);
        maxQue.add(minQue.poll());
        if(minQue.size()<maxQue.size()){
            minQue.add(maxQue.poll());
        }
    }
    
    public double findMedian() {
        if(minQue.size()==maxQue.size()){
            return (minQue.peek()+maxQue.peek())/2.0;
        }
        return minQue.peek();
    }
}