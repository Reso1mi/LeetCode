public class MinDepth111{
    public static void main(String[] args) {

    }

    public int minDepth(TreeNode root) {
        if (root==null) return 0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int min=0;
        while(!queue.isEmpty()){
            int count=queue.size();
            min++;
            while(count>0){
                TreeNode node=queue.poll();
                if (node.left==null && node.right==null) {
                    return min;
                }
                if (node.left!=null) {
                    queue.add(node.left);
                }
                if (node.right!=null) {
                    queue.add(node.right);
                }
                count--;
            }
        }
        return min;
    }
}