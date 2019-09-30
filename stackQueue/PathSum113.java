public class PathSum113{
    public static void main(String[] args) {

    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        LinkedList<LinkedList<Integer>> res=new LinkedList<>();
        if (root==null) {
            return res;
        }
        if (root!=null && root.left==null && root.right!=null && root.val==sum) {
            res.getLast().add(root.val);
        }
        LinkedList<LinkedList<Integer>> lefts=pathSum(root.left,sum-root.val);
        LinkedList<LinkedList<Integer>> rights=pathSum(root.right,sum-root.val);
        for (int i=0;i<lefts.length();i++) {
            lefts.get(i).addFirst(root.val);
        }

        for (int i=0;i<rights.length();i++) {
            lefts.get(i).addFirst(root.val);
        }
        return res;
    }
} 