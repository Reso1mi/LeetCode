public class Tree2str606{
    public static void main(String[] args) {
        
    }

    public String tree2str(TreeNode t) {
        StringBuilder s=new StringBuilder();
        dfs(t,s);
        return s.toString();
    }

    public void dfs(TreeNode node,StringBuilder s){
        if (node==null) {
            return;
        }
        s.append(node.val);
        if(node.left==null && node.right==null){//没有子节点
            return;
        }
        s.append("(");
        dfs(node.left,s);
        s.append(")");
        if (node.right==null) { //没有右节点
            return;
        }
        s.append("(");
        dfs(node.right,s);
        s.append(")");
    }
}