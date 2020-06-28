func rightSideView(root *TreeNode) []int {
    var dfs func(root *TreeNode, depth int)
    var res = make([]int, 0)
    dfs = func(root *TreeNode, depth int) {
        if root == nil {
            return
        }
        if depth > len(res) {
            res = append(res, root.Val)
        }
        dfs(root.Right, depth+1)
        dfs(root.Left, depth+1)
    }
    dfs(root, 1)
    return res
}
