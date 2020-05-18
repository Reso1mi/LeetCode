public class ShortestPalindrome214{
    public static void main(String[] args) {

    }

    //a a c e c a a a # a a a c e c a a
    //a b c d # d c b a
    public String shortestPalindrome(String s) {
        String rs=new StringBuilder(s).reverse().toString();
        //#是为了避免前后缀过长超过原字符s的长度，比如aaaaaaa这种
        String t=s+"#"+rs; 
        int[] next=new int[t.length()+1];
        next[0]=-1;
        next[1]=0;
        int left=0;
        int i=2;
        while(i<=t.length()){
            if(t.charAt(i-1)==t.charAt(left)){
                next[i++]=++left;
            }else if(next[left]==-1){
                next[i++]=0;
            }else{
                left=next[left];
            }
        }
        //System.out.println(next[t.length()]);
        return rs.substring(0,s.length()-next[t.length()])+s;
    }
}