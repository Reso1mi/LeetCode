public class MaxHeap<E extends Comparable<E>>{
    private Array<E> data;

    public MaxHeap(int capacity){
        data=new Array<>(capacity);
    }

    public MaxHeap(){
        data=new Array<>();
    }

    public int size(){
        return data.getSize();
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    //父节点
    private int parent(int index){
        if (index==0) {
            throw new IllegalArgumentException("index 0 don't have parent");
        }
        return (index-1)/2;
    }

    //左孩子
    private int leftChild(int index){
        return index*2+1;
    }

    //右孩子
    private int rightChild(int index){
        return index*2+2;
    }

    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize()-1);
    }

    //上浮
    private void siftUp(int cur){
        while(cur>0 && data.get(parent(cur)).compareTo(data.get(cur)) < 0){
            data.swap(cur,parent(cur));
            cur=parent(cur);
        }
    }

    public E findMax(){
        if (data.getSize()==0) {
            throw new IllegalArgumentException("heap is empty !!!");
        }
        return  data.get(0);
    }

    public E popMax(){
        if (data.getSize()==0) {
            throw new IllegalArgumentException("heap is empty !!!");
        }
        E res=findMax();
        data.swap(0,data.getSize()-1);
        data.removeLast();
        siftDown(0);
        return res;
    }    

    private void siftDown(int cur){
        while(leftChild(cur)<data.getSize()){ //有左孩子
            int large=leftChild(cur);
            //如果也有右孩子,就比较下两个节点的值取最大值
            if (large+1<data.getSize() && data.get(large).compareTo(data.get(large+1))<0) {
                large=large+1;
            }
            //比左右孩子都大就直接结束了
            if (data.get(large).compareTo(data.get(cur))<=0){
                return;
            }
            data.swap(large,cur);
            cur=large;
        }
    }
}