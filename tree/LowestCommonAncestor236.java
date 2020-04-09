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
        HashMap<TreeNode,TreeNode> map=new HashMap<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur=stack.poll();
            if(cur.right!=null){
                stack.push(cur.right);
                map.put(cur.right,cur);
            }
            if(cur.left!=null){
                stack.push(cur.left);
                map.put(cur.left,cur);
            }
        }
        HashSet<Integer> set=new HashSet<>();
        while(p!=null){
            set.add(p.val);
            p=map.get(p);
        }
        while(q!=null){
            if(set.contains(q.val)){
                return q;
            }
            q=map.get(q);
        }
        return null;
    }
}
