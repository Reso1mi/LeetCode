import java.util.*;
public class LongestDupSubstring1044{
    public static void main(String[] args) {

    }

    //不检测冲突，看题解的数据莽过的
    public String longestDupSubstring(String S) {
        int n = S.length();
        int [] nums =new int[n];
        for (int i = 0; i < S.length(); i++) {
            nums[i] =  S.charAt(i) - 'a';
        }
        long MOD =  1L<<32; //取其他的容易WA...
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

    //写一波检测冲突的
    public String longestDupSubstring(String S) {
        int n = S.length();
        long MOD = (long) 1e9+7;
        int B = 26; 
        int left = 1;
        int right = n - 1;
        int start = -1, mlen = 0;
        while (left <= right){
            int mid = left + (right - left)/2;
            int temp = RabinKarp(mid, B, S, MOD);
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

    public int RabinKarp(int len, int B, String S, long MOD){
        //hash(S) = s[0] * B^(len-1) + s[1] * B^(len-2) + ... + s[n-1] *1
        //B^(len-1) (移除左端点时需要的值)
        long BL = 1;
        for (int i = 0; i < len - 1; i++){
            BL = (BL * B) % MOD;
        }
        //[0,len-1]的hash值
        long h = 0;
        for (int i = 0; i < len; i++){
            h = (h * B + S.charAt(i) - 'a') % MOD;
        }
        //这里肯定不能直接存字符串做冲突检测，太大了会MLE
        //存一个起始地址就可以了len已知
        HashMap<Long,Integer> map = new HashMap<>();
        map.put(h, 0);
        //rolling hash
        for (int i = 1; i <= S.length() - len; i++){
            //+MOD是为了负数取模
            h = (h - (S.charAt(i-1) - 'a') * BL % MOD + MOD) % MOD;
            h = (h * B + (S.charAt(len + i -1) - 'a')) % MOD;
            Integer start = map.get(h);
            if (start != null && S.substring(start, start + len).equals(S.substring(i, i + len))){
                return i;
            }
            map.put(h, i);
        }
        return -1;
    }


    //再写一波检测冲突的。。。
    //上面的写的有问题，检测不完全
    public String longestDupSubstring(String S) {
        int n = S.length();
        long MOD = (long) 1e9+7;
        int B = 26; 
        int left = 1;
        int right = n - 1;
        int start = -1, mlen = 0;
        while (left <= right){
            int mid = left + (right - left)/2;
            int temp = RabinKarp(mid, B, S, MOD);
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

    public int RabinKarp(int len, int B, String S, long MOD){
        //hash(S) = s[0] * B^(len-1) + s[1] * B^(len-2) + ... + s[n-1] *1
        //B^(len-1) (移除左端点时需要的值)
        long BL = 1;
        for (int i = 0; i < len - 1; i++){
            BL = (BL * B) % MOD;
        }
        //[0,len-1]的hash值
        long h = 0;
        for (int i = 0; i < len; i++){
            h = (h * B + S.charAt(i) - 'a') % MOD;
        }
        //这里肯定不能直接存字符串做冲突检测，太大了会MLE
        //存一个起始地址就可以了len已知
        HashMap<Long,List<Integer>> map = new HashMap<>();
        map.put(h, new ArrayList(){{add(0);}});
        //rolling hash
        for (int i = 1; i <= S.length() - len; i++){
            //+MOD是为了负数取模
            h = (h - (S.charAt(i-1) - 'a') * BL % MOD + MOD) % MOD;
            h = (h * B + (S.charAt(len + i -1) - 'a')) % MOD;
            List<Integer> starts = map.get(h);
            if (check(starts, i, S, len)){
                return i;
            }
            if (starts == null){
                List<Integer> lis = new ArrayList<>();
                lis.add(i);
                map.put(h, lis);
            }else{
                starts.add(i);
            }
        }
        return -1;
    }

    public boolean check(List<Integer> starts, int i, String s, int len){
        if(starts == null || starts.size() <= 0){
            return false;
        }
        for (int left : starts) {
            if(s.substring(left, left + len).equals(s.substring(i, i + len))){
                return true;
            }
        }
        return false;
    }
}