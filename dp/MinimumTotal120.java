import java.util.*;
public class MinimumTotal120{
    public static void main(String[] args) {
        List<List<Integer>> triangle=new ArrayList(){{
            add(Arrays.asList(2));
            add(Arrays.asList(3,4));
            add(Arrays.asList(6,5,7));
            add(Arrays.asList(4,1,8,3));
        }};

        MinimumTotal120 m=new MinimumTotal120();
        System.out.println(m.minimumTotal(triangle));
    }

    //dp O(N)空间
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows=triangle.size();
        //dp[i]代表的是每一层第i个元素到最底层的最短距离
        //上面二维dp实际上也只和下一层的状态有关,所以我们可以重复的使用这个数组保存每一层的状态
        int[] dp=new int[rows+1];
        for (int i=rows-1;i>=0;i--) {
            for (int j=0;j<triangle.get(i).size();j++) {
                //到这里其实Math.min()里面的都是上一次循环
                //也就是下一层的,对应当前j位置左右两个相邻节点的最小距离
                dp[j]=Math.min(dp[j+1],dp[j])+triangle.get(i).get(j);
            }
        }
        return dp[0];
    }


    //dp做法 O(N^2)空间
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows=triangle.size();
        //dp[i][j]代表的是每i层第j个元素到最底层的最短距离
        int[][] dp=new int[rows+1][rows+1]; //row+1
        /*for (int i=0;i<triangle.get(rows-1).size();i++) {
            //给最后一行赋初始值
            dp[rows-1][i]=triangle.get(rows-1).get(i);
        }
        for (int i=rows-2;i>=0;i--) {
            for (int j=0;j<triangle.get(i).size();j++) {
                //核心递推式 dp[i][j]=min(dp[i+1][j],dp[i+1][j+1])+triangle(i)(j)
                dp[i][j]=Math.min(dp[i+1][j],dp[i+1][j+1])+triangle.get(i).get(j);
            }
        }*/
        //直接从最后一行开始,这样就不用手动给最后一行赋初始值了
        for (int i=rows-1;i>=0;i--) {
            for (int j=0;j<triangle.get(i).size();j++) {
                //核心递推式 dp[i][j]=min(dp[i+1][j],dp[i+1][j+1])+triangle(i)(j)
                dp[i][j]=Math.min(dp[i+1][j],dp[i+1][j+1])+triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }


    //记忆化递归
    public int minimumTotal2(List<List<Integer>> triangle) {
        //用Integer比较好,方便判空
        Integer [][] cache=new Integer[triangle.size()][triangle.size()];
        return minimumTotal(triangle,0,0,cache);
    }

    public int minimumTotal(List<List<Integer>> triangle,int cen,int index,Integer[][]cache) {
        if (cache[cen][index]!=null) {
            return cache[cen][index];
        }
        if (cen==triangle.size()-1) {
            return triangle.get(cen).get(index);
        }
        int left=minimumTotal(triangle,cen+1,index,cache);
        int right=minimumTotal(triangle,cen+1,index+1,cache);
        return cache[cen][index]=triangle.get(cen).get(index)+(left<right?left:right);
    }


    //什么鬼递归。。。写成贪心了,贪心是错的
    public int minimumTotal3(List<List<Integer>> triangle,int cen,int index) {
        if (cen==triangle.size()-1) {
            return triangle.get(cen).get(index);
        }
        int left=triangle.get(cen+1).get(index);
        int right=triangle.get(cen+1).get(index+1);
        return triangle.get(cen).get(index)+(left<right?minimumTotal3(triangle,cen+1,index):minimumTotal3(triangle,cen+1,index+1));
    }
}