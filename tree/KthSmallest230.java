public class KthSmallest230{
    public static void main(String[] args) {


    }

    //可以中序遍历然后找到第k大的元素
    //权当复习了
    public int kthSmallest2(TreeNode root, int k) {
        Stack<TreeNode> stack=new Stack<>();
        LinkedList<Integer> res=new LinkedList<>();
        TreeNode cur=root;
        while(cur!=null || !stack.isEmpty()){
            while(cur!=null){
                stack.add(cur);
                cur=cur.left;
            }
            cur=stack.pop();
            res.add(cur.val);
            cur=cur.right;
        }
        return res.get(k-1);
    }

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        int count=0;
        while(cur!=null || !stack.isEmpty()){
            while(cur!=null){
                stack.add(cur);
                cur=cur.left;
            }
            cur=stack.pop();
            if (count==k-1) {
                return cur.val;
            }
            cur=cur.right;
            count++;
        }
        return -1;
    }


    
    public int kthSmallest(TreeNode root, int k) {
        kthSmallest(root,k);
        return res;
    }

    private int count=0;

    private int res=0;

    public void kthSmall(TreeNode root, int k) {
        if (root==null) {
            return;
        }
        kthSmall(root.left,k);
        if (count==k-1) {
            res=root.val;
            return;
        }
        count++;
        kthSmall(root.right,k);
    }

}
