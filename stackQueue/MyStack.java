public class MyStack<T>{

    T [] objValues=null;

    int top=-1;

    public MyStack(int size){
        objValues= (T[]) new Object[size];
    }

    public void push(T obj){
        objValues[++top]=obj;
    }

    public T peek(){
        if (top<0) {
            throw new RuntimeException("stack is isEmpty");
        }
        return objValues[top];
    }

    public T pop(){
        if (top<0) {
            throw new RuntimeException("stack is isEmpty");
        }
        //覆盖
        return objValues[top--];
    }

    public T get(int index){
        if (index>top || index < 0) {
            throw new RuntimeException("index is wrong");
        }
        return objValues[index];
    }

    public boolean isEmpty(){
        return top<0;
    }

    public int size(){
        return top+1;
    }
}