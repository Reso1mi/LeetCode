/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
//0: 覆盖整棵树，root必须设置监控
//1: 覆盖整棵树，无论root是否设置监控
//2: 覆盖两颗子树，无论root是否被覆盖
func minCameraCover(root *TreeNode) int {
    var Min = func(a, b int) int {if a < b {return a}; return b}
    var INF = 0x3f3f3f3f
    var dfs func(root *TreeNode) [3]int 
    dfs = func (root *TreeNode) [3]int {
        var res [3]int
        if root == nil {
            return [3]int{INF, 0, 0}
        }
        left := dfs(root.Left)
        right := dfs(root.Right)
        res[0] = left[2] + right[2] + 1
        res[1] = Min(res[0], Min(left[0]+right[1], left[1]+right[0]))
        res[2] = Min(res[0], left[1] + right[1])
        return res
    }
    r := dfs(root)
    return r[1]
}