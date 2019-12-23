public class LargestValues515{
    public static void main(String[] args) {
        
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        dfs(root,res,0);
        return res;
    }

    public void dfs(TreeNode node,List<Integer> list,int level){
        if (node==null) {
            return;
        }
        if (level>=list.size()) {
            list.add(node.val);
        }
        if(node.val>list.get(level)){
            list.set(level,node.val);
        }
        dfs(node.left,list,level+1);
        dfs(node.right,list,level+1);
    }

    //bfs略
}