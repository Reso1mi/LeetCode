public class FourSumCount{
    public static void main(String[] args) {

    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<C.length;i++) {
            for (int j=0;j<D.length;j++) {
                int key=C[i]+D[j];
                map.put(key,map.getOrDefault(key,0)+1);
            }
        }
        int res=0;
        for (int i=0;i<A.length;i++) {
            for (int j=0;j<B.length;j++) {
                int key=A[i]+B[j];
                if(map.containsKey(-key)){
                    res+=map.get(-key);
                }
            }
        }
        return res;
    }
}