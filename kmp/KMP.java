public class KMP{
    public static void main(String[] args) {
        KMP k=new KMP();
        System.out.println(k.kmp("ll","hello"));
        System.out.println(k.kmp("a","a"));
        System.out.println(k.kmp("aaa","abadabac"));
        System.out.println(k.kmp("acac","acabacac"));
    }

    //判断t在s中的位置
    public int kmp(String t,String s){ 
        int[] next=getNext(t);
        int tidx=0,sidx=0;
        while (sidx<s.length() && tidx<t.length()) {
            if(t.charAt(tidx) == s.charAt(sidx)){
                tidx++;sidx++;
                if(tidx==t.length()){
                    return sidx-tidx;
                }
            }else if(next[tidx]==-1){
                //完全失配sidx需要后移
                //只有tidx==0才会发生，所以设置-1其实是为了让sidx能单独移动
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