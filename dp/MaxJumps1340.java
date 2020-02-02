import java.util.*;
public class MaxJumps1340{
    public static void main(String[] args) {
        MaxJumps1340 m=new MaxJumps1340();
        int[] arr={7,6,5,4,3,2,1};
        int[] arr2={6,4,14,6,8,13,9,7,10,6,12};
        System.out.println(m.maxJumps(arr2,2));
    }
    

    private Integer[] cache=null;

    public int maxJumps(int[] arr, int d) {
        int[][] max=new int[arr.length][arr.length];
        cache=new Integer[arr.length];
        // for (int i=0;i<arr.length;i++) {
        //     max[i][i]=arr[i];
        //     for (int j=i+1;j<arr.length;j++) {
        //         max[i][j]=Math.max(max[i][j-1],arr[j]);
        //     }
        // }
        int res=0;
        for (int i=0;i<arr.length;i++) {
            res=Math.max(jump(arr,d,i),res);
        }
        return res+1;
    }

    //区域预处理MAX值(多此一举)
    public int jump2(int[] arr,int d,int index,int[][] max){
        if (cache[index]!=null) {
            return cache[index];
        }
        int res=0;
        for (int i=Math.max(index-d,0);i<index;i++) {
            if (arr[index]>arr[i] && arr[index]>max[i+1][index-1]) {
                res=Math.max(jump(arr,d,i,max)+1,res);
            }
        }
        for (int i=index+1;i<=Math.min(index+d,arr.length-1);i++) {
            if (arr[index]>arr[i] && arr[index]>max[index+1][i-1]) {
                res=Math.max(jump(arr,d,i,max)+1,res);
            }
        }
        return cache[index]=res;
    }

    //挨个跳,有一个跳不到,后面所有的就都跳不到了
    public int jump(int[] arr,int d,int index){ 
        if (cache[index]!=null) {
            return cache[index];
        }
        int res=0;
        for (int i=index-1;i>=Math.max(index-d,0) && arr[index]>arr[i];i--) {
            res=Math.max(jump(arr,d,i)+1,res);
        }
        for (int i=index+1;i<=Math.min(index+d,arr.length-1) && arr[index]>arr[i];i++) {
            res=Math.max(jump(arr,d,i)+1,res);
        }
        return cache[index]=res;
    }

    //动态规划
    public int maxJumps(int[] arr, int d) {
        int res=0,len=arr.length;
        Pair[] pair=new Pair[len];
        int[] dp=new int[len];
        Arrays.fill(dp,1);
        for (int i=0;i<len;i++) pair[i]=new Pair(i,arr[i]);
        Arrays.sort(pair,(p1,p2)->p1.value-p2.value);
        for (int i=0;i<len;i++) {
            int index=pair[i].index;
            //向左
            for (int j=index-1;j>=Math.max(index-d,0) && arr[index]>arr[j];j--) {
                dp[index]=Math.max(dp[j]+1,dp[index]);
            }
            //向右
            for (int j=index+1;j<=Math.min(index+d,arr.length-1) && arr[index]>arr[j];j++) {
                dp[index]=Math.max(dp[j]+1,dp[index]);
            }
            res=Math.max(dp[index],res);
        }
        return res;
    }

    class Pair{
        int index;
        int value;
        public Pair(int index,int value){
            this.index=index;
            this.value=value;
        }
    }
}