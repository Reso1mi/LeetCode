import java.util.*;
import java.util.stream.Stream;
public class LintCode_BackPack92{

    //1 2 3 4 5 6
    //2 1 6 5 4 3
    public static void main(String[] args) {
        LintCode_BackPack92 l=new LintCode_BackPack92();
        int[] nums={3,4,8,5};
        System.out.println("\n"+l.backPack4(10,nums));
    }

    //二维动态规划
    public int backPack(int m,int[] A) {
        if (A==null || A.length<=0) {
            return 0;
        }
        int[][] dp=new int[A.length][m+1];
        for (int i=0;i<A.length;i++) {
            for (int j=0;j<=m;j++) {
                if (j==0) {//初始化第一列
                    dp[i][j]=0;
                }else if (i==0) {//初始化第一行
                    dp[i][j]=j-A[i]>=0?A[i]:0;
                }else if (i>0) {
                    dp[i][j]=j-A[i]>=0?Math.max(dp[i-1][j],dp[i-1][j-A[i]]+A[i]):dp[i-1][j];
                }
            }
        }
        return dp[A.length-1][m];
    }

    //一唯动态规划（Wrong Answer）
    public int backPack3(int m,int[] A) {
        if (A==null || A.length<=0) {
            return 0;
        }
        int[] dp=new int[m+1];
        for (int i=0;i<A.length;i++) {
            for (int j=0;j<=m;j++) {
                if (j==0) {//初始化第一列
                    dp[j]=0;
                }else if (i==0) {//初始化第一行
                    dp[j]= j-A[i]>=0?A[i]:0;
                }else{
                    //这里改错了。。。。。
                    //这里dp[j-A[i]]已经不是上一层的了，而是当前层前面位置的值！！！！
                    dp[j]=j-A[i]>=0?Math.max(dp[j],dp[j-A[i]]+A[i]):dp[j];
                }
            }
            for (int k=0;k<dp.length;k++) {
                System.out.print(dp[k]+",");
            }
            System.out.println();
        }
        return dp[m];
    }

    //总结上面的经验,每一层我们从后往前递推,这样就不会覆盖
    public int backPack4(int m,int[] A) {
        if (A==null || A.length<=0) {
            return 0;
        }
        int[] dp=new int[m+1];
        for (int i=0;i<A.length;i++) {
            for (int j=m;j>=0;j--) {
                if (j==0) {//初始化第一列
                    dp[j]=0;
                }else if (i==0) {//初始化第一行
                    dp[j]= j-A[i]>=0?A[i]:0;
                }else{
                    dp[j]=j-A[i]>=0?Math.max(dp[j],dp[j-A[i]]+A[i]):dp[j];
                }
            }
        }
        return dp[m];
    }


    //代码优化
    public int backPack(int m,int[] A) {
        if (A==null || A.length<=0) {
            return 0;
        }
        int[] dp=new int[m+1];
        for (int i=0;i<A.length;i++) {
            for (int j=m;j>=A[i];j--) {
                dp[j]=Math.max(dp[j],dp[j-A[i]]+A[i]);
            }
        }
        return dp[m];
    }

    
    
/*    828,125,740,724,983,321,773,
    678,841,842,875,377,123,144,
    340,467,625,916,463,922,255,
    662,692,143,778,766,254,559,
    480,483,904,60,305,966,872,
    935,626,691,832,998,508,657,
    215,162,858,179,869,675,453,
    158,520,138,847,452,764,995,
    600,568,92,496,533,404,186,
    345,304,420,181,73,547,281,
    374,376,454,438,553,929,140,
    298,451,674,91,531,685,862,
    446,262,477,573,627,624,814,
    103,294,388*/


    //用Integer[][],空间会超。。。lintCode好严格
    int [][] cache=null;    

    public int backPack2(int m,int[] A) {
        //cache=new Integer[m+1][A.length+1];
        cache=new int[A.length+1][m+1];
        for (int i=0;i<A.length;i++) {
            Arrays.fill(cache[i],-1);   
        }
        if (A==null || A.length<=0) {
            return 0;
        }
        return putPack(m,A,A.length-1);
    }

    //将A[index,A.len-1]范围内的元素装进大小为m的背包的最大收益
    public int putPack(int m,int[] A,int index) {
        //index==0的时候不应该返回=0代表第一个,是可以装的
        //对于m也是一样, 这种边界思考一下m就等于0和index就等于0这种特例就可以
        //只要这种特例是正确的那么整个递归就是正确的,并不需要去思考整个递归的结束条件
        if (index<0 || m<=0) {
            return 0;
        }
        if (cache[index][m]!=-1) {
            return cache[index][m];
        }
        //选index位置的元素,然后求个最大值
        if (A[index]<=m) {
            return cache[index][m]=Math.max(putPack(m,A,index-1),A[index]+putPack(m-A[index],A,index-1));
        }
        //不选index位置的元素
        return cache[index][m]=putPack(m,A,index-1);
    }

    //方向不同罢了。。。。
    public int putPack(int m,int[] A,int index) {
        //index==0的时候不应该返回=0代表第一个,是可以装的
        //对于m也是一样, 这种边界思考一下m就等于0和index就等于0这种特例就可以
        //只要这种特例是正确的那么整个递归就是正确的,并不需要去思考整个递归的结束条件
        if (index>=A.length || m<=0) {
            return 0;
        }
        if (cache[index][m]!=-1) {
            return cache[index][m];
        }
        //不选index位置的元素
        int res=putPack(m,A,index+1);
        if (A[index]<=m) {
            res=Math.max(res,A[index]+putPack(m-A[index],A,index+1));
        }
        cache[index][m]=res;
        return res;
    }
}