public class MaxResult1696 {
    public static void main(String[] args) {

    }

    //1 2 3 4 5 k=2
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        //dp[i]   = Max(       dp[i-1], dp[i-2], dp[i-3],... dp[i-k+1], dp[i-k])
        //dp[i+1] = Max(dp[i], dp[i-1], dp[i-2], dp[i-3],... dp[i-k+1])
        //dp[i] --> dp[i+1] 滑动窗口最大值
        LinkedList<int[]> queue = new LinkedList<>();
        for (int i = 1; i < n; i++) {
            while (!queue.isEmpty() && dp[i-1] > queue.getLast()[0]) {
                queue.removeLast();
            }
            if (!queue.isEmpty() && i-queue.getFirst()[1] >= k) {
                queue.removeFirst();
            }
            //这里也可以在队列中只存dp值的坐标，简化代码
            queue.addLast(new int[]{dp[i-1], i});
            dp[i] = queue.getFirst()[0]+nums[i];
        }
        return dp[n-1];
    }
}