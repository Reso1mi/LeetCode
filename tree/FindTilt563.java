public class FindTilt563{
    public static void main(String[] args) {

    }

    //首先想到的解法
    public int findTilt(TreeNode root) {
        if (root==null) {
            return 0;
        }
        return findTilt(root.left)+findTilt(root.right)+Math.abs(childSum(root.left)-childSum(root.right));
    }

    public int childSum(TreeNode root) {
        if (root==null) {
            return 0;
        }
        return childSum(root.left)+childSum(root.right)+root.val;
    }


    int tilt=0;

    //结果发现上面的做法傻逼了。。。其实我知道是不对的,但是不知道咋改,不过写了个嵌套递归也还行hahaha
    public int findTilt(TreeNode root) {
        childSum(root);
        return tilt;
    }

    public int childSum(TreeNode root) {
        if (root==null) {
            return 0;
        }
        int left=childSum(root.left);
        int right=childSum(root.right);
        tilt+=Math.abs(left-right);
        return left+right+root.val;
    }
}