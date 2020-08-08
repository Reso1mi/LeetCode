/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
//1 2 3 4 5
//1 3 2 4 5 | 1 4 3 2 5
//[-2147483648,3,2,5,9]
func recoverTree(root *TreeNode) {
    var node1 *TreeNode
    var node2 *TreeNode
    //这里犯了一个错误，一开始给pre赋值了一个root,导致节点记录错了
    var pre *TreeNode
    var dfs func(*TreeNode)
    dfs = func(root *TreeNode) {
        if root == nil {
            return
        }
        dfs(root.Left)
        if pre != nil && root.Val < pre.Val {
            if node1 == nil {
                node1 = pre
            }
            node2 = root
        }
        pre = root
        dfs(root.Right)
    }
    dfs(root)
    node1.Val, node2.Val = node2.Val, node1.Val
}
