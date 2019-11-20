public class NTreePreorder589{
    public static void main(String[] args) {

    }


    //递归的方式
    List<Integer> res=new LinkedList<>();

    public List<Integer> preorder(Node root) {
        dfs(root);
        return res;
    }

    public void dfs(Node root) {
        if (root==null) {
            return;
        }
        List<Node> children=root.children;
        res.add(root.val);
        for (Node node:children) {
            preorder(node);
        }
    }

    //迭代,想用板子,貌似不好写,果然板子不是万能的,以后还是尽量自己想吧,板子的解法确实没那么好理解
/*    public List<Integer> preorder(Node root) {
        Stack<Node> stack=new Stack<>();
        Node cur=root;
        while(cur!=null || !stack.isEmpty()){
            while(cur!=null){
                stack.add(cur);
                cur=cur.
            }
        }
    }*/
    public List<Integer> preorder(Node root) {
        List<Integer> res=new LinkedList<>();
        if (root==null) {
            return res;
        }
        Stack<Node> stack=new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            Node node=stack.pop();
            res.add(node.val);
            List<Node> children=node.children;
            for (int i=children.size()-1;i>=0;i--) {
                stack.add(children.get(i));
            }
        }
        return res;
    }
}