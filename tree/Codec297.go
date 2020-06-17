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
        return "nil"
    }
    return strconv.Itoa(root.Val) + "," + this.serialize(root.Left) + "," + this.serialize(root.Right)
}

// Deserializes your encoded data to tree.
func (this *Codec) deserialize(data string) *TreeNode {
    queue := strings.Split(data, ",")
    return this.des(&queue)
}

func (this *Codec) des(queue *[]string) *TreeNode {
    if len(*queue) == 0 {
        return nil
    }
    cur := (*queue)[0]
    *queue = (*queue)[1:]
    if cur == "nil" {
        return nil
    }
    val, _ := strconv.Atoi(cur)
    root := &TreeNode{Val: val}
    root.Left = this.des(queue)
    root.Right = this.des(queue)
    return root
}

/**
 * Your Codec object will be instantiated and called as such:
 * obj := Constructor();
 * data := obj.serialize(root);
 * ans := obj.deserialize(data);
 */
