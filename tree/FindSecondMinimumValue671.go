/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

var INT_MAX = int(^uint(0) >> 1)

func findSecondMinimumValue(root *TreeNode) int {
	res := dfs(root)
	if res == INT_MAX {
		return -1
	}
	return res
}

func dfs(root *TreeNode) int {
	if root == nil || root.Left == nil {
		return INT_MAX
	}
	//和左右子树都不等，谁小就是谁
	if root.Val != root.Left.Val && root.Val != root.Right.Val {
		return min(root.Left.Val, root.Right.Val)
	}
	//和左右子树都相等，分别在左右子树中找第二小比较
	if root.Val == root.Left.Val && root.Val == root.Right.Val {
		return min(dfs(root.Left), dfs(root.Right))
	}
	//和左子树相等,在左子树中找第二小和右子树比较
	if root.Val == root.Left.Val {
		return min(dfs(root.Left), root.Right.Val)
	}
	//同上
	return min(dfs(root.Right), root.Left.Val)
}

func min(a, b int) int {
	if a > b {
		return b
	}
	return a
}
