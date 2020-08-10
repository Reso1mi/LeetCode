public class IsCompleteTree958{
    public static void main(String[] args) {
        
    }

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode pre = root;
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            //当前节点前面出现了null
            if (pre==null && cur!=null){
                return false;
            }
            if (cur!=null) {
                queue.add(cur.left);
                queue.add(cur.right);
            }
            pre = cur;
        }
        return true;
    }
}