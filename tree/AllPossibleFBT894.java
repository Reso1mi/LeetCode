public class AllPossibleFBT894{
    public static void main(String[] args) {

    }

    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> res=new ArrayList<>();
        if(N%2==0) return res; //偶数提前返回，加快速度
        if(N==1){
            res.add(new TreeNode(0));
            return res;  
        }
        N--; //减去根节点
        for(int i=1;i<N;i+=2){ //将左右子树划分位两个奇数
            List<TreeNode> lefts=allPossibleFBT(i);
            List<TreeNode> rights=allPossibleFBT(N-i);
            for(TreeNode le:lefts){
                for(TreeNode ri:rights){
                    //一路从最外层移动到这里。。。。
                    TreeNode root=new TreeNode(0); 
                    root.left=le;
                    root.right=ri;
                    res.add(root);
                }
            }
        }
        return res;
    }
}