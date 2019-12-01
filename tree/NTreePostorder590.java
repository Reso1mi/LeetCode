public class NTreePostorder590{
    public static void main(String[] args) {

    }


    List<Integer> res=new LinkedList<>();

    public List<Integer> postorder(Node root) {
        if (root==null) {
            return res;
        }
        dfs(root);
        return res;
    }

    public void dfs(Node root) {
        List<Node> children=root.children;
        for (Node node:children) {
            dfs(node);
        }
        res.add(root.val);
    }

    public List<Integer> postorder(Node root) {
        List<Integer> res=new LinkedList<>();
        if (root==null) {
            return res;
        }
        Stack<Node> stack=new Stack<>();
        stack.push(root);
        Node lastNode=null;
        while(!stack.isEmpty()){
            Node node=stack.peek();
            List<Node> children=node.children;
            if (children.isEmpty() || (lastNode!=null && lastNode == children.get(children.size()-1))) {
                res.add(node.val);
                stack.pop();
                lastNode=node;
            }else{
                for (int i=children.size()-1;i>=0;i--) {
                    stack.push(children.get(i));
                }
            }
        }
        return res;
    }
}