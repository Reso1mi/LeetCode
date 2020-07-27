//个人认为均摊时间复杂度应该是O((m+n)/2)
func countNegatives(grid [][]int) int {
    if len(grid) <= 0 {
        return 0
    }
    var count = 0
    var m = len(grid)
    var n = len(grid[0])
    var i, j = 0, 0
    for i < m && j < n {
        if grid[i][j] < 0 {
            count+= n - j
            i++
        }else{
            j++
        }
    }
    return count;
}

//O(mlogn) 只利用了行逆序的条件
func countNegatives(grid [][]int) int {
    if len(grid) <= 0 {
        return 0
    }
    var count = 0
    var m = len(grid)
    var n = len(grid[0])
    for i := 0; i < m; i++ {
        count += (n - search(grid[i]))
    }
    return count
}

func search(nums []int) int {
    var left = 0
    var right = len(nums)-1
    var res = right+1
    for left <= right {
        mid := left + (right-left)/2
        if nums[mid] < 0 {
            res = mid
            right = mid - 1
        }else{
            left = mid + 1
        }
    }
    return res
}