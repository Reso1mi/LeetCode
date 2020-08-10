
/**
 * Definition of Interval:
 * type Interval struct {
 *     Start, End int
 * }
 */

/**
 * @param airplanes: An interval array
 * @return: Count of airplanes are in the sky.
 */
import "sort"

type Pair struct {
    time  int
    isEnd bool
}

func countOfAirplanes(airplanes []*Interval) int {
    var n = len(airplanes)
    var list []*Pair
    var Max = func(a, b int) int {
        if a > b {
            return a
        }
        return b
    }
    for i := 0; i < n; i++ {
        list = append(list, &Pair{airplanes[i].Start, false})
        list = append(list, &Pair{airplanes[i].End, true})
    }
    //[(1, 2), (2, 3), (3, 4)]
    //随意排序： 1 2start 2end 3start 3end 4 这样最大值就是2，不对
    //所以应该降落优先，将降落时间点的排在前面
    sort.Slice(list, func(i int, j int) bool {
        if list[i].time == list[j].time {
            //将end放在前面
            return list[i].isEnd
        }
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
