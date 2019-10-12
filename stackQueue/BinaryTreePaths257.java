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

    List<String> res=new ArrayList<>();

    //DFS 回溯
    public List<String> binaryTreePaths(TreeNode root) {
        if (root==null) {
            return res;
        }
        dfs(root,new ArrayList());
        return res;
    }

    public void dfs(TreeNode root,List<Integer> lis) {
        if (root==null) {
            return;
        }
        lis.add(root.val);
        if (root!=null && root.left==null && root.right==null) {
            res.add(buildPath(lis));
        }else{
            dfs(root.left,lis);
            dfs(root.right,lis);
        }
        //回溯
        lis.remove(lis.size()-1);
    }

    private String buildPath(List<Integer> values) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < values.size(); i++) {
            str.append(values.get(i));
            if (i != values.size() - 1) {
                str.append("->");
            }
        }
        return str.toString();
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
