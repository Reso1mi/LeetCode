public class WidthOfBinaryTree662{
    public static void main(String[] args) {

    }

    //DFS
    public int widthOfBinaryTree(TreeNode root) {
        if (root==null) {
            return 0;
        }
        dfs(root,0,0,new LinkedList<>());
        return max;
    }

    int max=1;

    public void dfs(TreeNode node,int depth,int index,List<Integer> leftIdxs){
        if (node==null) {
            return;
        }
        if (depth>=leftIdxs.size()) {
            leftIdxs.add(index);
        }
        max=Math.max(index-leftIdxs.get(depth)+1,max);
        dfs(node.left,depth+1,index*2,leftIdxs);
        dfs(node.right,depth+1,index*2+1,leftIdxs);
    }


    //BFS
    public int widthOfBinaryTree(TreeNode root) {
        if (root==null) {
            return 0;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        LinkedList<Integer> idxs=new LinkedList<>();
        int max=1;
        idxs.add(1);
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            while(size>0){
                TreeNode top=queue.poll();
                int index=idxs.removeFirst();
                if (top.left!=null) {
                    queue.add(top.left);
                    idxs.add(index*2);
                }
                if (top.right!=null) {
                    queue.add(top.right);
                    idxs.add(index*2+1);
                }
                size--;
            }
            if (idxs.size()!=0) {
                max=Math.max(idxs.getLast()-idxs.getFirst()+1,max);    
            }
        }
        return max;
    }
}