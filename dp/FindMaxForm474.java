import java.util.*;
public class FindMaxForm474{
    public static void main(String[] args) {
        FindMaxForm474 f=new FindMaxForm474();
        String[] strs={"10", "0", "0"};
        System.out.println(f.findMaxForm(strs,1,1));
    }

    Integer [][][] cache=null;

    public int findMaxForm(String[] strs, int m, int n) {
        cache=new Integer[m+1][n+1][strs.length];
        return findMax(strs,m,n,0);
    }

    //m:0 n:1
    public int findMax(String[] strs, int m, int n,int index) {
        if (index>=strs.length) {
            return 0;
        }
        if (cache[m][n][index]!=null) {
            return cache[m][n][index];
        }
        int[] oz=count(strs[index]);
        if (oz[1]<=n && oz[0]<=m) {
            return cache[m][n][index]=Math.max(1+findMax(strs,m-oz[0],n-oz[1],index+1),findMax(strs,m,n,index+1));
        }
        return cache[m][n][index]=findMax(strs,m,n,index+1);
    }

    public int[] count(String str){
        int one=0,zero=0;
        char[] s=str.toCharArray();
        for (char c:s) {
            if (c=='1') {
                one++;
            }else{
                zero++;
            }
        }
        return new int[]{zero,one};
    }
}