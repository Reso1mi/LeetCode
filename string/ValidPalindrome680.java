public class ValidPalindrome680{
    public static void main(String[] args) {

    }

    // a a a b c b c a a a
    public boolean validPalindrome(String s) {
        if(s==null || s.length()<=0) return true;
        int left=0,right=s.length()-1;
        while(left<right){
            if(s.charAt(left)==s.charAt(right)){
                left++;right--;
            }else{
                return valid(s,left+1,right) || valid(s,left,right-1);
            }
        }
        return true;
    }
    
    public boolean valid(String s,int left,int right){
        while(left<=right){
            if(s.charAt(left)==s.charAt(right)){
                left++;right--;
            }else{
                return false;
            }
        }
        return true;
    }
}