public class AddBinary67{
    public static void main(String[] args) {

    }

    public String addBinary(String a, String b) {
        StringBuilder res=new StringBuilder(); 
        int idxA=a.length()-1;
        int idxB=b.length()-1;
        boolean carry=false;
        //int carry=0;
        while(idxA >=0 || idxB >=0){
            char bina=idxA>=0?a.charAt(idxA):'0';
            char binb=idxB>=0?b.charAt(idxB):'0';
            if(bina == '1' && binb =='1'){
                res.append(carry?1:0);
                carry=true;
            }else if((bina == '1' && binb =='0') ||(bina == '0' && binb =='1')){
                res.append(carry?0:1);
            }else{
                res.append(carry?1:0);
                carry=false;
            }
            idxA--;idxB--;
        }
        if(carry) res.append(1);
        return res.reverse().toString();
    }

    //上面的解法是完全的模拟解法，不够优雅
    public String addBinary(String a, String b) {
        StringBuilder res=new StringBuilder(); 
        int idxA=a.length()-1;
        int idxB=b.length()-1;
        int carry=0;
        while(idxA >=0 || idxB >=0){
            int sum=carry;
            sum+=idxA>=0?a.charAt(idxA)-48:0;
            sum+=idxB>=0?b.charAt(idxB)-48:0;
            res.append(sum%2);
            carry=sum/2;
            idxA--;idxB--;
        }
        if(carry==1) res.append(1);
        return res.reverse().toString();
    }
}