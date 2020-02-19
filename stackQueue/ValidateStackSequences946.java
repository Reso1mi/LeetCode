import java.util.*;
public class ValidateStackSequences946{
    public static void main(String[] args) {

    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed==null || pushed.length<=0) return true;
        Deque<Integer> stack=new ArrayDeque<>();
        int popIndex=0;
        int pushIndex=0;
        //pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
        //[1,2,3,4,5]      [4,3,5,1,2]
        //[1,0] [1,0]
        while(pushIndex<pushed.length){
            stack.push(pushed[pushIndex++]);
            while(!stack.isEmpty()&&popped[popIndex]==stack.peek()){
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }
}