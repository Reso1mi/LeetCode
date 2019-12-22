public class SequentialDigits1291{
    public static void main(String[] args) {
        
    }

    public List<Integer> sequentialDigits(int low, int high) {
        String slow=String.valueOf(low);
        int slen=slow.length();
        int first=Integer.valueOf(slow.charAt(0))-'0'-1;
        List<Integer> res=new ArrayList<>();
        int start=first,len=slen;
        if(first+len>9){
            start=0;
            len++;
        }
        sequentialDigits(low,high,start,len,res);
        return res;
    }
    
    private String str="123456789";

    public void sequentialDigits(int low,int high,int start,int len,List<Integer> list) {
        if(start+len>9) return;
        int cur=Integer.valueOf(str.substring(start,start+len));
        if(cur>high){
            return;
        }
        if(cur>=low){
            list.add(cur);
        }
        if(start+len==9){
            sequentialDigits(low,high,0,len+1,list);    
        }else{
            sequentialDigits(low,high,start+1,len,list);
        }
    }
}