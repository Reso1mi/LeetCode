public class Main1_19{
    public static void main(String[] args) {

    }

    public int maximum69Number (int num) {
        StringBuilder str=new StringBuilder(String.valueOf(num));
        for (int i=0;i<str.length();i++) {
            if (str.charAt(i)=='6') {                
                str.replace(i,i+1,"9");
                break;
            }
        }
        return Integer.valueOf(str.toString());
    }

    public List<String> printVertically(String s) {
        List<String> res=new ArrayList<>();
        String[] strs=s.split(" ");
        int max=0;
        for (String str:strs) max=Math.max(max,str.length());
        for (int i=0;i<max;i++) {
            String temp="";
            int end=0;
            for (int j=0;j<strs.length;j++) {
                if (i<strs[j].length()) {
                    temp+=strs[j].charAt(i);
                    end=j;
                }else{
                    temp+=" ";
                }
            }
            res.add(temp.substring(0,end+1));
        }
        return res;
    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return delete(root,target);
    }

    public TreeNode delete(TreeNode root,int target){
        if (root==null) {
            return null;
        }
        root.left=delete(root.left,target);
        root.right=delete(root.right,target);
        if (root.left==null && root.right==null && root.val==target) {
            return null;
        }
        return root;
    }

    //蠢啊
    public TreeNode delete(TreeNode root,int target){
        if (root==null) {
            return null;
        }
        if (root.left==null && root.right==null && root.val==target) {
            return null;
        }
        root.left=delete(root.left,target);
        root.right=delete(root.right,target);
        return root;
    }

    public int minTaps(int n, int[] ranges) {
        
    }
}