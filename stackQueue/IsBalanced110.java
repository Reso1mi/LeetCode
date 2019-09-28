public class IsBalanced110{

    public static void main(String[] args) {


    }

    /*
               1
              / \
             2   2
            / \
           3   3
          / \
         4   4
     */
    
    private boolean ans=true;

    //buttom 2 top
    public boolean isBalanced(TreeNode root) {
        if (root==null) return true;
        hight(root);
        return ans;
    }

    public int hight(TreeNode root){
        if (root==null) {
            return 0;
        }
        int left=hight(root.left);
        int right=hight(root.right);
        if (Math.abs(left-right)>1) {
            ans=false;        
        }
        return Math.max(left,right)+1;
    }


    //top 2 buttom
    public boolean isBalanced(TreeNode root) {
        if (root==null) return true;
        if (Math.abs(hight(root.left)-hight(root.right))>1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int hight(TreeNode root){
        if (root==null) {
            return 0;
        }
        return Math.max(hight(root.right),hight(root.left))+1;
    }
}