public class ScoreOfParentheses856{
    public static void main(String[] args) {

    }

    public int scoreOfParentheses(String S) {
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='('){
                stack.push(-11111);
            }else{
                //遇到右括号,下面的分支都是处理 ")"
                int top=stack.peek();
                if(top == -11111){ //将 () --> 1
                    stack.pop();
                    stack.push(1);
                }else{
                    int sum=0; //遇到数值了
                    while(!stack.isEmpty()){
                        int temp=stack.pop();
                        //弹出去,直到遇到 "("就*2,其实就是把"(1"-->2
                        if(temp==-11111){ 
                            sum*=2;
                            break;
                        }
                        sum+=temp;
                    }
                    stack.push(sum);
                }
            }
        }
        int res=0;
        while(!stack.isEmpty()) res+=stack.pop();
        return res;
    }

    // (()(())) = 2*()+2*(())= (())+((()))
    public int scoreOfParentheses(String S) {
        int k=0,res=1;
        for (int i=0;i<S.length();i++) {
            if (S.charAt(i)=='(') {
                k++;
            }else{
                k--;
                if (S.charAt(i-1)=='(') {
                    //"()"闭合的时候计算一波
                    res+= 1<<k;
                }
            }
        }
        return res;
    }
}