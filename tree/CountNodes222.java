public class CountNodes222{
    public static void main(String[] args) {

    }

    //BFS
    public int countNodes(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        if (root == null) return 0;
        queue.add(root);
        int count=1;
        while(!queue.isEmpty()){
            int nextLevel=queue.size();
            while(nextLevel>0){
                TreeNode node=queue.poll(); 
                count++;
                if (node.left!=null) {
                    queue.add(node.left);
                }
                if (node.right!=null) {
                    queue.add(node.right);
                }
                nextLevel--;
            }
        }
        return count;
    }

    //暴力
    public int countNodes(TreeNode root) {
        if (root==null) return 0;
        return countNodes(root.left)+countNodes(root.right)+1;
    }

    //利用完全二叉树的性质
    public int countNodes(TreeNode root) {
        if (root==null) return 0;
        TreeNode left=root.left;
        TreeNode right=root.right;
        int hight=0;
        while(left!=null && right!=null){
            left=left.left;
            right=right.right;
            hight++;
        }
        return left==null?(1<<hight)-1:countNodes(root.left)+countNodes(root.right)+1;
    }
}