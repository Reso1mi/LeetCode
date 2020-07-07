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
    //dfs返回树的节点数量 和 金币数量
    var dfs func(*TreeNode) (int, int)
    dfs = func(root *TreeNode) (int, int) {
        if root == nil {
            return 0, 0
        }
        lCount, lCoins := dfs(root.Left)
        //其实两者的差值就是需要经过该节点中转的次数
        //统计出所有节点的中转次数就是整体的转移次数
        res += Abs(lCount - lCoins)
        rCount, rCoins := dfs(root.Right)
        res += Abs(rCount - rCoins)
        return 1 + lCount + rCount, root.Val + lCoins + rCoins
    }
    dfs(root)
    return res
}

//另一种做法（其实是一种，只是写法不一样）
func distributeCoins(root *TreeNode) int {
    var res = 0
    var Abs = func(a int) int {
        if a < 0 {
            return -a
        }
        return a
    }
    //dfs返回该节点盈亏值
    var dfs func(*TreeNode) int
    dfs = func(root *TreeNode) int {
        if root == nil {
            return 0
        }
        left := dfs(root.Left)
        right := dfs(root.Right)
        res += Abs(left) + Abs(right)
        return root.Val + left + right - 1
    }
    dfs(root)
    return res
}