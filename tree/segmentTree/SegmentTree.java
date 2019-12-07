import java.util.function.*;
public class SegmentTree<E>{
    
    private E[] data;

    private E[] tree;

    private BiFunction<E,E,E> function;

    public SegmentTree(E[] arr,BiFunction<E,E,E> function){
        data = (E[]) new Object[arr.length];
        this.function=function;
        System.arraycopy(arr,0,data,0,arr.length);
        //值得思考为什么是4n
        tree = (E[]) new Object[4*arr.length];
        buildSegmentTree(0,0,arr.length-1);
    }

    //根据传入的BiFuction构建线段树
    private void buildSegmentTree(int index,int left,int right){
        if (left==right) {
            tree[index] =data[right];
            return;
        }
        int leftIndex=leftChild(index);
        int rightIndex=rightChild(index);
        int mid=left+(right-left)/2;
        buildSegmentTree(leftIndex,left,mid);
        buildSegmentTree(rightIndex,mid+1,right);
        //区间数据和,根据业务需求来
        tree[index]=function.apply(tree[leftIndex],tree[rightIndex]);
    }

    public E searchRange(int left,int right){
        return searchRange(0,0,data.length-1,left,right);
    }

    private E searchRange(int rootIndex,int left,int right,int targetLeft,int targetRight){
        if (targetLeft == left && targetRight == right) {
            return tree[rootIndex];
        }
        int mid=left+(right-left)/2;
        //return function.apply(searchRange(leftChild(rootIndex),left,mid,targetLeft,mid),searchRange(rightChild(rootIndex),mid+1,right,mid+1,targetRight));
        if (targetLeft>mid) {
            return searchRange(rightChild(rootIndex),mid+1,right,targetLeft,targetRight);
        }
        if (targetRight<=mid) {
            return searchRange(leftChild(rootIndex),left,mid,targetLeft,targetRight);
        }
        return function.apply(searchRange(leftChild(rootIndex),left,mid,targetLeft,mid),searchRange(rightChild(rootIndex),mid+1,right,mid+1,targetRight));
    }

    public int getSize(){
        return data.length;
    }

    public E get(int index){
        if (index<0 || index>=data.length) {
            throw new IllegalArgumentException("index is illegal!");
        }
        return data[index];
    }

    //左孩子
    private int leftChild(int index){
        return index*2+1;
    }

    //右孩子
    private int rightChild(int index){
        return index*2+2;
    }
    
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append('[');
        for(int i = 0 ; i < tree.length ; i ++){
            if(tree[i] != null)
                res.append(tree[i]);
            else
                res.append("null");

            if(i != tree.length - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }
}