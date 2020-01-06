public class AddStrings415{
    public static void main(String[] args) {

    }

    public String addStrings(String num1, String num2) {
        StringBuilder sb=new StringBuilder();
        int m=num1.length()-1;
        int n=num2.length()-1;
        int carry=0;
        while(n>=0 || m>=0){
            int a= m>=0?num1.charAt(m)-48:0;
            int b= n>=0?num2.charAt(n)-48:0;
            int sum=a+b+carry;
            carry=sum/10;
            sb.append(sum%10);
            m--;n--;
        }
        if (carry==1) {
            sb.append("1");
        }
        return sb.reverse().toString();
    }
}