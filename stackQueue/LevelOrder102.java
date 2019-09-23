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
}