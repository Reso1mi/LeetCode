import java.util.*;


public class NC560Typing {
    /**
     * 
     * @param s string字符串 
     * @return string字符串
     */
    //acw<<ca<<<
    public String Typing (String s) {
        // write code here
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '<') {
                if (stack.isEmpty()) {
                    continue;
                }
                stack.pop();
            }else{
                stack.push(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(s.charAt(stack.pop()));
        }
        return sb.reverse().toString();
    }
}