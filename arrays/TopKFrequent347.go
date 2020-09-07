type Node struct {
    Val   int
    Count int
}

func topKFrequent(nums []int, k int) []int {
    var n = len(nums)
    var freq = make(map[int]int)
    for i := 0; i < n; i++ {
        freq[nums[i]]++
    }
    var nodes []*Node
    for val, count := range freq {
        nodes = append(nodes, &Node{val, count})
    }
    //7 0 1 2 9 10
    var res []int
    var left, right = 0, len(nodes) - 1
    for left <= right {
        mid := partition(nodes, left, right)
        if mid == k-1 {
            for i := 0; i <= mid; i++ {
                res = append(res, nodes[i].Val)
            }
            return res
        }
        if mid > k-1 {
            right = mid - 1
        } else {
            left = mid + 1
        }
    }
    return res
}

func partition(nums []*Node, i int, j int) int {
    //7 9 10 0 1 2
    //随机下会好一点
    var base = i
    for i < j {
        for i < j && nums[j].Count <= nums[base].Count {
            j--
        }
        for i < j && nums[i].Count >= nums[base].Count {
            i++
        }
        nums[i], nums[j] = nums[j], nums[i]
    }
    nums[i], nums[base] = nums[base], nums[i]
    return i
}