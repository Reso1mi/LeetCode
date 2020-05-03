func maxAncestorDiff(root *TreeNode) int {
    var res = 0
    dfs(root, 1<<30, -1>>30, &res)
    return res
}

func dfs(root *TreeNode, min, max int, res *int) {
    if root == nil {
        return
    }
    min = fmin(min, root.Val)
    max = fmax(max, root.Val)
    *res = fmax(max-min, *res)
    dfs(root.Left, min, max, res)
    dfs(root.Right, min, max, res)
}

func fmin(a, b int) int {
    if a < b {
        return a
    }
    return b
}

func fmax(a, b int) int {
    if a > b {
        return a
    }
    return b
}
