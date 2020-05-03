public class LastStoneWeight1046{
    public static void main(String[] args) {

    }

    //解法一: 利用优先队列，时间复杂度 O(NlogN)
    public int lastStoneWeight(int[] stones) {
        if(stones==null ||stones.length<=0){
            return 0;
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<stones.length;i++){
            pq.add(stones[i]);
        }
        //NlogN
        while(pq.size()>1){
            int y=pq.poll();
            int x=pq.poll();
            pq.add(y-x);
        }
        return pq.poll();
    }
}