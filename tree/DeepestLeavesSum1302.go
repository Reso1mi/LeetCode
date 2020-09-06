/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func deepestLeavesSum(root *TreeNode) int {
    var dfs func(*TreeNode, int)
    var maxDep = 0
    var sum = 0
    dfs = func(root *TreeNode, dep int) {
        if root == nil {
            return
        }
        if maxDep == dep {
            sum += root.Val
        }
        if dep > maxDep {
            sum = root.Val
            maxDep = dep
        }
        dfs(root.Left, dep+1)
        dfs(root.Right, dep+1)
        
    }
    dfs(root, 0)
    return sum
}