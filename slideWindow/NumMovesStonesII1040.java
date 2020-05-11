public class NumMovesStonesII1040{
    public static void main(String[] args) {

    }

    public int[] numMovesStonesII(int[] stones) {
        if(stones==null || stones.length<=0){
            return new int[2];
        }
        //0 1 2 3 4 5 6 7 8 9 10
        //      0 1 2 3        4
        int N=stones.length;
        Arrays.sort(stones);
        int left=0;
        int[] res=new int[2];
        res[0]=Integer.MAX_VALUE;
        for(int right=0;right<N;right++){
            //整个区间范围大于N了需要缩小区间
            while(stones[right]-stones[left]+1>N){ 
                left++;
            }
            int windowStones=right-left+1;
            if(windowStones==N-1&&stones[right]-stones[left]+1==N-1){
                res[0]=Math.min(2,res[0]);
            }else{
                res[0]=Math.min(res[0],N-windowStones);
            }
        }
        res[1]=Math.max(stones[N-1]-stones[1]-N+2,stones[N-2]-stones[0]-N+2);
        return res;
    }
}