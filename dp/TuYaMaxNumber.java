import java.io.*;// petr的输入模板
import java.util.*; 
import java.math.*; // 不是大数题可以不要这个

public class TuYaMaxNumber {

    //没有OJ，暴力对拍小数据好像没啥问题
    public static void main(String[] args) throws Exception {
        for (int k = 0; k < 1000; k++) {
            int N = 1000;
            int[] a = generateRandomOpArray(N,1000);
            int[] b = generateRandomOpArray(N,1000);
            int[][] nums = new int[2][N];
            nums[0] = a;
            nums[1] = b;
            // Scanner sc = new Scanner(new FileInputStream("./input.txt"));
            // int N = sc.nextInt();
            // int[][] nums = new int[2][N];
            // for (int i = 0; i < 2; i++) {
            //     for (int j = 0; j < N; j++) {
            //         nums[i][j] = sc.nextInt();
            //     }
            // }
            Long [][] dp = new Long[2][N];
            //long r1 = Math.max(solve(nums, 0, 0, dp), solve(nums, 1, 0, dp));
            long r2 = solveOp(nums);
            long r3 = solve(nums);
            if (r3 != r2) {
                printArray(nums[0]);
                printArray(nums[1]);
                System.out.println(r3);
                System.out.println(r2);
                System.out.println("WA!");
                return;
            }
        }
        System.out.println("NICE");
    }

    public static long solve (int[][] nums, int x, int y, Long[][] dp) {
        if (dp[x][y] != null) {
            return dp[x][y];
        }
        if ( y == nums[0].length-1) {
            return dp[x][y] = (long)nums[x][y];
        }
        long ans = 0;
        for (int j = y+1; j < nums[0].length; j++) {
            ans = Math.max(solve(nums, x^1, j, dp)+nums[x][y], ans);
        }
        return dp[x][y] = ans;
    }

    //纯DP的解法，1e5会T
    public static long solve (int[][] nums) {
        int N = nums[0].length;
        long[][] dp = new long[2][N];
        dp[0][0] = nums[0][0];
        dp[1][0] = nums[1][0];
        for (int j = 1; j < N; j++) {
            for (int k = j-1; k >=0 ; k--) {
                dp[0][j] = Math.max(dp[0][j], dp[1][k]+nums[0][j]);
                dp[1][j] = Math.max(dp[1][j], dp[0][k]+nums[1][j]);
            }
        }
        return Math.max(dp[1][N-1], dp[0][N-1]);
    }

    //优化DP的解法，动态更新最大值
    public static long solveOp (int[][] nums) {
        int N = nums[0].length;
        long[][] dp = new long[2][N];
        long max0 = dp[0][0] = nums[0][0];
        long max1 = dp[1][0] = nums[1][0];
        for (int j = 1; j < N; j++) {
            dp[0][j] = Math.max(dp[0][j], max1 + nums[0][j]);
            dp[1][j] = Math.max(dp[1][j], max0 + nums[1][j]);
            max0 = Math.max(max0, dp[0][j]);
            max1 = Math.max(max1, dp[1][j]);
        }
        return Math.max(max1, max0);
    }

    //暴力对拍
    public static long solve2 (int[][] nums, int x, int y) {
        if ( y == nums[0].length-1) {
            return (long)nums[x][y];
        }
        long ans = 0;
        for (int j = y+1; j < nums[0].length; j++) {
            if (x == 1) {
                ans = Math.max(solve2(nums, 0, j)+nums[x][y], ans);
            }else {
                ans = Math.max(solve2(nums, 1, j)+nums[x][y], ans);
            }
        }
        return ans;
    }

    //随机正数
    public static int[] generateRandomOpArray(int maxSize, int maxValue) {
        int[] arr = new int[maxSize];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (maxValue * Math.random()+1);
        }
        return arr;
    }

        // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}