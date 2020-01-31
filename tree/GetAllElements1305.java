public class GetAllElements1305{
    public static void main(String[] args) {

    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        //return megerList(inorder(root1),0,inorder(root2),0);
        return megerList(inorder(root1),inorder(root2));
    }

    public List<Integer> inorder(TreeNode root){
        List<Integer> res=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        while(!stack.isEmpty() || cur!=null){
            while(cur!=null){
                stack.add(cur);
                cur=cur.left;
            }
            cur=stack.pop();
            res.add(cur.val);
            cur=cur.right;
        }
        return res;
    }

    public List<Integer> megerList(List<Integer> list1,List<Integer> list2){
        List<Integer> res=new ArrayList<>();
        int index1=0,index2=0;
        while(index1<list1.size() && index2<list2.size()){
            res.add(list1.get(index1)<list2.get(index2)?list1.get(index1++):list2.get(index2++));
        }
        while(index1<list1.size()){
            res.add(list1.get(index1++));
        }
        while(index2<list2.size()){
            res.add(list2.get(index2++));
        }
        return res;
    }


    //递归的TLE了 42/48,不停的创建list太耗时了
    public List<Integer> megerList(List<Integer> list1,int index1,List<Integer> list2,int index2){
        List<Integer> res=new ArrayList<>();
        if (index1==list1.size()) {
            for (int i=index2;i<list2.size();i++) {
                res.add(list2.get(i));
            }
            return res;
        }
        if (index2==list2.size()) {
            for (int i=index1;i<list1.size();i++) {
                res.add(list1.get(i));
            }
            return res;
        }
        if (list1.get(index1)<list2.get(index2)) {
            res.add(list1.get(index1));
            res.addAll(megerList(list1,index1+1,list2,index2));
        }else{
            res.add(list2.get(index2));
            res.addAll(megerList(list1,index1,list2,index2+1));
        }
        return res;
    }
}