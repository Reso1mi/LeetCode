public class FindClosestElements658{
    public static void main(String[] args) {

    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left=0,right=arr.length-1;
        int count=0;
        while(left<right){
            if(Math.abs(arr[left]-x)<=Math.abs(arr[right]-x)){
                right--;
            }else{
                left++;
            }
            count++;
            if(count==arr.length-k) break;
        }
        List<Integer> res=new ArrayList<>();
        for(int i=left;i<=right;i++) res.add(arr[i]);
        return res;
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //左边界的取值范围
        int left=0,right=arr.length-k;
        while(left<right){
            int mid=left+(right-left)/2;
            if(x-arr[mid]>arr[mid+k]-x){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        List<Integer> res=new ArrayList<>();
        for(int i=left;i<left+k;i++) res.add(arr[i]);
        return res;   
    }
}