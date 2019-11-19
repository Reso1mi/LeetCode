public class WidthOfBinaryTree662{
    public static void main(String[] args) {

    }

    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            while(size>0){
                TreeNode top=queue.poll();
                if (top.left!=null) {
                    queue.add(queue.left);
                }
                size--;
            }
        }
    }
}