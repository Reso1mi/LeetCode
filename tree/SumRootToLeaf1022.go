/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
var mod=int(1e9+7)

func sumRootToLeaf(root *TreeNode) int {
    sum:=0;
    dfs(root,0,&sum)
    return sum
}

func dfs(root *TreeNode,cur int,sum *int){
    if root==nil{
        return
    }
    cur=(cur<<1+root.Val)%mod
    if root!=nil && root.Left==nil && root.Right==nil{
        *sum=(*sum+cur)%mod
        return
    }
    dfs(root.Left,cur,sum)
    dfs(root.Right,cur,sum)
}