public class MaxScoreSightseeingPair1014{
    public static void main(String[] args) {

    }

    //A[i] + A[j] + i - j (i<j)
    public int maxScoreSightseeingPair(int[] A) {
        int res=-1;
        for (int i=0;i<A.length;i++) {
            for (int j=i+1;j<A.length;j++) {
                res=Math.max(A[i]+A[j]+i-j,res);
            }
        }
        return res;
    }

    // A[i]+A[j] - (j-i) i<j
    // A[i]+i + (A[j]-j)
    public int maxScoreSightseeingPair(int[] A) {
        int res=-1;
        int maxPre=A[0]+0;
        for (int j=1;j<A.length;j++) {           
            res=Math.max(maxPre+A[j]-j,res);
            maxPre=Math.max(maxPre,A[j]+j);
        }
        return res;
    }
}