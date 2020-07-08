import java.util.*;


public class NC82AppleTree {

    public static void main(String[] args) {
        for (int i =0;i<1000;i++) {
            int[] a = generateRandomOpArray(1000,1000);
            int[] b = generateRandomOpArray(1000,1000);
            long[] res = solve(a, b);
            long[] res2 = solve2(a, b);
            if(!isEqual(res, res2)){
                printArray(a);
                printArray(b);
                printArray(res);
                printArray(res2);
                return;
            }
        }
        System.out.println("NICE");
    }

    //正解 双指针，时间复杂度O(m+n)
    public static long[] solve (int[] a, int[] b) {
        Arrays.sort(a);
        int p = 0;
        int sb = 0;
        long[] res = new long[b.length];
        for (int i = 0; i < b.length; i++) {
            sb += b[i];
            while(p < a.length && a[p] < sb){
                //该果树果子不够了，拿取剩下所有的
                res[i] += (a[p] - (sb - b[i]));
                //下一颗果树
                p++;
            }
            //后面的都够
            res[i]+=(a.length - p) * (long)b[i];
        }
        return res;
    }

    //前缀和+二分的做法（容易溢出，random稍微调大点就溢出了，过不了OJ）
    public static long[] solve2 (int[] a, int[] b) {
        if(a==null || a.length==0){
            return new long[0];
        }
        // write code here
        Arrays.sort(a);
        int d = b.length;
        int al = a.length;
        long sum = 0;
        long[] preSum = new long[al];
        preSum[0] = a[0];
        for(int i = 1; i < al; i++){
            preSum[i] = preSum[i-1] + a[i];
        }
        long[] res = new long[d];
        int sb = 0;
        for(int i = 0; i < d; i++){
            sb += b[i];
            int idx = search(a, sb);
            if(idx == -1){
                res[i] = sb * al - sum;
            }else{
                res[i] = preSum[idx] + sb * (al-idx-1) - sum;
            }
            sum += res[i];
        }
        return res;
    }
    
    //小于target的最后一个
    public static int search(int[] a, int target){
       int left = 0;
       int right = a.length-1;
       int res = -1;
       while(left <= right){
           int mid = left + (right - left)/2;
           if(a[mid] < target){
               res = mid;
               left = mid + 1;
           }else{
               right = mid - 1;
           }
       }
       return res;
    }

    //https://leetcode-cn.com/circle/article/NA6h7i/
    public static long[] byteDance(int[] a, int[] b) {
        // 天数
        int m = b.length;
        // 苹果树数
        int n = a.length;
        long[] res = new long[m];
        // 预排序
        Arrays.sort(a);

        // 记录前缀和，pre[i]代表0~i棵树上果子数量的总和
        int[] prefix = new int[n];
        prefix[0] = a[0];
        for (int i = 1; i < n; ++i) {
            prefix[i] = prefix[i - 1] + a[i];
        }

        // 记录前几天总共摘到的苹果数量
        int sum = 0;
        // 记录从第几棵苹果树开始摘
        int start = 0;
        // 累加到当天的计划每棵树要摘的苹果数量
        int tmp = 0;
        for (int i = 0; i < m; ++i) {
            // 更新计划要摘的苹果数量
            tmp += b[i];
            // 寻找新的起点
            start = binarySearch(a, start, tmp);
            // 足够的直接乘 + 不足的全摘光 - 前几天摘的
            res[i] = (n - start) * tmp + (start > 0 ? prefix[start - 1] : 0) - sum;
            // 更新摘下的苹果总数量
            sum += res[i];
        }
        return res;
    }

    /**
     * 二分寻找起点，这个起点意味着包括自身在内及以后的苹果树的数量都是足够被采摘的
     *
     * @param num 苹果树
     * @param start 原起点，因为预排序过后，前一天不够摘的苹果树后一天肯定也足够，所以可以直接以上一轮的start为起点
     * @param target 计划要摘的苹果数量
     * @return 大于等于target的数所对应的下标
     */
    private static int binarySearch(int[] num, int start, int target) {
        if (target > num[num.length - 1]) {
            return num.length;
        }
        if (target < num[0]) {
            return 0;
        }
        int l = start, r = num.length - 1;
        while (l < r) {
            int mid = l + (r - l >> 1);
            if (num[mid] > target) {
                r = mid - 1;
            } else if (num[mid] < target) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return l;
    }


    //随机数
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize) * Math.random()+1)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    //随机正数
    public static int[] generateRandomOpArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize) * Math.random()+1)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (maxValue * Math.random()+1);
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(long[] arr1, long[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
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

    public static void printArray(long[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}