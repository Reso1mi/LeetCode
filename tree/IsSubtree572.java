public class IsSubtree572{
    public static void main(String[] args) {

    }

    //   1   1
    //  /
    // 1
    // WRONG ANSWER
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t==null && s==null) {
            return true;
        }
        if (s==null) {
            return false;
        }
        boolean b=false;
        if (s!=null&& t!=null && s.val == t.val) {
            b=isSubtree(s.left,t.left) && isSubtree(s.right,t.right);
        }
        return b | isSubtree(s.left,t) | isSubtree(s.right,t);
    }


    //RIGHT ANSWER
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t==null && s==null) {
            return true;
        }
        if (s==null) {
            return false;
        }
        boolean b=false;
        if (s!=null&& t!=null && s.val == t.val) {
            b=isSame(s,t);
        }
        return b | isSubtree(s.left,t) | isSubtree(s.right,t);
    }

    //简化代码
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s==null) {
            return false;
        }
        return isSame(s,t)| isSubtree(s.left,t) | isSubtree(s.right,t);
    }

    public boolean isSame(TreeNode s, TreeNode t){
        if (s==null && t==null) {
            return true;        
        }
        if (s==null || t==null) {
            return false;
        }
        return s.val==t.val && isSame(s.left,t.left) && isSame(s.right,t.right);
    }
}