/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

func isCousins(root *TreeNode, x int, y int) bool {
    var depX = -1
    var pX *TreeNode
    var depY = -1
    var pY *TreeNode
    var dfs func(root, parent *TreeNode, x, y int, depth int)
    dfs = func(root, parent *TreeNode, x, y int, depth int) {
        if root == nil { //按题目说的这里其实不需要
            return
        }
        if root.Val == x {
            depX = depth
            pX = parent
            //结束该子树的搜索，加快速度，下面即使有Y也肯定不是X的堂兄弟
            return
        }
        if root.Val == y {
            depY = depth
            pY = parent
            //同上
            return
        }
        dfs(root.Left, root, x, y, depth+1)
        dfs(root.Right, root, x, y, depth+1)
    }
    dfs(root, nil, x, y, 0)
    return pX != pY && depX == depY
}
