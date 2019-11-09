import java.util.*;
public class LevelOrderBottom107{
    public static void main(String[] args) {

    }

    //总感觉怪怪的
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null)return res;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> list=new ArrayList<>();
            int count=queue.size();
            while(count>0){
                TreeNode top=queue.poll();
                if (top.left!=null) {
                    queue.add(top.left);
                }
                if (top.right!=null) {
                    queue.add(top.right);
                }
                list.add(top.val);
                count--;
            }
            res.add(list);
        }
        //直接逆序,总感觉不太好
        Collections.reverse(res);
        return res;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null)return res;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> list=new ArrayList<>();
            int count=queue.size();
            while(count>0){
                TreeNode top=queue.poll();
                if (top.left!=null) {
                    queue.add(top.left);
                }
                if (top.right!=null) {
                    queue.add(top.right);
                }
                list.add(top.val);
                count--;
            }
            //从头添加
            res.add(0,list);
        }
        return res;
    }
}