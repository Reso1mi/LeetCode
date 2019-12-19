public class CountNumbersWithUniqueDigits357{
    public static void main(String[] args) {
        CountNumbersWithUniqueDigits357 c=new CountNumbersWithUniqueDigits357();
        System.out.println(c.countNumbersWithUniqueDigits3(3));
    }

/*    private boolean[] visit=new boolean[10];

    private int count=-1;


    //脑瘫解法
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
        return count;
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
    }*/


    private int count=0;
    //回溯解法
    public int countNumbersWithUniqueDigits(int n) {
        boolean[] visit=new boolean[10];
        if (n==0) return 1;
        for (int i=1;i<=9;i++) {
            visit[i]=true;
            countNumbersWithUniqueDigits(n,visit,1);
            visit[i]=false;
        }
        return count+1; //加的是0
    }

    public void countNumbersWithUniqueDigits(int n,boolean[] visit,int index){
        if (index>n) {
            return;
        }
        count++;
        for (int i=0;i<=9;i++) {
            if (!visit[i]) {
                visit[i]=true;
                countNumbersWithUniqueDigits(n,visit,index+1);
                visit[i]=false;
            }
        }
    }

    //这种可以做记忆化,0ms
    Integer[] cache=null;

    public int countNumbersWithUniqueDigits2(int n) {
        boolean[] visit=new boolean[10];
        cache=new Integer[n+1];
        int res=0;
        if (n==0) return 1;
        for (int i=1;i<=9;i++) { //不考虑0开头的
            visit[i]=true;
            res+=countNumbersWithUniqueDigits2(n,visit,1);
            visit[i]=false;
        }
        return res+1; //加的是0这种情况
    }

    //[index,n](位数)区间内,能构成最多的不重复数字
    public int countNumbersWithUniqueDigits2(int n,boolean[] visit,int index){
        if (index==n) { //没得选,只有一种
            return 1;
        }
        if (cache[index]!=null) {
            return cache[index];
        }
        int count=1;
        for (int i=0;i<=9;i++) {
            if (!visit[i]) {
                visit[i]=true;
                count+=countNumbersWithUniqueDigits2(n,visit,index+1);
                visit[i]=false;
            }
        }
        return cache[index]=count;
    }

    //数学方法(初中数学)
    public int countNumbersWithUniqueDigits3(int n){
        if (n==0) return 1;
        if (n>10) return 0;
        int res=10,count=9; //i=1的情况
        for (int i=2;i<=n;i++) {
            count*=(11-i); //9*9*8*7*6*5.....
            res+=count;
        }
        return res;
    }
}