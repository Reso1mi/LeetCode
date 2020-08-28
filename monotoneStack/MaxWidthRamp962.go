func maxWidthRamp(A []int) int {
    var order [][]int
    order = append(order, []int{0, A[0]})
    //构建递减序列
    for i := 1; i < len(A); i++ {
        if A[i] < order[len(order)-1][1] {
            order = append(order, []int{i, A[i]})
        }
    }
    res := 0
    for j, target := range A {
        i := binarySearch(order, target)
        res = Max(res, j-i)
    }
    return res
}

//找第一个小于等于target的值
func binarySearch(num [][]int, target int) int {
    left := 0
    right := len(num) - 1
    for left < right {
        mid := left + (right-left)/2
        if num[mid][1] > target {
            left = mid + 1 //注意是递减序列
        } else {
            right = mid
        }
    }
    return num[left][0]
}

func Max(a, b int) int {
    if a > b {
        return a
    }
    return b
}