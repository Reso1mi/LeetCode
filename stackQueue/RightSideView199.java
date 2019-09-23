public class RightSideView199{
    public static void main(String[] args) {

    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if(root==null) return res;
        LinkedList<TreeNode> queue=new LinkedList<>();
        queue.add(root);
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
                if (count==1) {
                    res.add(node.val);
                }
                count--;
            }
        }
        return  res;
    }
}