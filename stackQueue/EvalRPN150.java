public class EvalRPN150{
    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }

    public static int evalRPN(String[] tokens) {
        MyStack<Integer> stack=new MyStack<>(tokens.length);
        for (int i=0;i<tokens.length;i++) {
            if("+".equals(tokens[i])){
                stack.push(stack.pop()+stack.pop());
            } else if("-".equals(tokens[i])){
                int rd1=stack.pop();
                int rd2=stack.pop();
                stack.push(rd2-rd1);
            }else if("*".equals(tokens[i])){
                stack.push(stack.pop()*stack.pop());
            }else if("/".equals(tokens[i])){
                int div1=stack.pop();
                int div2=stack.pop();
                stack.push(div2/div1);
            }else{
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.peek();
    }
}