public class HasPathSum112{

    public static void main(String[] args) {

    }

    //DFS
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root==null) {
            return false;
        }
        if (root.left==null && root.right==null&&root.val==sum) {
            return true;
        }
        return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);
    }

    //BFS
    /*public boolean hasPathSum(TreeNode root, int sum) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int count=queue.size();
            while(count>0){
                TreeNode node=queue.poll();
                if (node.left!=null) {
                    
                }
                count--;
            }
        }
    }*/
}