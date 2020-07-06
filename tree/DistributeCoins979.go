func distributeCoins(root *TreeNode) int {
    var res = 0
    dfs(root, &res)
    return res
}

func dfs(root *TreeNode, res *int) (int, int) {
    if root == nil {
        return 0, 0
    }
    lCount, lCoins := dfs(root.Left, res)
    (*res) += Abs(lCount - lCoins)
    rCount, rCoins := dfs(root.Right, res)
    (*res) += Abs(rCount - rCoins)
    return 1 + lCount + rCount, root.Val + lCoins + rCoins
}

func Abs(a int) int {
    if a < 0 {
        return -a
    }
    return a
}

//闭包的写法
func distributeCoins(root *TreeNode) int {
    var res = 0
    var Abs = func(a int) int {
        if a < 0 {
            return -a
        }
        return a
    }
    var dfs func(*TreeNode) (int, int)
    dfs = func(root *TreeNode) (int, int) {
        if root == nil {
            return 0, 0
        }
        lCount, lCoins := dfs(root.Left)
        res += Abs(lCount - lCoins)
        rCount, rCoins := dfs(root.Right)
        res += Abs(rCount - rCoins)
        return 1 + lCount + rCount, root.Val + lCoins + rCoins
    }
    dfs(root)
    return res
}
