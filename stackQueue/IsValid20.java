import java.util.*;
public class IsValid20{
    public static void main(String[] args) {

    }

    public boolean isValid2(String s) {
        if(s.length()<=0){
            return true;
        }
        Stack<Character> stack=new Stack();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
                stack.push(s.charAt(i));
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char p=s.charAt(i);
                if( (p==')' && stack.pop()!='(') || (p==']' && stack.pop()!='[') || (p=='}' && stack.pop()!='{')){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid(String s) {
        if(s.length()<=0){
            return true;
        }
        MyStack<Character> stack=new MyStack<>(s.length());
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
                stack.push(s.charAt(i));
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char p=s.charAt(i);
                if( (p==')' && stack.pop()!='(') || (p==']' && stack.pop()!='[') || (p=='}' && stack.pop()!='{')){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}