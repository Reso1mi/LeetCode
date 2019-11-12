public class DeleteNode450{
    public static void main(String[] args) {

    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root ==null) {
            return null;           
        }
        if (root.val>key) {
            root.left=deleteNode(root.left,key);
        }else if (root.val<key) {
            root.right=deleteNode(root.right,key);
        }else{
            if (root.left==null) {
                return root.right;
            }
            if (root.right==null) {
                return root.left;
            }
            //用右子树的最小值填补删除的元素
            TreeNode delNode=root;
            root=getMin(root.right);
            //这里的left和right不能交换,还好刚开始写错了一波,不然也不会发现,哈哈啊哈哈哈
            //这里的deleteMin是为了删除delNode的最小值root,如果你先把delNode.left连接到了root.left
            //那么root就不再是最小值了,再进行deleteMin就会导致root无法删除,最后返回root,导致root.right=root形成环
            //结果无法打印
            root.right=deleteMin(delNode.right);
            root.left=delNode.left;
        }
        return root;
    }

    public TreeNode deleteMin(TreeNode node){
        if (node.left==null) {
            return node.right;
        }
        node.left=deleteMin(node.left);
        return node;
    }

    public TreeNode getMin(TreeNode node){
        if (node.left==null) {
            return node;
        }
        return getMin(node.left);
    }
}