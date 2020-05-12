public class ShortestSeqLCCI17_18{
    public static void main(String[] args) {

    }

    //没啥好说的，套模板就行了
    public int[] shortestSeq(int[] big, int[] small) {
        if(big==null || big.length<=0) {
            return new int[0];
        }
        int slen=small.length;
        int blen=big.length;
        int[] res=new int[2];
        res[0]=-1;res[1]=-1;
        int min=Integer.MAX_VALUE;
        HashSet<Integer> set=new HashSet<>();
        for(int i:small) set.add(i);
        HashMap<Integer,Integer> window=new HashMap<>();
        int match=0;
        int left=0;
        for(int right=0;right<blen;right++){
            int wr=big[right];
            if(set.contains(wr)){
                window.put(wr,window.getOrDefault(wr,0)+1);
                if(window.get(wr)==1){
                    match++;
                }
            }
            while(match==slen){
                if(right-left+1<min){
                    res[0]=left;
                    res[1]=right;
                    min=right-left+1;
                }
                int wl=big[left];
                if(set.contains(wl)){
                    window.put(wl,window.get(wl)-1);
                    if(window.get(wl)==0){
                        match--;
                    }
                }
                left++;
            }
        }
        return res[0]==-1?new int[0]:res;
    }
}