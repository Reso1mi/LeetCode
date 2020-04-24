public class ConvertToTitle168{
    public static void main(String[] args) {
        
    }

    public String numberToTitle(int s) {
        StringBuilder res=new StringBuilder();
        while(s!=0){
            //这个s-1要注意啊woc
            res.append((char)((s-1)%26+65));
            s=(s-1)/26;
        }
        return res.reverse().toString();
    }
}