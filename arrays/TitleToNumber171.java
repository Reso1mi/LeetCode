public class TitleToNumber171{
    public static void main(String[] args) {
        TitleToNumber171 t=new TitleToNumber171();
        System.out.println(t.titleToNumber2("10010010101010101011"));
        System.out.println(Integer.valueOf("10010010101010101011",2));
        System.out.println(t.numberToTitle2(993418723));
        System.out.println(Integer.toBinaryString(993418723));

        System.out.println(701%26);
        System.out.println(t.numberToTitle(1));
        System.out.println(t.numberToTitle(26));
        System.out.println(t.numberToTitle(701));
        System.out.println(t.numberToTitle(731));
        System.out.println(t.titleToNumber("ABC"));
    }

    //26进制转10进制
    public int titleToNumber(String s) {
        if(s==null || s.length()<=0) return 0;
        int res=0,n=s.length();
        int temp=1;
        for (int i=n-1;i>=0;i--) {
            res+=(s.charAt(i)-'A'+1)*temp;
            temp*=26;
        }
        return res;
    }

    //10进制转26进制???
    public String numberToTitle(int s) {
        StringBuilder res=new StringBuilder();
        while(s!=0){
            //这个s-1要注意啊woc
            res.append((char)((s-1)%26+65));
            s=(s-1)/26;
        }
        return res.reverse().toString();
    }

    //2进制转10进制
    public int titleToNumber2(String s) {
        if(s==null || s.length()<=0) return 0;
        int res=0,n=s.length();
        int temp=1;
        for (int i=n-1;i>=0;i--) {
            res+=(s.charAt(i)-'0')*temp;
            temp*=2;
        }
        return res;
    }

    //10进制转2进制
    public String numberToTitle2(int s) {
        StringBuilder res=new StringBuilder();
        while(s!=0){
            res.append(s%2);
            s/=2;
        }
        return res.reverse().toString();
    }
}