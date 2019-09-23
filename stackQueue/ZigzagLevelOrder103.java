public class ZigzagLevelOrder103{
    public static void main(String[] args) {

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null)return res;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        boolean reverse=false;
        while(!queue.isEmpty()){
            LinkedList<Integer> list=new LinkedList<>();
            int count=queue.size();
            while(count>0){
                TreeNode node=queue.poll();
                if (reverse) {
                    list.addFirst(node.val);
                }else{
                    list.add(node.val);
                }
                if (node.left!=null) {
                    queue.add(node.left);
                }
                if (node.right!=null) {
                    queue.add(node.right);
                }
                count--;
            }
            reverse=!reverse;
            res.add(list);
        }
        return res;
    }
}