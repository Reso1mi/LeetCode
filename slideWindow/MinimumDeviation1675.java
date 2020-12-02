import java.util.*;
public class MinimumDeviation1675 {
    public static void main(String[] args) {

    }

    public int minimumDeviation(int[] nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[2]-b[2]);
        List<List<Integer>> lis = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            if (nums[i] % 2 == 1) {
                pq.add(new int[]{i, 0, nums[i]});
                max = Math.max(max, nums[i]);
                tmp.add(nums[i]);
                tmp.add(nums[i] * 2);
            } else {
                tmp.add(nums[i]);
                while (nums[i] % 2 == 0) {
                    tmp.add(nums[i]/2);
                    nums[i]/=2;
                }
                pq.add(new int[]{i, 0, nums[i]});
                max = Math.max(max, nums[i]);
                Collections.reverse(tmp);
            }
            lis.add(tmp);
        }
        int res = Integer.MAX_VALUE;
        while (true) {
            int[] min = pq.poll();
            res = Math.min(res, max-min[2]);
            if (min[1]+1 >= lis.get(min[0]).size()) {
                break;
            }
            int next = lis.get(min[0]).get(min[1]+1);
            pq.add(new int[]{min[0], min[1]+1, next});
            max = Math.max(max, next);
        }
        return res;
    }

    //1 3 6 9
    //2 6 6 18
    //2 10 8
    //[4,1,5,20,3]
    //4 1 5 10 3
    //4 1 5 5 3
    //5 3
    //5 7
    public int minimumDeviation2(int[] nums) {
        int INF = 0x3f3f3f3f;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->b-a);
        int min = INF;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 1) {
                nums[i] <<= 1;
            }
            min = Math.min(min, nums[i]);
            pq.add(nums[i]);
        }
        int res = INF;
        while (true) {
            int max = pq.poll();
            res = Math.min(res, max-min);
            if ((max&1)==1) {
                break;
            }
            pq.add(max/2);
            min = Math.min(min, max/2);
        }
        return res;
    }
}