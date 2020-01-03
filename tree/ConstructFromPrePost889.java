public class ConstructFromPrePost889{
    public static void main(String[] args) {

    }

    HashMap<Integer,Integer> map=new HashMap<>();

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        for (int i=0;i<post.length;i++) {
            map.put(post[i],i);
        }
        return constructFromPrePost(pre,0,pre.length-1,post,0,post.length-1);
    }

    public TreeNode constructFromPrePost(int[] pre,int preL,int preR,int[] post,int postL,int postR){
        if (preL>preR || postL>preR) {
            return null;
        }
        TreeNode root=new TreeNode(pre[preL]);
        if (preL==preR) {
            return root;
        }
        int postIndex=map.get(pre[preL+1]); //这种位置一定要注意
        int len=postIndex-postL;
        root.left=constructFromPrePost(pre,preL+1,preL+1+len,post,postL,postIndex);
        root.right=constructFromPrePost(pre,preL+2+len,preR,post,postIndex+1,postR-1);
        return root;
    }
}