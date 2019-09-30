public class BinaryTreePaths257{
    public static void main(String[] args) {


    }

    //DFS
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res=new ArrayList<>();
        if (root==null) return res;

        if (root!=null&&root.left==null&&root.right==null) {
            res.add(String.valueOf(root.val));
            return res;
        }
        //左子树的所有路径
        List<String> lefts=binaryTreePaths(root.left);
        //右子树的所有路径
        List<String> rights=binaryTreePaths(root.right);
        
        //在每条路径前面加上当前根节点
        for (int i=0;i<lefts.size();i++) {
            res.add(root.val+"->"+lefts.get(i));
        }
        for (int i=0;i<rights.size();i++) {
            res.add(root.val+"->"+rights.get(i));
        }
        return res;
    }

    //BFS
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res=new ArrayList<>();
        if (root==null) return res;
        Stack<TreeNode> node_stack=new Stack<>();
        Stack<String> path_stack=new Stack<>();
        node_stack.add(root);
        path_stack.add(String.valueOf(root.val));
        String path="";
        while(!node_stack.isEmpty()){
            TreeNode node=node_stack.pop();
            path=path_stack.pop();
            if (node.left==null&&node.right==null) {
                res.add(path);
            }
            if (node.left!=null) {
                node_stack.add(node.left);
                path_stack.add(path+"->"+node.left.val);
            }
            if (node.right!=null) {
                node_stack.add(node.right);
                path_stack.add(path+"->"+node.right.val);
            }
        }
        return res;
    }
}
