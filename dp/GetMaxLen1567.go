//垃圾DP，面向case编程，没有case一辈子改不出来（居然还被我改对了）
//100+ms 时间复杂度O(N^2)，lc的case没能卡掉，但是应该是可以构造出一组特殊case卡掉的，懒得想了
func getMaxLen(nums []int) int {
    var n = len(nums)
    var dp = make([]int, n+1)
    if nums[0] > 0 {
        dp[0] = 1
    }
    var res = dp[0]
    for i := 1; i < n; i++ {
        if nums[i] > 0 {
            dp[i] = dp[i-1] + 1
        } else if nums[i] < 0 {
            if i-dp[i-1]-1 >= 0 && nums[i-dp[i-1]-1] < 0 {
                dp[i] = dp[i-1] + 2
                if i-dp[i-1]-2 >= 0 {
                    dp[i] += dp[i-dp[i-1]-2]
                }   
            } else {
                //从i-dp[i-1]开始找负数，然后从这个负数截断
                var cnt = 0
                for k := i-dp[i-1]; k < i; k++ {
                    if nums[k] < 0 {
                        dp[i] = dp[i-1]-cnt
                        break
                    }
                    cnt++
                }
            }
        }
        if dp[i] > res {
            res = dp[i]
        }
    }
    return res
}


//[-17,-9,17,-3,-5,-13,2,6,0]
//O(N) DP
func getMaxLen(nums []int) int {
    var n = len(nums)
    //
    var dp = make([][2]int, n+1)
    var res = 0
    for i := 1; i <= n; i++ {
        if nums[i-1] > 0 {
            dp[i][0] = dp[i-1][0] + 1
            //确保前一个数能形成的负数长度不为0，自己不能单独形成负数
            if dp[i-1][1] != 0 {
                dp[i][1] = dp[i-1][1] + 1   
            }
        } else if nums[i-1] < 0 {
            //同上
            if dp[i-1][1] != 0 {
                dp[i][0] = dp[i-1][1] + 1   
            }
            dp[i][1] = dp[i-1][0] + 1
        }
        if dp[i][0] > res {
            res = dp[i][0]
        }
    }
    return res
}