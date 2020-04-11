public class CheckValidString678{
    public static void main(String[] args) {

    }

    //2020.4.10重写一下
    public boolean checkValidString(String s) {
        Deque<Integer> stack=new ArrayDeque<>();
        Deque<Integer> helpStack=new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }else if(s.charAt(i)==')'){
                if(!stack.isEmpty()){
                    stack.pop();
                }else{
                    if(helpStack.isEmpty()){
                        return false;
                    }
                    helpStack.pop();
                }
            }else{
                helpStack.push(i);
            }
        }
        while(!stack.isEmpty() && !helpStack.isEmpty()){
            if(stack.pop()>helpStack.pop()){
                return false;
            }
        }
        return stack.isEmpty();
    }
}