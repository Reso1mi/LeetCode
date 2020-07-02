public class FindLength718{
    public int findLength(int[] A, int[] B) {
        int lenA = A.length, lenB = B.length;
        int left = 1;
        int right = Math.min(lenA, lenB);
        int res = 0;
        while (left <= right){
            int mid = left +(right - left) / 2;
            if(RabinKarp(A, B, mid)){
                res = Math.max(res, mid);
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return res;
    }
    
    public boolean RabinKarp(int[] A,int[] B, int L){
        int MOD = (int) 1e9+7, BASE = 101;
        long BL = 1;
        for(int i = 0; i < L-1; i++){
            BL = (BL * BASE) % MOD;
        }
        //hash(A[0,L-1]),hash(B[0,L-1])
        long hA = 0, hB = 0;
        for(int i = 0; i < L; i++){
            hA = (hA * BASE + A[i]) % MOD;
            hB = (hB * BASE + B[i]) % MOD;
        }
        HashSet<Long> set =new HashSet<>();
        set.add(hA);
        //rolling hash A
        for(int i = 1; i <= A.length - L; i++){
            hA = (hA - A[i-1] * BL % MOD + MOD) % MOD;
            hA = (hA * BASE + A[L + i -1]) % MOD;
            set.add(hA);
        }
        if(set.contains(hB)) return true;
        //rolling hash B
        for(int i = 1; i <= B.length - L; i++){
            hB = (hB - B[i-1] * BL % MOD + MOD) % MOD;
            hB = (hB * BASE + B[L + i -1]) % MOD;
            //这里还可以做一下冲突检测，set中需要多存一些信息
            if(set.contains(hB)){
                return true;
            }
        }
        return false;
    }
}