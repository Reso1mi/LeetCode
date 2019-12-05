public class NextGreaterElement556{
    public static void main(String[] args) {
        NextGreaterElement556 n=new NextGreaterElement556();
        System.out.println(n.nextGreaterElement(1999999999));
    }

    public int nextGreaterElement(int n) {
        StringBuilder sb=new StringBuilder();
        while(n/10>0){
            sb.append(n%10);
            n/=10;
        }
        sb.append(n);
        System.out.println(sb);
        char[] nums=sb.reverse().toString().toCharArray();
        int len=nums.length;
        for (int i=len-1;i>0;i--) {
            if (nums[i]>nums[i-1]) { //逆序的峰值i
                if (i==0) return -1; 
                for (int j=len-1;j>=i;j--) {
                    if (nums[j]>nums[i-1]) {
                        swap(nums,j,i-1);
                        reverse(nums,i,len-1);
                        return Long.valueOf(new String(nums))>Integer.MAX_VALUE?-1:Integer.valueOf(new String(nums));
                    }
                }
            }
        }
        return -1;
    }

    public void reverse(char[] nums,int begin,int end){
        for (int i=begin,j=end;i<j;i++,j--) {
            swap(nums,i,j);
        }
    }

    public void swap(char[] nums,int a,int b){
        char temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}