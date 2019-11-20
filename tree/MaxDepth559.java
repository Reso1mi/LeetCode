public class MaxDepth559{
    public static void main(String[] args) {
        
    }

    public int maxDepth(Node root) {
        if (root==null) {
            return 0;
        }
        int max=0;
        List<Node> children=root.children;
        for (Node node:children) {
            max=Math.max(max,maxDepth(node));
        }
        return max+1;
    }
}