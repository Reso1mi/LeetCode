/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */
public class MinMeetingRooms919_LintCode {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
    //小根堆的思路
    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        Collections.sort(intervals,(i1,i2)->i1.start-i2.start);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals.get(0).end);
        for (int i = 1; i < intervals.size(); i++) {
            //lintCode这里的case好像有问题，我开始忘了加=也过了
            //大于等于堆顶的当前最早结束时间，说明可以和堆顶公用一个会议室
            if (intervals.get(i).start >= pq.peek()) {
                pq.poll();
            }
            pq.add(intervals.get(i).end);
        }
        return pq.size();
    }
}