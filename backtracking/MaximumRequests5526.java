public class MaximumRequests5526 {
    public static void main(String[] args) {
        
    }

    public int maximumRequests(int n, int[][] requests) {
        int[] nums = new int[n+1];
        dfs(nums, 0, requests, 0);
        return res;
    }
    
    int res = 0;
    
    public void dfs(int[] nums, int idx, int[][] requests, int count){
        if (check(nums)) {
            res = Math.max(res, count);
        }
        for (int i = idx; i < requests.length; i++) {
            nums[requests[i][0]]--;
            nums[requests[i][1]]++;
            dfs(nums, i+1, requests, count+1);
            nums[requests[i][0]]++;
            nums[requests[i][1]]--;
        }
    }
    
    public boolean check(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                return false;
            }
        }
        return true;
    }
}