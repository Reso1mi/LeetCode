import java.util.*;
public class DailyTemperatures739{
    
    public static void main(String[] args) {
        
    }

    public int[] dailyTemperatures(int[] T) {
        int[] res=new int[T.length];
        if(T==null || T.length<=0) return res;
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        for (int i=1;i<T.length;i++) {
            while(!stack.isEmpty()&&T[stack.peek()]<T[i]){
                int temp=stack.pop();
                res[temp]=i-temp;
            }
            stack.push(i);
        }
        return res;
    }
}