public class LongestUnivaluePath687{
    public static void main(String[] args) {

    }

    //错误解法，其实整体思路是对的，但是细节没处理好
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return res;
    }

    int res=0;

    //以root开头的单侧最长同值路径
    public int dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftMax=dfs(root.left);
        int rightMax=dfs(root.right);
        int flag=0;
        if(root.left!=null && root.left.val==root.val){
            flag++;
            leftMax++;
        }
        if(root.right!=null && root.right.val==root.val){
            flag++;
            rightMax++;
        }
        if(flag==2){
            res=Math.max(res,leftMax+rightMax);
        }
        res=Math.max(res,Math.max(leftMax,rightMax));
        return flag==0?0:Math.max(leftMax,rightMax);
    }

    //对上面的改进，其实关键还是在于理清楚递归函数的含义
    //上面的解法其实就是忽略了一个点
    //就是和左右孩子不相等的时候leftMax,rightMax应该直接置为0,而不是代入到后面计算
    public int longestUnivaluePath(TreeNode root) {
        if(root==null) return 0;
        dfs(root);
        return res;
    }

    int res=0;

    //以root开头的单侧最长同值路径
    public int dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftMax=dfs(root.left);
        int rightMax=dfs(root.right);
        if(root.left!=null){
            leftMax=root.left.val==root.val?leftMax+1:0;
        }
        if(root.right!=null){
            rightMax=root.right.val==root.val?rightMax+1:0;
        }
        res=Math.max(res,leftMax+rightMax);
        return Math.max(leftMax,rightMax);
    }
    
    //另一种dfs思路
    public int longestUnivaluePath(TreeNode root) {
        if(root==null) return 0;
        //起点的值无所谓,root节点没有父节点不用向上层函数返回值
        dfs(root,-1); 
        return res;
    }

    int res=0;

    //以 root父节点和root 开始的同值路径长度
    public int dfs(TreeNode root,int parent){
        if(root==null){
            return 0;
        }
        int leftMax=dfs(root.left,root.val);
        int rightMax=dfs(root.right,root.val);
        //这里res的计算其实3种情况都包含了
        res=Math.max(res,leftMax+rightMax);
        if(root.val==parent){
            //和父节点同值,返回左右最大值+1
            return Math.max(leftMax,rightMax)+1;
        }
        //和父节点不同值，直接返回0
        return 0;
    }
}