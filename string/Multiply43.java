public class Multiply43{
    public static void main(String[] args) {

    }

    public static String multiply(String num1, String num2) {
        /**
        num1的第i位(高位从0开始)和num2的第j位相乘的结果在乘积中的位置是[i+j, i+j+1]
        例: 123 * 45,  123的第1位 2 和45的第0位 4 乘积 08 存放在结果的第[1, 2]位中
          index:    0 1 2 3 4  
              
                        1 2 3
                    *     4 5
                    ---------
                          1 5
                        1 0
                      0 5
                    ---------
                      0 6 1 5
                        1 2
                      0 8
                    0 4
                    ---------
                    0 5 5 3 5
        这样我们就可以单独都对每一位进行相乘计算把结果存入相应的index中        
        **/
        
        int n1 = num1.length()-1;
        int n2 = num2.length()-1;
        if(n1 < 0 || n2 < 0) return "";
        int[] mul = new int[n1+n2+2];
        
        for(int i = n1; i >= 0; --i) {
            for(int j = n2; j >= 0; --j) {
                int bitmul = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');      
                bitmul += mul[i+j+1]; // 先加低位判断是否有新的进位
                
                mul[i+j] += bitmul / 10;
                mul[i+j+1] = bitmul % 10;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int i = 0;
        // 去掉前导0
        while(i < mul.length-1 && mul[i] == 0) 
            i++;
        for(; i < mul.length; ++i)
            sb.append(mul[i]);
        return sb.toString();
    }

    public static String multiply2(String num1, String num2) {
        // 1 2 3 
        // 4 5 6
        // 501 6
        int n1=num1.length();
        int n2=num2.length();
        int[] res=new int[n1+n2];
        for (int i=n1-1;i>=0;i--) {
            for (int j=n2-1;j>=0;j--) {
                res[i+j+1]+=(num1.charAt(i)-48)*(num2.charAt(j)-48);
            }
        }
        //处理进位
        for(int i=res.length-1;i>=0;i--) {
            if(res[i]>=10){
                res[i-1]+=res[i]/10;
                res[i]%=10;
            }
        }
        //去掉前面多余的0
        int index=0;
        while (index<res.length-1&&res[index]==0) { 
            index++;
        }
        StringBuilder sb=new StringBuilder();
        for (int i=index;i<res.length;i++) {
            sb.append(res[i]);
        }
        return sb.toString();
    }
}
