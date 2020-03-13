import java.util.*;
public class ReverseWords151{
    public static void main(String[] args) {

    }

    //。。。api做法
    public String reverseWords2(String s) {
        if(s==null || s.length()<=0) return s;
        String[] ws=s.split(" ");
        StringBuilder sb=new StringBuilder();
        for(int i=ws.length-1;i>=0;i--){
            if(" ".equals(ws[i]) || "".equals(ws[i])) continue;
            sb.append(ws[i]+" ");
            
        }
        return sb.length()==0?sb.toString():sb.substring(0,sb.length()-1).toString();
    }

    public String reverseWords(String s) {
        if(s==null || s.length()<=0) return "";
        Deque<String> stack=new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                continue;
            }
            int j=i;
            while(i<s.length() && s.charAt(i)!=' '){
                i++;
            }
            stack.push(s.substring(j,i));
        }
        if(stack.isEmpty()) return "";
        StringBuilder sb=new StringBuilder();
        sb.append(stack.pop());
        while(!stack.isEmpty()){
            sb.append(" "+stack.pop());
        }
        return sb.toString();
    }
}