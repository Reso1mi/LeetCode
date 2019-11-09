public class SortedArrayToBST108{
    public static void main(String[] args) {

    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums,0,nums.length-1);
    }

    public TreeNode sortedArrayToBST(int[] nums,int left,int right) {
        if (left>right) {
            return null;
        }
        int mid=(right-left)/2+left;
        TreeNode node=new TreeNode(nums[mid]);
        node.left=sortedArrayToBST(nums,left,mid-1);
        node.right=sortedArrayToBST(nums,mid+1,right);
        return node;
    }

/*    public int binarySearch(int[] nums,int target,int left,int right){
        int mid=left+(right-left)/2;
        if (nums[mid]>target) {
            return binarySearch(nums,target,mid+1,right);
        }else if(nums[mid]<target){
            return binarySearch(nums,target,left,mid-1);
        }
        return nums[mid];
    }*/
}