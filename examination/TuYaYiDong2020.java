import java.util.*;
import java.io.*;
public class TuYaYiDong2020 {
    public static void main(String[] args) throws Exception{
        //slove_t1();
        //solve_t2();
        solve_t3();
    }

    //没有010和101的子序列，最终肯定是00011或者11000或者全0全1
    //所以分别求几种情况的变化次数再求最小值就ok了，时间复杂度O(N)
    public static void slove_t1 () throws Exception{
        Scanner sc = new Scanner(System.in);
        //Scanner sc = new Scanner(new FileInputStream("./input.txt"));
        int N = sc.nextInt();
        while (N-- > 0) {
            System.out.println(slove_t1(sc.next()));
        }
    }

    //001100
    public static int slove_t1(String s) {
        
    }

    //T2: [2, 1, 2] = 5, [1, 1, 1] = 4
    //和并c个剩余k的积木，得到k+1个积木，但是需要保证最终结果大于等于n
    public static void solve_t2 () throws Exception {
        //题目没有给输入格式，我按照T组一起输入的方式读入
        Scanner sc = new Scanner(System.in);
        //Scanner sc = new Scanner(new FileInputStream("./input.txt"));
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            System.out.println(solve_t2(nums));
        }
    }

    public static int solve_t2(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        //1 1 1 1 1 1 2 2   n = 8
        //1 : 6 
        //2 : 2
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        int sum = 0;
        for (Integer key : map.keySet()) {
            //向上取整，求最多能合并的个数
            sum += (map.get(key)+key)/(key+1) * (key+1);
        }
        return sum;
    }

    //T3，动态规划，一开始写的记忆化搜索，但是看了数据范围感觉会tle
    //然后改成了递推，时间复杂度O(N^2)再1e5下仍然会T，然后发现中间过程可以优化，进一步优化成O(N)
    public static void solve_t3 () throws Exception{
        Scanner sc = new Scanner(System.in);
        //Scanner sc = new Scanner(new FileInputStream("./input.txt"));
        int N = sc.nextInt();
        int[][] nums = new int[2][N];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < N; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        //dp[i][j]代表选取nums[i][j]的最大和
        long[][] dp = new long[2][N];
        //max0，max1代表到第j列为止，前面的第一行和第二行最大值
        long max0 = dp[0][0] = nums[0][0];
        long max1 = dp[1][0] = nums[1][0];
        for (int j = 1; j < N; j++) {
            dp[0][j] = Math.max(dp[0][j], max1 + nums[0][j]);
            dp[1][j] = Math.max(dp[1][j], max0 + nums[1][j]);
            max0 = Math.max(max0, dp[0][j]);
            max1 = Math.max(max1, dp[1][j]);
        }
        System.out.println(Math.max(max1, max0));
    }
}