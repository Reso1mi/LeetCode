import java.util.*;

public class DistinctEchoSubstrings1316{
    public static void main(String[] args) {

    }

    //s.length()<2000
    //abcabcabc
    int BASE = 131;
    
    long MOD = (long)1e9+7;

    public int distinctEchoSubstrings(String s) {
        int n = s.length();
        //前缀hash和(前i个元素的hash值)
        long[] hashSum = new long[n+1];
        //BASE的所有幂乘
        long[] pow = new long[n+1];
        pow[0] = 1;
        hashSum[0] = 0;
        for (int i = 1; i <= n; i++) {
            hashSum[i] = (hashSum[i-1]*BASE + s.charAt(i-1)) % MOD;
            pow[i] = (pow[i-1]*BASE) % MOD;
        }
        HashSet<Long> set = new HashSet<>();
        //枚举所有偶数长度的子串
        for (int len = 2; len <= n; len+=2) {
            for (int i = 0 ; i+len-1 < n; i++) {
                int j = i + len - 1; //右边界
                int mid = i + (j-i)/2; //中点
                //0,3
                long hleft = getHash(hashSum, pow, s, i, mid);
                long hright = getHash(hashSum, pow, s, mid+1, j);
                if(hleft == hright && !set.contains(hleft)){
                    set.add(hleft);
                }
            }
        }
        return set.size();
    }

    // 求s[i,j]区间的哈希值: s[i]*B^j-i + s[i+1]*B^j-i-1 + ... + s[j]
    // 
    // hashSum[i] = s[0]*B^i-1 + s[1]*B^i-2 +...+ s[i-1]
    // hashSum[j+1] = s[0]*B^j + s[1]*B^j-1 +...+ s[j]
    // hashSum[i]*B^j-i+1 = s[0]*B^j + s[1]*B^j-1 +...+ s[i-1]*B^j-i+1
    // hash[i,j] = hashSum[j+1] - hashSum[i] * B^j-i+1
    //           = s[i]*B^j-i + s[i+1]*B^j-i-1 +...+s[j]
    public long getHash(long[] hashSum, long[] pow, String s, int i, int j){
        //j-i+1是[i,j]区间的长度，包含i和j，而hashSum[k]是不包含k的
        //所以这里需要转换下，j需要+1使得hashSum包含j
        return (hashSum[j+1] - (hashSum[i] * pow[j-i+1]) % MOD + MOD) % MOD;
    }

    //KMP的做法
    public int distinctEchoSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            getNext(s.substring(i));
        }
        return set.size();
    }

    HashSet<String> set = new HashSet<>();

    public void getNext(String s){
        if(s.length() < 2){
            return;
        }
        int n = s.length();
        int[] next = new int[n+1];
        next[0] = -1;
        next[1] = 0;
        int left = 0, right = 2;
        while(right <= n){
            if(s.charAt(left) == s.charAt(right-1)){
                left++;
                next[right] = left;
                int replen = right-next[right];
                String rs = s.substring(0,right);
                if (right%2==0 && replen!=right && right%replen==0 && !set.contains(rs)) {
                    set.add(rs);
                }
                right++;
            }else if(next[left] == -1){
                right++;
            }else{
                left = next[left];
            }
        }
    }
}