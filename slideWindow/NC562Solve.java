//NC562.牛牛的魔法卡
//https://www.nowcoder.com/practice/9b6fe52a68904c77aa81502f57ceac86
public class NC562Solve{
    
    public int solve (int n, int k, int[][] card) {
        // write code here
        Arrays.sort(card, (c1,c2)->c1[1]-c2[1]);
        int INF = Integer.MAX_VALUE;
        int left = 0;
        int count = 0;
        int[] freq = new int[k+1];
        int res = INF;
        for (int right = 0; right < n; right++) {
            if (freq[card[right][0]] == 0) {
                count++;
            }
            freq[card[right][0]]++;
            while(left<=right && count == k){
                res = Math.min(res, card[right][1] - card[left][1]);
                freq[card[left][0]]--;
                if (freq[card[left][0]]==0) {
                    count--;
                }
                left++;
            }
        }
        if (res == INF) {
            return -1;
        }
        return res;
    }
}