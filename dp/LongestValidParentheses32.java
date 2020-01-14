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
        Stack<Integer> stack=new Stack<>();
        int[] dp=new int[s.length()]; //以i位置括号结尾的最长有效括号
        dp[0]=0;
        int res=0;
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i)=='(') {
                stack.push(i); //dp[i]=0
            }else{
                if(!stack.isEmpty()){
                    int left=stack.pop();
                    dp[i]= left==0?i-left+1:dp[left-1]+i-left+1;
                    res=Math.max(res,dp[i]);
                }//else dp[i]=0  
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
}