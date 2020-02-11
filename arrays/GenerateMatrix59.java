public class GenerateMatrix59{
    public static void main(String[] args) {
        
    }

    public int[][] generateMatrix(int n) {
        int[][] res=new int[n][n];
        int left=0,right=n-1;
        int val=1;
        while(left<=right){
            int a=left,b=left;
            int c=right,d=right;
            if (left==right) {
                res[left][right]=val;
            }
            while(b<right){
                res[left][b++]=val++;
            }
            while(a<right){
                res[a++][right]=val++;
            }
            while(d>left){
                res[right][d--]=val++;
            }
            while(c>left){
                res[c--][left]=val++;
            }
            left++;right--;
        }
        return  res;
    }
}