func judgePoint24(nums []int) bool {
    var eps float32 = 1e-5
    var Abs = func(a float32) float32 {
        if a < 0 {
            return -a
        }
        return a
    }
    var dfs func([]float32) bool
    dfs = func(nums []float32) bool {
        if len(nums) == 0 {
            return false
        }
        if len(nums) == 1 {
            return Abs(nums[0]-24) < eps
        }
        var n = len(nums)
        //从nums中选取2个数
        for i := 0; i < n; i++ {
            for j := 0; j < n; j++ {
                if i == j {
                    continue
                }
                //收集剩下的数字
                var rest []float32
                for k := 0; k < n; k++ {
                    if k != i && k != j {
                        rest = append(rest, nums[k])
                    }
                }
                //尝试做各种运算
                rest = append(rest, nums[i]+nums[j])
                if dfs(rest) {
                    return true
                }
                rest = rest[:len(rest)-1]

                rest = append(rest, nums[i]*nums[j])
                if dfs(rest) {
                    return true
                }
                rest = rest[:len(rest)-1]

                rest = append(rest, nums[i]-nums[j])
                if dfs(rest) {
                    return true
                }
                rest = rest[:len(rest)-1]
                if nums[j] < eps {
                    continue
                }
                rest = append(rest, nums[i]/nums[j])
                if dfs(rest) {
                    return true
                }
                rest = rest[:len(rest)-1]
            }
        }
        return false
    }
    var temp = make([]float32, len(nums))
    for i := 0; i < len(nums); i++ {
        temp[i] = float32(nums[i])
    }
    return dfs(temp)
}

//优化下写法
func judgePoint24(nums []int) bool {
    var eps float32 = 1e-5
    var Abs = func(a float32) float32 {
        if a < 0 {
            return -a
        }
        return a
    }
    //计数+-*/
    var compute = func(a, b float32) []float32 {
        return []float32{a + b, a * b, a - b, a / b}
    }
    var dfs func([]float32) bool
    dfs = func(nums []float32) bool {
        if len(nums) == 0 {
            return false
        }
        if len(nums) == 1 {
            return Abs(nums[0]-24) < eps
        }
        var n = len(nums)
        //从nums中选取2个数
        for i := 0; i < n; i++ {
            for j := 0; j < n; j++ {
                if i == j {
                    continue
                }
                //收集剩下的数字
                var rest []float32
                for k := 0; k < n; k++ {
                    if k != i && k != j {
                        rest = append(rest, nums[k])
                    }
                }
                //尝试做各种运算
                for _, v := range compute(nums[i], nums[j]) {
                    if dfs(append(rest, v)) {
                        return true
                    }
                }
            }
        }
        return false
    }
    var temp = make([]float32, len(nums))
    for i := 0; i < len(nums); i++ {
        temp[i] = float32(nums[i])
    }
    return dfs(temp)
}