public class RecoverFromPreorder1028{
    public static void main(String[] args) {

    }

    public TreeNode recoverFromPreorder(String S) {
        //栈中存的是深度严格单调递增的节点
        Deque<TreeNode> stack=new ArrayDeque(); 
        int i=0;
        while(i<S.length()){
            int depth=0;
            while(i<S.length() && S.charAt(i)=='-') {
                depth++;
                i++;
            }
            int val=0;
            while(i<S.length() && S.charAt(i)>='0' && S.charAt(i)<='9'){
                val=val*10+S.charAt(i)-48;
                i++;
            }
            TreeNode node=new TreeNode(val);
            if(depth==stack.size()){ //栈的节点数量就是当前的深度
                if(!stack.isEmpty()) stack.peek().left=node;
            }else{
                while(depth!=stack.size()){
                    stack.pop();
                }
                //depth==0的只有一个根节点，是不会走这个分支的，所以这里肯定不为空
                stack.peek().right=node;
            }
            stack.push(node);
        }
        while(stack.size()!=1) stack.pop();
        return stack.pop();
    }

}