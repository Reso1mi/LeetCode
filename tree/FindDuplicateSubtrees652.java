import java.util.*;
public class FindDuplicateSubtrees652{
    public static void main(String[] args) {

    }

    HashMap<String,Integer> map=new HashMap<>();
    
    List<TreeNode> res=new ArrayList<>();
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return res;
    }

    public String dfs(TreeNode root){
        if(root==null){
            return "#null";
        }
        String key="#"+root.val+dfs(root.left)+dfs(root.right);
        int count=map.getOrDefault(key,0);
        if(count==1){
            res.add(root);
        }
        map.put(key,count+1);
        return key;
    }
}