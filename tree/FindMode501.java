public class FindMode501{
    public static void main(String[] args) {
        int[] ans=new int[]{1,2,3,4,23};
    }


    List<Integer> res=new LinkedList<>();
    
    int max=0,count=0;

    TreeNode pre=null;

    public int[] findMode(TreeNode root) {
        inOrder(root);
        int[] mode=new int[res.size()];
        for (int i=0;i<res.size();i++) {
            mode[i]=res.get(i);
        }
        return mode;
    }

    public void inOrder(TreeNode root) {
        if (root==null) {
            return;
        }
        inOrder(root.left);
        if (pre!=null&&pre.val==root.val) {
            count++;
        }else{
            count=1;
        }
        if (count==max) {
            res.add(root.val);
        }else if (count>max) {
            res.clear();
            res.add(root.val);
            max=count;
        }
        pre=root;
        inOrder(root.right);
    }
}