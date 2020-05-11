public class LowestCommonAncestor236{
    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p==root ||q==root) {
            return root;
        }
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if (left!=null && right!=null) {
            return root;
        }else if (left!=null) {
            return left;
        }else if (right!=null) {
            return right;
        }
        return null;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p==root ||q==root) {
            return root;
        }
        Deque<TreeNode> stack=new ArrayDeque<>();
        //题目说了值唯一，所以可以用Integer当键
        HashMap<Integer,TreeNode> map=new HashMap<>();
        map.put(root.val,null); //根节点
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur=stack.poll();
            if(cur.right!=null){
                stack.push(cur.right);
                map.put(cur.right.val,cur);
            }
            if(cur.left!=null){
                stack.push(cur.left);
                map.put(cur.left.val,cur);
            }
        }
        HashSet<Integer> set=new HashSet<>();
        while(p!=null){
            set.add(p.val);
            p=map.get(p.val);
        }
        while(!set.contains(q.val)){
            q=map.get(q.val);
        }
        return q;
    }
}
