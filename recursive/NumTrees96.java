import java.util.*;
public class NumTrees96{
    public static void main(String[] args) {
        for (int i=1;i<15;i++) {
            System.out.println(numTrees2(i));
        }
    }
    
    public int numTrees3(int n) {
        long C = 1;
        for(int i = 0; i < n; ++i){
            C = C * 2 * (2 * i + 1) /(i + 2);
        }
        return (int) C;
    }

    public static int numTrees(int n) {
        return generateTree(1,n).size();
    }

    public static int numTrees2(int n) {
        if (n<=1) {
            return 1;
        }
        int []dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for (int i=2;i<=n;i++) {
            for (int j=1;j<=i;j++) {
                dp[i]+=dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }

    public static List<TreeNode> generateTree(int start,int end){
        List<TreeNode> res=new ArrayList<>();
        if (start>end) {
            //null也是一种情况，左右子树为空
            res.add(null);
            return res;
        } 
        for (int i=start;i<=end;i++) {
            List<TreeNode> left=generateTree(start,i-1);
            List<TreeNode> right=generateTree(i+1,end);
            for (TreeNode l:left) {
                for (TreeNode r:right) {
                    TreeNode currentNode=new TreeNode(i);
                    currentNode.left=l;
                    currentNode.right=r;
                    res.add(currentNode);
                }
            }
        }
        return res;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}