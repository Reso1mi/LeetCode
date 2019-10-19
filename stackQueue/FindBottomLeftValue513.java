public class FindBottomLeftValue513{
    public static void main(String[] args) {

    }

    //BFS
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int res=-1;
        while(!queue.isEmpty()){
            int count=queue.size();
            int temp=count;
            while(count>0){
                TreeNode node=queue.poll();
                if (count==temp) {
                    res=node.val;
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
        return res;   
    }

    //DFS
    public int findBottomLeftValue2(TreeNode root) {
        dfs(root,0);
        return res;
    }

    int res=-1,max=Integer.MIN_VALUE;

    public void dfs(TreeNode node,int depth){
        if (node==null) return;
        if (depth>max) {
            max=depth;
            res=node.val;
        }
        dfs(node.left,depth+1);
        dfs(node.right,depth+1);
    }
}