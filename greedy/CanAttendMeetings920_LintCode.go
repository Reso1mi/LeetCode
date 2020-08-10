import "sort"

func canAttendMeetings(intervals []*Interval) bool {
    // Write your code here
    sort.Slice(intervals, func(i int, j int) bool {
        return intervals[i].Start < intervals[j].Start
    })
    for i := 1; i < len(intervals); i++ {
        if intervals[i].Start < intervals[i-1].End {
            return false
        }
    }
    return true
}
