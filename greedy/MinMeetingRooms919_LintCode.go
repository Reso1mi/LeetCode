/**
 * Definition of Interval:
 * type Interval struct {
 *     Start, End int
 * }
 */

/**
 * @param intervals: an array of meeting time intervals
 * @return: the minimum number of conference rooms required
 */
import "sort"

type Pair struct {
    time  int
    isEnd bool
}

func minMeetingRooms(intervals []*Interval) int {
    var n = len(intervals)
    var list []*Pair
    var Max = func(a, b int) int {
        if a > b {
            return a
        }
        return b
    }
    for i := 0; i < n; i++ {
        list = append(list, &Pair{intervals[i].Start, false})
        list = append(list, &Pair{intervals[i].End, true})
    }
    sort.Slice(list, func(i int, j int) bool {
        return list[i].time < list[j].time
    })
    var res = 0
    var count = 0
    for _, p := range list {
        if p.isEnd {
            count--
        } else {
            count++
        }
        res = Max(count, res)
    }
    return res
}
