//前缀和的思路O(N)挺不错的
func pathSum(root *TreeNode, sum int) int {
    if root == nil {
        return 0
    }
    var res = 0
    //前缀和，记录一条自上而下的路径前缀和
    var preSum = make(map[int]int)
    preSum[0] = 1
    dfs(root, 0, sum, preSum, &res)
    return res
}

func dfs(root *TreeNode, sum int, target int, preSum map[int]int, res *int) {
    if root == nil {
        return
    }
    sum += root.Val
    //preSum[sum]++
    *res += preSum[sum-target]
    preSum[sum]++
    dfs(root.Left, sum, target, preSum, res)
    dfs(root.Right, sum, target, preSum, res)
    preSum[sum]--
}
