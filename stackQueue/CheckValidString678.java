public class CheckValidString678{
    public static void main(String[] args) {

    }

    public boolean checkValidString(String s) {
        Stack<Integer> bracketStack=new Stack<>();
        Stack<Integer> starStack=new Stack<>();
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i)=='(') {
                bracketStack.push(i);
            }else if(s.charAt(i)=='*'){
                starStack.push(i);
            }else{
                if (bracketStack.isEmpty()) {
                    if (starStack.isEmpty()) {
                        return false;
                    }
                    starStack.pop();
                }else{
                    bracketStack.pop();
                }
            }
        }
        //消除左括号
        while(!starStack.isEmpty() && !bracketStack.isEmpty()){
            if(starStack.peek()>bracketStack.peek()){
                bracketStack.pop();
            }
            starStack.pop();
        }
        return bracketStack.isEmpty();
    }
}