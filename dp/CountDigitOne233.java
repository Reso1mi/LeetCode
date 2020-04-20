import java.util.*;
public class CountDigitOne233{
    public static void main(String[] args) {
        CountDigitOne233 c=new CountDigitOne233();
        System.out.println(c.countDigitOne(13));
    }

    int [][] dp=null;

    public int countDigitOne(int n) {
        int len=0;
        int[] num=new int[64]; //64位肯定够了
        while(n!=0){
            num[len++]=n%10;
            n/=10;
        }
        dp=new int[len+1][len+1];
        //从高位向低位枚举
        return dfs(num,len-1,0,true,true);
    }

    public int dfs(int[] num,int pos,int sumOne,boolean leadZero,boolean limit){
        if(pos==-1) return sumOne;
        if(!leadZero && !limit && dp[pos][sumOne]!=0) return dp[pos][sumOne];
        int res=0;
        int up=limit?num[pos]:9;
        for (int i=0;i<=up;i++) {
            res+=dfs(num,pos-1,sumOne+(i==1?1:0),leadZero&&i==0,i==up&&limit);
        }
        if(!leadZero && !limit) dp[pos][sumOne]=res;
        return res;
    }


    //简化下代码，前导0其实没有影响
    int [][] dp=null;

    public int countDigitOne(int n) {
        int len=0;
        int[] num=new int[64]; //64位肯定够了
        while(n!=0){
            num[len++]=n%10;
            n/=10;
        }
        dp=new int[len+1][len+1];
        //从高位向低位枚举
        return dfs(num,len-1,0,true);
    }

    public int dfs(int[] num,int pos,int sumOne,boolean limit){
        if(pos==-1) return sumOne;
        if(!limit && dp[pos][sumOne]!=0) return dp[pos][sumOne];
        int res=0;
        int up=limit?num[pos]:9;
        for (int i=0;i<=up;i++) {
            res+=dfs(num,pos-1,sumOne+(i==1?1:0),i==up&&limit);
        }
        if(!limit) dp[pos][sumOne]=res;
        return res;
    }
}