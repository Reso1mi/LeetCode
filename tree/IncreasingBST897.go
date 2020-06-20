func increasingBST(root *TreeNode) *TreeNode {
    var dfs func(root *TreeNode)
    dummyNode := &TreeNode{}
    last := dummyNode
    dfs = func(root *TreeNode) {
        if root == nil {
            return
        }
        dfs(root.Left)
        root.Left = nil
        last.Right = root
        last = root
        dfs(root.Right)
    }
    dfs(root)
    return dummyNode.Right
}
