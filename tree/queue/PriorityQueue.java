public class PriorityQueue<E extends Comparable<E>> implements Queue<E>{
    private MaxHeap<E> maxHeap;

    public PriorityQueue(){
        maxHeap=new MaxHeap<>();
    }

    @Override
    public int getSize(){
        return  maxHeap.size();
    }

    @Override
    public boolean isEmpty(){
        return  maxHeap.isEmpty();
    }

    @Override
    public E getFront(){
        return  maxHeap.findMax();
    }

    @Override
    public void enQueue(E e){
        maxHeap.add(e);
    }

    @Override
    public E deQueue(){
        return  maxHeap.popMax();
    }
}