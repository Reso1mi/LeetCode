public class MaxEvents1353{
    public static void main(String[] args) {

    }

    //1 2 3 4 5
    //- - - - -
    //        -  
    //    -
    //    - -     
    //      - -
    //  -
    // 1,5  5,5  3,3  3,4  4,5  2,2
    // sort
    // 1,5  2,2  3,4  3,3  4,5  5,5
    // resort
    // 2,2  3,3  3,4  5,5  4,5  1,5
    // 2,2  3,3  3,4  1,5  4,5  5,5
    // 
    //[[1,4],[4,4],[2,2],[3,4],[1,1]]
    // 1,1  2,2  1,4  3,4  4,4
    // 暴力贪心，按结束时间排序，优先安排结束时间短的，O(N^2)
    public int maxEvents(int[][] events) {
        if(events==null || events.length<=0) return 0;
        Arrays.sort(events,(e1,e2)->e1[1]-e2[1]);
        HashSet<Integer> set=new HashSet<>();
        int count=0;
        for(int i=0;i<events.length;i++){
            int start=events[i][0];
            int end=events[i][1];
            for(int j=start;j<=end;j++){
                if(!set.contains(j)){
                    set.add(j);
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    //优先队列优化，NlogN
    public int maxEvents(int[][] events) {
        if(events==null || events.length<=0) return 0;
        Arrays.sort(events,(e1,e2)->e1[0]-e2[0]);
        //结束时间构建小根堆
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int index=0,res=0,n=events.length;
        int curDay=1;
        while(index<n || !pq.isEmpty()){
            //将当天开始的会议的结束时间加入小根堆
            while(index<n && curDay==events[index][0]){
                pq.add(events[index++][1]);
            }
            //将过期会议的移除
            while(!pq.isEmpty() && pq.peek()<curDay){
                pq.poll();
            }
            //优先选择结束时间最短的
            if(!pq.isEmpty()){
                pq.poll();
                res++;
            }
            curDay++; //安排下一天
        }
        return res;
    }
}