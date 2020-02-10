public class RemoveInvalidParentheses301{
    public static void main(String[] args) {
        
    }

    public List<String> removeInvalidParentheses(String s) {
        int left=0,right=0;
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i)=='(') {
                left++;
            }else if (s.charAt(i)==')') {
                if (left>0) {
                    left--;
                }else{
                    right++;
                }
            }
        }
        
    }

    public void dfs(){

    }
}