public class MaxTurbulenceSize978{
    public static void main(String[] args) {

    }

    public int maxTurbulenceSize(int[] A) {
        if(A==null || A.length<=0){
            return 0;
        }
        int left=0;
        int res=1;
        for(int right=left+1;right<A.length;right++){
            if(A[right]==A[right-1]){ //跳过重复值
                left=right;
                continue;
            }
            //一个很长很丑的if
            if(right>=2 && ((A[right]>=A[right-1] && A[right-1]>=A[right-2]) || (A[right]<=A[right-1] && A[right-1]<=A[right-2]))){
                left=right-1;
            }
            res=Math.max(res,right-left+1);
        }
        return res;
    }

    //优化if条件
    public int maxTurbulenceSize(int[] A) {
        if(A==null || A.length<=0){
            return 0;
        }
        int left=0;
        int res=1;
        for(int right=left+1;right<A.length;right++){
            if(A[right]==A[right-1]){ //跳过相等的
                left=right;
                continue;
            }
            if(right>=2 && (A[right]>A[right-1])==(A[right-1]>A[right-2])){
                left=right-1; //left跳到中间值
            }
            res=Math.max(res,right-left+1);
        }
        return res;
    }

    //动态规划，从滑窗tag过来的...没往dp上想，看了评论区才想起来
    public int maxTurbulenceSize(int[] A) {
        if(A==null || A.length<=0){
            return 0;
        }
        int up=1,down=1;
        int res=1;
        for (int i=1;i<A.length;i++) {
            if(A[i]>A[i-1]){
                up=down+1;
                down=1;
            }else if (A[i]<A[i-1]){
                down=up+1;
                up=1;
            }else{
                up=1;down=1;
            }
            res=Math.max(res,Math.max(up,down));
        }
        return res;
    }
}