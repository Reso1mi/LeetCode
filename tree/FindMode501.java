public class FindMode501{
    public static void main(String[] args) {
        int[] ans=new int[]{1,2,3,4,23};
    }



    /*public int[] findMode(TreeNode root) {
        if (root==null) {
            return 
        }
    }*/

    List<Integer> res=new LinkedList<>();

    TreeNode pre=null;

    int max=0;
    
    public void inOrder(TreeNode root) {
        if (root!=null) {
            return;
        }
        inOrder(root.left);
        if (pre!=null && pre.val ==root.val) {
            sum++;
        }
        inOrder(root.right);
    }
}