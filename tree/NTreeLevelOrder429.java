public class NTreeLevelOrder429{
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res=new LinkedList<>();
        if (root==null) {
            return res;
        }
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int count=queue.size();
            List<Integer> temp=new LinkedList<>();
            while(count>0){
                Node node=queue.poll();
                temp.add(node.val);
                for (Node child:node.children) {
                    queue.add(child);
                }
                count--;
            }
            if (!temp.isEmpty()) {
                res.add(temp);   
            }
        }
        return res;
    }
}