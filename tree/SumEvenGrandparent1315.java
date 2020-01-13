public class SumEvenGrandparent1315{
    public static void main(String[] args) {
        
    }

    public int sumEvenGrandparent(TreeNode root) {
        return dfs(root,-1,-1);
    }

    public int dfs(TreeNode node,int fa,int ga){
        if (node==null) {
            return 0;
        }
        int sum=0;
        if (fa!=-1 && ga!=-1 && ga%2==0) {
            sum+=node.val;
        }
        sum+=dfs(node.left,node.val,fa);
        sum+=dfs(node.right,node.val,fa);
        return sum;
    }
}