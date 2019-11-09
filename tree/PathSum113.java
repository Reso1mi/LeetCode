public class PathSum113{
    public static void main(String[] args) {

    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res=new LinkedList<>();
        if (root==null) {
            return res;
        }
        //找到叶子节点,递归出口
        if (root!=null && root.left==null && root.right==null && root.val==sum) {
            LinkedList<Integer>  lis= new LinkedList<>(); 
            lis.add(root.val);
            res.add(lis);
            return res;
        }
        //左右子树所有符合条件的路径
        List<List<Integer>> lefts=pathSum(root.left,sum-root.val);
        List<List<Integer>> rights=pathSum(root.right,sum-root.val);

        //遍历左右子树的所有路径,在前面加上当前节点的值
        for (int i=0;i<lefts.size();i++) {
            ((LinkedList<Integer>)lefts.get(i)).addFirst(root.val);
            res.add(lefts.get(i));
        }

        for (int i=0;i<rights.size();i++) {
            ((LinkedList<Integer>)rights.get(i)).addFirst(root.val);
            res.add(rights.get(i));
        }
        return res;
    }

    //BFS
    public List<List<Integer>> pathSum2(TreeNode root,int sum) {
        List<List<Integer>> res=new LinkedList<>();
        if (root==null) return res;
        //节点栈
        Stack<TreeNode> node_stack=new Stack<>();
        //路径栈
        Stack<List<Integer>> path_stack=new Stack<>();
        //节点sum栈
        Stack<Integer> sum_stack=new Stack<>();
        //给每个栈存入初始值
        node_stack.add(root);
        path_stack.add(new LinkedList(){{
            add(root.val);
        }});
        sum_stack.add(root.val);
        //BFS
        while(!node_stack.isEmpty()){
            TreeNode node=node_stack.pop();
            List<Integer> pathList=path_stack.pop();
            int tempS=sum_stack.pop();
            //终止条件
            if (node.left==null && node.right==null&&tempS==sum) {
                res.add(pathList);
                continue;
            }
            if (node.left!=null) {
                //这三个栈是同步的,node栈存放当前节点
                //path栈存放根节点到当前节点的路径
                //sum栈存放的是path栈中所有节点的val和
                node_stack.add(node.left);
                //这里不要直接操作pathList,否则左右的路径会混在一起
                LinkedList<Integer> tlis= new LinkedList(pathList);
                tlis.add(node.left.val);
                path_stack.add(tlis);
                //累加路径上的节点值
                sum_stack.add(tempS+node.left.val);
            }
            if (node.right!=null) {
                node_stack.add(node.right);
                //同上
                LinkedList<Integer> tlis= new LinkedList(pathList);
                tlis.add(node.right.val);
                path_stack.add(tlis);
                sum_stack.add(tempS+node.right.val);
            }
        }
        return res;
    }
} 