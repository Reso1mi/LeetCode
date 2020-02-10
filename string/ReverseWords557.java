import java.util.*;
public class ReverseWords557{
    public static void main(String[] args) {

    }

    public String reverseWords(String s) {
        s+=" ";//统一操作
        char[] cs=s.toCharArray();
        int start=0;
        for (int i=0;i<cs.length;i++) {
            if (cs[i]==' ') {
                reverse(cs,start,i-1);
                start=i+1;
            }
        }
        return new String(cs,0,cs.length-1);
    }

    public void reverse(char[] s,int left,int right){
        for (int i=left,j=right;i<j;i++,j--) {
            char temp=s[i];
            s[i]=s[j];
            s[j]=temp;
        }
    }
}