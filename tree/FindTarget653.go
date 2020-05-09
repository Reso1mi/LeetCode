func findTarget(root *TreeNode, k int) bool {
    var inorder []int
    dfs(root, &inorder)
    i, j := 0, len(inorder)-1
    for i < j {
        if inorder[i]+inorder[j] < k {
            i++
        } else if inorder[i]+inorder[j] > k {
            j--
        } else {
            return true
        }
    }
    return false
}

func dfs(root *TreeNode, inorder *[]int) {
    if root == nil {
        return
    }
    dfs(root.Left, inorder)
    *inorder = append(*inorder, root.Val)
    dfs(root.Right, inorder)
}
