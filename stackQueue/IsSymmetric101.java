public class IsSymmetric101{
    public static void main(String[] args) {

    }

    //dfs 递归解法
    public boolean isSymmetric(TreeNode root) {
        if (root ==null) {
            return true;
        }
        //转换为求左右子树是否镜像对称的问题
        return isSymmetric(root.left,root.right);
        //return isSymmetric(root,root);
    }

    public boolean isSymmetric(TreeNode t1,TreeNode t2) {
        if (t1==null && t2==null) {
            return true;
        }
        //有一个为null
        if (t1== null || t2==null) {
            return false;
        }
        //都不为null
        return t1.val==t2.val && isSymmetric(t1.left,t2.right) && isSymmetric(t1.right,t2.left);
    }


    //非递归解法
    public boolean isSymmetric(TreeNode root) {
        if (root ==null) {
            return true;
        }
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while(!stack.isEmpty()){
            TreeNode t1=stack.pop();
            TreeNode t2=stack.pop();
            if (t1==null && t2==null) {
                continue;
            }
            if (t1==null||t2==null || t1.val!=t2.val) {
                return false;
            }
            /*if (t1.val!=t2.val) {
                return false;
            }*/
            stack.push(t1.left);
            stack.push(t2.right);
            stack.push(t1.right);
            stack.push(t2.left);
        }
        return true;
    }    


    //[1,2,2,2,null,2] 忘了还有这样的case了,哭了
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<Integer[]> lis=new ArrayList<>();
        preTravle(root,lis,0); 
        for (int i=0,j=lis.size()-1;i<=j;i++,j--) {
            if (lis.get(i)[0]!= lis.get(j)[0] ||  lis.get(j)[1]!= lis.get(i)[1]) {
                return false;
            }
        }
        return true;
    }


    //前序遍历
    public void preTravle(TreeNode node,List<Integer[]> lis,int k){
        if (node!=null) {
            preTravle(node.left,lis,k+1);
            Integer[] temp=new Integer[2];
            temp[0]=node.val;
            temp[1]=k;
            lis.add(temp);
            preTravle(node.right,lis,k+1);
        }
    }



    //前序遍历,这样写不好判断层数
/*    public List<Integer> preTravle(TreeNode node){
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=node;
        List<Integer> res=new ArrayList<>();
        while(cur!=null || !stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            //没有左子树了
            cur=stack.pop();
            res.add(cur.val);
            cur=cur.right;
        }
        return res;
    }*/


    //BFS
    public boolean isSymmetric(TreeNode root) {
        if (root ==null) {
            return true;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int count=queue.size();
            ArrayList<Integer> lis=new ArrayList<>();
            while(count>0){
                TreeNode node=queue.poll();
                if (node.left!=null) {
                    queue.add(node.left);
                    lis.add(node.left.val);
                }else{
                    lis.add(-1);
                }

                if (node.right!=null) {
                    queue.add(node.right);
                    lis.add(node.right.val);
                }else{
                    lis.add(-1);
                }
                count--;
            }

            for (int i=0,j=lis.size()-1;i<=j;i++,j--) {
                if (lis.get(i)!=lis.get(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}