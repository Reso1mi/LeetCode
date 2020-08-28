public class VerifyPostorderJZ33{
    public static void main(String[] args) {

    }

    public boolean verifyPostorder(int[] postorder) {
        if(postorder==null || postorder.length<=0) return true;
        return verify(postorder,0,postorder.length-1);
    }

    public boolean verify(int[] postorder,int left,int right){
        if(left>=right) return true;
        int root=postorder[right];
        //WA点,这里要设置成left-1防止没有左子树的情况,比如
        //5 4 3 2 1
        int index=left-1;
        for(int i=right-1;i>=left;i--){
            if(postorder[i]<root){
                index=i; //找到第一个小于root的,作为左子树的根
                break;
            }
        }
        //判断左子树是否都是小于root的
        for(int i=index;i>=left;i--){
            if(postorder[i]>root){
                return false;
            }
        }
        //递归验证左右子树
        return verify(postorder,left,index) && verify(postorder,index+1,right-1);
    }

    //WA 3
    //1 2 3 4 5
    public boolean verify(int[] postorder,int left,int right){
        if(left>=right) return true;
        int root=postorder[right];
        int index=right-1;
        for(int i=right-1;i>=left;i--){
            if(postorder[i]<root){
                index=i; //找到第一个小于root的,作为右子树的根
                break;
            }
        }
        //判断右子树是否都是小于root的
        for(int i=index;i>=left;i--){
            if(postorder[i]>root){
                return false;
            }
        }
        //递归验证左右子树
        return verify(postorder,left,index) && verify(postorder,index+1,right-1);
    }

    /*    public boolean verify(int[] postorder,int left,int right){
        if(left>=right) return true;
        int root=postorder[right];
        int index=right;
        boolean flag=false;
        for(int i=left;i<right;i++){
            if(postorder[i]>root){
                index=i;
                flag=true;
            }
            if(flag && postorder[i] < root){
                return false;
            }
        }
        //验证左右子树
        return verify(postorder,left,index-1) && verify(postorder,index,right-1);
    }*/

    //单调栈解法
    public boolean verifyPostorder(int[] postorder) {
        if(postorder==null || postorder.length<=0) return true;
        Deque<Integer> stack=new ArrayDeque<>();
        //1 2 | 4 5 | 3
        int curRoot=Integer.MAX_VALUE;
        for(int i=postorder.length-1;i>=0;i--){
            if(postorder[i]>curRoot){
                return false;
            }
            while(!stack.isEmpty() && postorder[i]<postorder[stack.peek()]){
                curRoot=postorder[stack.pop()];
            }
            stack.push(i);
        }
        return true;
    }
}