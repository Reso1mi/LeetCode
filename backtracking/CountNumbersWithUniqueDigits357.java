public class CountNumbersWithUniqueDigits357{
    public static void main(String[] args) {
        CountNumbersWithUniqueDigits357 c=new CountNumbersWithUniqueDigits357();
        System.out.println(c.countNumbersWithUniqueDigits(2));
    }

    //2
    //11 22 33 44 55 66 77 88 99
    //3
    //110 111 112 113 114 115 116 117 118 119
    //121 122
    //131 133
    //141 144
    //
    //210 211 212 213 214 215
    private boolean[] visit=new boolean[10];

    private int count=-1;

    public int countNumbersWithUniqueDigits(int n) {
        if (n==0) {
            return 1;
        }
        String str="";
        int temp=n;
        while(n>0){
            str+="9";
            n--;
        } 
        countNumbersWithUniqueDigits(Integer.valueOf(str),visit,"");
        /*while(temp>0{
            //一开始想的是把0开头的直接利用组合的知识计算出来让后剪掉
            //但是如果n>=10的话就无法算了
        }*/
        return count;
    }

    public void countNumbersWithUniqueDigits(int max,boolean[] visit,int num) {
        if (num>max) {
            return;
        }
        count++;
        for (int i=0;i<10;i++) {
            if (!visit[i]) {
                visit[i]=true;
                num*=10;
                num+=i;
                countNumbersWithUniqueDigits(max,visit,num);
                visit[i]=false;
                num-=i;
                num/=10;   
            }
        }
    }

    public void countNumbersWithUniqueDigits(int max,boolean[] visit,String num) {
        if (!num.equals("")&& Long.valueOf(num)>max) {
            return;
        }
        count++;
        for (int i=0;i<10;i++) {
            if ( num.equals("") || (!visit[i] && num.charAt(0)!='0')) {
                visit[i]=true;
                countNumbersWithUniqueDigits(max,visit,num+i);
                visit[i]=false;
            }
        }
    }
}