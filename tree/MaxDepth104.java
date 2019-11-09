public class MaxDepth104{
    public static void main(String[] args) {
        
    }

    public int maxDepth(TreeNode root) {
        if (root==null) return 0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int max=0;
        while(!queue.isEmpty()){
            int count=queue.size();
            while(count>0){
                TreeNode node=queue.poll();
                if (node.left!=null) {
                    queue.add(node.left);
                }
                if (node.right!=null) {
                    queue.add(node.right);
                }
                count--;
            }
            max++;
        }
        return max;
    }
}