public class ScoreOfParentheses856{
    public static void main(String[] args) {

    }

    public int scoreOfParentheses(String S) {
        Stack<Integer> stack=new Stack<>();
        int res=0;
        for (int i=0;i<S.length();i++) {
            if (S.charAt(i)=='(') {
                stack.push(-1111);
            }else{
                int top=stack.peek();
                if (top==-1111) {
                    stack.pop();
                    stack.push(1);
                }else{ //是数值
                    int sum=0;
                    while(!stack.isEmpty()){
                        int temp=stack.pop();
                        if (temp==-1111) {
                            break;
                        }
                        sum+=temp;
                    }
                    stack.push(2*sum);
                }
            }
        }
        while(!stack.isEmpty()){
            res+=stack.pop();
        }
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