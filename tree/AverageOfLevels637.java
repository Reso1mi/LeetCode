public class AverageOfLevels637{
    public static void main(String[] args) {
        
    }

    public List<Double> averageOfLevels(TreeNode root) {
        if (root==null) {
            return new LinkedList<>();
        }
        Queue<TreeNode> queue=new LinkedList<>();
        List<Double> res=new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size=queue.size();
            int temp=size;
            double average=0;
            while(size-->0){
                TreeNode cur=queue.poll();
                average+=cur.val;
                if (cur.left!=null) {
                    queue.add(cur.left);
                }
                if (cur.right!=null) {
                    queue.add(cur.right);
                }
            }
            average/=temp;
            res.add(average);
        }
        return res;
    }

}