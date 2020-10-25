public class SortedSquares977 {
    public static void main(String[] args) {

    }

    //算是复习了下归并，写复杂了
    public int[] sortedSquares(int[] A) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= 0) {
                left.add(A[i]);
            } else {
                right.add(A[i]);
            }
        }
        Collections.reverse(left);
        int[] L = new int[left.size()];
        int[] R = new int[right.size()];
        for (int i = 0; i < L.length; i++) {
            L[i] = left.get(i);
        }
        for (int i = 0; i < R.length; i++) {
            R[i] = right.get(i);
        }
        return merge(L, R);
    }
    
    public int[] merge(int[] A, int[] B) {
        int i = 0, j = 0;
        int lenA = A.length, lenB = B.length;
        int[] res = new int[lenA + lenB];
        int idx = 0;
        while (i < lenA && j < lenB) {
            res[idx++] = pow(A[i]) <= pow(B[j]) ? pow(A[i++]) : pow(B[j++]);
        }
        while (i < lenA ) res[idx++] = pow(A[i++]);
        while (j < lenB ) res[idx++] = pow(B[j++]);
        return res;
    }
    
    public int pow(int a) {
        return a*a;
    }

    //双指针
    public int[] sortedSquares(int[] A) {
        int N = A.length;
        int[] nums = new int[N];
        int left = 0;
        int right = N-1;
        for (int i = N-1; i >= 0; i--) {
            nums[i] = pow(A[right]) > pow(A[left]) ? pow(A[right--]) : pow(A[left++]);
        }
        return nums;
    }
}