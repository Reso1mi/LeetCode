public class BuildTreeFromPostAndInor106{
    public static void main(String[] args) {

    }

    //后序+中序
    //其实和上一题一样,后序遍历的尾巴就是头节点
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder==null || inorder.length<=0) {
            return null;
        }
        return buildTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }

    public TreeNode buildTree(int[] inorder,int inL,int inR, int[] postorder,int pL,int pR) {
        //递归出口只需要想一下边界,比如只要一个节点的时候,很明显只有一个节点的时候这几个值都是相等的
        //但是此时肯定不能返回null,所以这里递归出口不是大于等于,而是大于
        if (inL>inR || pL>pR) { 
            return null;
        }
        TreeNode root=new TreeNode(postorder[pR]);
        int index=inL;
        while(inorder[index]!=postorder[pR]){
            index++; //一定有,所以不用担心越界的问题
        }
        root.left=buildTree(inorder,inL,index-1,postorder,pL,pL+index-inL-1);
        root.right=buildTree(inorder,index+1,inR,postorder,pL+index-inL,pR-1);
        return root;
    }

    //hash表优化
    HashMap<Integer,Integer> map=new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder==null || inorder.length<=0) {
            return null;
        }
        for (int i=0;i<inorder.length;i++) {
            map.put(inorder[i],i);
        }
        return buildTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }

    public TreeNode buildTree(int[] inorder,int inL,int inR, int[] postorder,int pL,int pR) {
        //递归出口只需要想一下边界,比如只要一个节点的时候,很明显只有一个节点的时候这几个值都是相等的
        //但是此时肯定不能返回null,所以这里递归出口不是大于等于,而是大于
        if (inL>inR || pL>pR) { 
            return null;
        }
        TreeNode root=new TreeNode(postorder[pR]);
        int index=map.get(postorder[pR]);
        root.left=buildTree(inorder,inL,index-1,postorder,pL,pL+index-inL-1);
        root.right=buildTree(inorder,index+1,inR,postorder,pL+index-inL,pR-1);
        return root;
    }
}