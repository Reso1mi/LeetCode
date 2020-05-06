package tree

var res int

func longestUnivaluePath(root *TreeNode) int {
	if root == nil {
		return 0
	}
	res = 0
	dfs2(root)
	return res
}
func dfs2(root *TreeNode) {
	if root == nil {
		return
	}
	dfs(root)
	dfs2(root.Left)
	dfs2(root.Right)
}

func dfs(root *TreeNode) int {
	if root == nil {
		return 0
	}
	leftMax := 0
	rightMax := 0
	if root.Left != nil && root.Left.Val == root.Val {
		leftMax = (1 + dfs(root.Left))
	}
	if root.Right != nil && root.Right.Val == root.Val {
		rightMax = (1 + dfs(root.Right))
	}
	res = Max(res, leftMax+rightMax)
	return Max(leftMax, rightMax)
}

func Max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
