import java.util.*;
public class DecodeString394{
    public static void main(String[] args) {

    }

    /*
    s = "3[a]2[bc]", 返回 "aaabcbc".
    s = "3[a2[c]]", 返回 "accaccacc".
    s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
     */
    //留下来好好反思下为什么这样写是错的！！！！！
    public String decodeStringWrong(String s) {
        StringBuilder sb=new StringBuilder(s);
        Stack<Integer>  stack=new Stack<>();
        for (int i=0;i<sb.length();i++) {
            if (sb.charAt(i)=='[') {
                stack.push(i);
            }else if(sb.charAt(i)==']'){
                int left=stack.pop();
                String temp=sb.substring(left+1,i);
                int repeat=sb.charAt(left-1)-'0';
                sb.delete(left-1,Math.min(i+1,sb.length()));
                for (int j=0;j<repeat;j++) {
                    sb.insert(left-1,temp);
                }
            }
        }
        return sb.toString();
    }

    public String decodeString(String s) {
        if (s==null || s.length()<=0) {
            return "";
        }
        StringBuilder sb=new StringBuilder(s);
        Stack<Integer>  stack=new Stack<>();
        int i=0;
        while(i<sb.length()) {
            if (sb.charAt(i)=='[') {
                stack.push(i);
            }else if(sb.charAt(i)==']'){
                int left=stack.pop();
                String temp=sb.substring(left+1,i);
                int preInt=left;
                while(preInt-1>=0 && sb.charAt(preInt-1)>='0' && sb.charAt(preInt-1) <='9'){
                    preInt--;
                }
                int repeat=Integer.valueOf(sb.substring(preInt,left));
                sb.delete(preInt,Math.min(i+1,sb.length()));
                for (int j=0;j<repeat;j++) {
                    sb.insert(preInt,temp);
                }
                i=preInt+(repeat*temp.length())-1;
            }
            i++;
        }
        return sb.toString();
    }
}