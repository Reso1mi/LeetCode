import java.util.*;
public class StockSpanner901{
    public static void main(String[] args) {

    }
}
class StockSpanner {

    Deque<int[]> stack=new ArrayDeque<>();

    public StockSpanner() {}
    
    public int next(int price) {
        int res=1;
        while(!stack.isEmpty() && price>=stack.peek()[0]){
            res+=stack.pop()[1];
        }
        stack.push(new int[]{price,res});
        return res;
    }
}