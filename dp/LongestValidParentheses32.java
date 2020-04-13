public class LongestValidParentheses32{
    public static void main(String[] args) {

    }

    //栈+dp
    public int longestValidParentheses(String s) {
        if (s==null || s.length()<=0) {
            return  0;
        }
        Stack<Integer> stack=new Stack<>();
        int[] dp=new int[s.length()];
        dp[0]=0;
        int res=0;
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i)=='(') {
                stack.push(i);
                dp[i]=0;
            }else{
                if(stack.isEmpty()){
                    dp[i]=0;
                }else{
                    int left=stack.pop();
                    dp[i]= left==0?i-left+1:dp[left-1]+i-left+1;
                    res=Math.max(res,dp[i]);
                }           
            }
        }
        return res;
    }

    public int longestValidParentheses(String s) {
        if (s==null || s.length()<=0) {
            return  0;
        }
        Deque<Integer> stack=new ArrayDeque<>();
        int[] dp=new int[s.length()]; //以i位置括号结尾的最长有效括号
        int res=0;
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i)=='(') {
                stack.push(i);
            }else{
                if(!stack.isEmpty()){
                    int left=stack.pop();
                    dp[i]= left==0?i-left+1:dp[left-1]+i-left+1;
                    res=Math.max(res,dp[i]);
                }
            }
        }
        return res;
    }

    //update: 2020.4.13
    //重写一百年又有了新思路hahaha 其实核心大同小异
    public int longestValidParentheses(String s) {
        if(s==null || s.length()<=0) return 0;
        Deque<Integer> stack=new ArrayDeque<>();
        int[] dp=new int[s.length()];
        int res=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }else{
                if(!stack.isEmpty()){
                    int left=stack.pop();
                    //dp[i]=(left>1?dp[left-1]+dp[i-1]:dp[i-1])+2;
                    dp[i]=dp[i-1]+(left>1?dp[left-1]:0)+2;
                }
                res=Math.max(res,dp[i]);
            }
        }
        return res;
    }

    //纯dp
    public int longestValidParentheses(String s) {
        if (s==null || s.length()<=0) {
            return  0;
        }
        int[] dp=new int[s.length()];
        dp[0]=0;
        int res=0;
        for (int i=1;i<s.length();i++) {
            if (s.charAt(i)==')') {
                if (s.charAt(i-1)=='(') {
                    dp[i]=i-2>=0?dp[i-2]+2:2;
                }else{
                    if (i-dp[i-1]-1>=0 && s.charAt(i-dp[i-1]-1)=='(') {
                        dp[i]=(i-dp[i-1]-2>=0?dp[i-dp[i-1]-2]:0) + dp[i-1]+2; 
                    }
                }
            }
            res=Math.max(res,dp[i]);
        }
        return res;
    }

    public int longestValidParentheses(String s) {
        if (s==null || s.length()<=0) {
            return  0;
        }
        Deque<Integer> stack=new ArrayDeque<>();
        stack.push(-1); //临界点
        int res=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){ 
                    //栈为空,说明当前的')'肯定是不合法的
                    //其实相当于一个分界点,这个位置之前的字符不可能再构成合法的序列了
                    //后面的栈空的时候就不能再根据-1来算长度了,需要一个新的临界点
                    stack.push(i);
                }else{
                    res=Math.max(res,i-stack.peek());
                }
            }
        }
        return res;
    }
}