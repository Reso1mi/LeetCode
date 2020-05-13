public class RepeatedSubstringPattern459{
    public static void main(String[] args) {

    }

    //20ms，做复杂了，构造了一个s+s然后去掉头，再在里面kmp找
    public boolean repeatedSubstringPattern(String s) {
        if(s==null || s.length()<=0) return false;
        String t=s+s;
        int[] next=getNext(s);
        int i=0,j=1;
        while(i<s.length() && j<t.length()){
            if(s.charAt(i)==t.charAt(j)){
                i++;j++;
            }else if(next[i]==-1){
                j++;
            }else{
                i=next[i];
            }
        }
        return j-i!=s.length();
    }
    
    public int[] getNext(String s){
        if(s.length()==1){
            return new int[]{-1};
        }
        int[] next=new int[s.length()];
        next[0]=-1;
        next[1]=0;
        int left=0,right=2; 
        while(right<s.length()){
            if(s.charAt(left)==s.charAt(right-1)){
                next[right++]=++left;
            }else if(left<=0){
                next[right++]=0;
            }else{
                left=next[left];
            }
        }
        return next;
    }


    //优化后9ms，也是个结论
    //   s:  a b a b \0
    //next: -1 0 0 1  2
    //   s:  a b c a b c a b c a b c \0
    //next: -1 0 0 0 1 2 3 4 5 6 7 8  9
    //   s:  a a b a b d \0
    //next: -1 0 1 0 1 0  0
    //   s:  a b a c \0
    //next: -1 0 0 1 0
    //   s:  a b c d a b \0
    //next: -1 0 0 0 0 1 2 
    public boolean repeatedSubstringPattern(String s) {
        if(s==null || s.length()<=1) return false;
        int[] next=getNext(s);
        int replen=s.length()-next[s.length()];
        return s.length()%replen==0;
    }

    public int[] getNext(String s){
        if(s.length()==1){
            return new int[]{-1};
        }
        int[] next=new int[s.length()+1];
        next[0]=-1;
        next[1]=0;
        int left=0,right=2; 
        while(right<=s.length()){
            if(s.charAt(left)==s.charAt(right-1)){
                next[right++]=++left;
            }else if(left<=0){
                next[right++]=0;
            }else{
                left=next[left];
            }
        }
        return next;
    }
}