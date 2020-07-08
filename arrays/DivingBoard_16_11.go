func divingBoard(shorter int, longer int, k int) []int {
    if k == 0{
        return []int{}
    }
    if shorter == longer{
        return []int{ k * shorter}
    }
    var res []int
    for i := 0; i <= k; i++{
        res = append(res, i * longer + (k - i) * shorter)
    }
    return res
}