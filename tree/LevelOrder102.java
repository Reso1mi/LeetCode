import java.util.*;
public class LevelOrder102{
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if (root==null)return res;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            //count代表的其实就是每一层的节点个数
            int count=queue.size();
            List<Integer> list=new ArrayList<>();
            while(count>0){
                //取出当前节点,并将其左右子节点入队列
                TreeNode node=queue.poll();
                list.add(node.val);
                if (node.left!=null) {
                    queue.add(node.left);
                }
                if (node.right!=null) {
                    queue.add(node.right);
                }
                count--;
            }
            res.add(list);
        }
        return res;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, root, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, TreeNode root, int depth) {
        if (root == null) return;
        if (res.size() == depth) res.add(new LinkedList<>());
        res.get(depth).add(root.val);
        helper(res, root.left, depth + 1);
        helper(res, root.right, depth + 1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if (root ==null) {
            return res;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        res.add(Arrays.asList(root.val));
        while(!queue.isEmpty()){
            int count=queue.size();
            ArrayList<Integer> lis=new ArrayList<>();
            while(count>0){
                TreeNode node=queue.poll();
                if (node.left!=null) {
                    queue.add(node.left);
                    lis.add(node.left.val);
                }

                if (node.right!=null) {
                    queue.add(node.right);
                    lis.add(node.right.val);
                }
                count--;
            }
            if (!lis.isEmpty()) {
                res.add(lis);   
            }            
        }
        return res;
    }
}