public class IsSubStructureJZ26{
    public static void main(String[] args) {
        
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A==null || B==null){
            return false;
        }
        return isSame(A,B) | isSubStructure(A.left,B) | isSubStructure(A.right,B);
    }

    public boolean isSame(TreeNode A,TreeNode B){
        if (B==null) { //AB同时为NULL应该返回true,所以上下不能交换
            return true;
        }
        if(A==null){
            return false;
        }
        return A.val==B.val && isSame(A.left,B.left) && isSame(A.right,B.right);
    }
}