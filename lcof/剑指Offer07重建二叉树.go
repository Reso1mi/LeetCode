/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func buildTree(p []int, in []int) *TreeNode {
    // 中 左 右
    // 左 中 右
    if len(p) == 0 {
        return nil
    }
    k := 0
    for i, v := range in {
        if v == p[0] {
            k = i
            break
        }
    }
    root := new(TreeNode)
    root.Val = p[0]
    root.Left = buildTree(p[1:1+k], in[:k])
    root.Right = buildTree(p[1+k:], in[k+1:])
    return root
}