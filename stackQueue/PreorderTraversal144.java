public class PreorderTraversal144{
    public static void main(String[] args) {

    }

    private List<Integer> res=new ArrayList<>();
    
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root!=null){
            res.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return res;
    }
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if (root==null) return res;
        Stack<Command> stack=new Stack<>();
        stack.push(new Command(true,root));
        while(!stack.isEmpty()){
            Command command=stack.pop();
            if (!command.isGo) {
                res.add(command.node.val);
            }else{
                TreeNode node=command.node;
                if (node.right!=null) {
                    stack.push(new Command(true,node.right));
                }
                if (node.left!=null) {
                    stack.push(new Command(true,node.left));
                }    
                stack.push(new Command(false,node));
            }
        }
        return res;
    }

    static class Command{
        boolean  isGo;
        TreeNode node;
        public Command(boolean isGo,TreeNode node){
            this.isGo=isGo;
            this.node=node;
        }
    }
}