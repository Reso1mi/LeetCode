
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

type Codec struct {
}

func Constructor() Codec {
    return Codec{}
}

// Serializes a tree to a single string.
func (this *Codec) serialize(root *TreeNode) string {
    if root == nil {
        return ""
    }
    var queue []string
    var dfs func(root *TreeNode)
    dfs = func(root *TreeNode) {
        if root == nil {
            return
        }
        queue = append(queue, strconv.Itoa(root.Val))
        dfs(root.Left)
        dfs(root.Right)
    }
    dfs(root)
    return strings.Join(queue, ",")
}

// Deserializes your encoded data to tree.
func (this *Codec) deserialize(data string) *TreeNode {
    if data == "" {
        return nil
    }
    //fmt.Println(data)
    queue := strings.Split(data, ",")
    inOrder := make([]int, len(queue))
    for i, v := range queue {
        inOrder[i], _ = strconv.Atoi(v)
    }
    preOrder := make([]int, len(inOrder))
    copy(preOrder, inOrder)
    sort.Ints(inOrder)
    var dfs func(preOrder, inOrder []int) *TreeNode
    dfs = func(preOrder, inOrder []int) *TreeNode {
        if len(inOrder) == 0 {
            return nil
        }
        root := &TreeNode{Val: preOrder[0]}
        rootIdx := 0
        for i, v := range inOrder {
            if v == preOrder[0] {
                rootIdx = i
                break
            }
        }
        root.Left = dfs(preOrder[1:rootIdx+1], inOrder[:rootIdx])
        root.Right = dfs(preOrder[rootIdx+1:], inOrder[rootIdx+1:])
        return root
    }
    return dfs(preOrder, inOrder)
}

/**
 * Your Codec object will be instantiated and called as such:
 * obj := Constructor();
 * data := obj.serialize(root);
 * ans := obj.deserialize(data);
 */
