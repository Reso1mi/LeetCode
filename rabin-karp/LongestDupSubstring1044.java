public class LongestDupSubstring1044{
    public static void main(String[] args) {

    }

    public String longestDupSubstring(String S) {
        int n = S.length();
        int [] nums =new int[n];
        for (int i = 0; i < S.length(); i++) {
            nums[i] =  S.charAt(i) - 'a';
        }
        long MOD =  1L<<32;
        int B = 26; 
        int left = 1;
        int right = n - 1;
        int start = -1, mlen = 0;
        while (left <= right){
            int mid = left + (right - left)/2;
            int temp = RabinKarp(mid, B, nums, MOD);
            if (temp != -1){
                if (mid > mlen){
                    mlen = mid;
                    start = temp;
                }
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return start == -1 ? "" : S.substring(start, start + mlen);
    }

    public int RabinKarp(int len, int B, int[] nums, long MOD){
        //hash(S) = s[0] * B^(len-1) + s[1] * B^(len-2) + ... + s[n-1] *1
        //B^(len-1) (移除左端点时需要的值)
        long BL = 1;
        for (int i = 0; i < len - 1; i++){
            BL = (BL * B) % MOD;
        }
        //[0,len-1]的hash值
        long h = 0;
        for (int i = 0; i < len; i++){
            h = (h * B + nums[i]) % MOD;
        }
        HashSet<Long> set = new HashSet<>();
        set.add(h);
        //rolling hash
        for (int i = 1; i <= nums.length - len; i++){
            //+MOD是为了负数取模
            h = (h - nums[i - 1] * BL % MOD + MOD) % MOD;
            h = (h * B + nums[i + len - 1]) % MOD;
            if (set.contains(h)){
                return i;
            }
            set.add(h);
        }
        return -1;
    }
}