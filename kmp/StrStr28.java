public class StrStr28{
    public static void main(String[] args) {

    }

    public int strStr(String haystack, String needle) {
        if(needle==null || needle.length()<=0) return 0;
        if(haystack==null ||haystack.length()<=0) return -1;
        int[] next=getNext(needle);
        int tidx=0,sidx=0;
        while (sidx<haystack.length() && tidx<needle.length()) {
            if(needle.charAt(tidx) == haystack.charAt(sidx)){
                tidx++;sidx++;
                if(tidx==needle.length()){
                    return sidx-tidx;
                }
            }else if(next[tidx]==-1){
                //完全失配sidx需要后移
                sidx++;
            }else{
                tidx=next[tidx];
            }
        }
        return -1;
    }

    //求t的next
    //abadabac
    //ac
    public int[] getNext(String t){
        int[] next= new int[t.length()];
        next[0]=-1;
        if(t.length()<=1) return next;
        next[1]=0;
        int left=0,right=2;
        while(right<t.length()){
            if(t.charAt(left)==t.charAt(right-1)){
                left++;
                next[right++]=left;
            }else if(left<=0){
                next[right++]=0;
            }else{
                left=next[left];
            }
        }
        return next;
    }
}