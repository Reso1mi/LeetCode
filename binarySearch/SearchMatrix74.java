public class SearchMatrix74{

    public static void main(String[] args) {
        SearchMatrix74 c=new SearchMatrix74();
        int[][] matrix={{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        //int[][] matrix={{1},{3}};
        /*
        [[-8,-6,-6,-4,-2,-1,-1,-1,0,1,2,4,6,7,7],
        [10,10,12,13,13,14,14,16,17,17,17,17,17,18,19],
        [22,24,26,28,29,31,32,34,34,34,34,36,38,39,39],
        [40,40,41,43,43,44,46,47,49,49,50,52,53,55,55],
        [56,57,59,61,62,64,65,65,66,67,68,68,69,70,71],
        [74,75,77,77,79,79,79,80,81,83,85,87,88,89,89],
        [91,93,94,96,97,98,99,99,100,100,102,104,105,107,107],
        [110,112,114,114,115,117,117,118,118,120,120,121,123,124,124],
        [127,127,129,131,133,134,134,135,137,139,139,140,142,143,144],
        [145,146,147,149,151,151,153,155,156,156,158,160,162,162,163]]
        */
        //int[][] matrix={{-10,-10},{-9,-9},{-8,-6},{-4,-2},{1,1},{3,3},{5,5},{6,8}};
        System.out.println(c.searchMatrix(matrix,11));
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        if(matrix==null || matrix.length<=0 || matrix[0].length<=0){
            return false;
        }
        int m=matrix.length;
        int n=matrix[0].length;
        int low=0,high=m-1;
        if (target>matrix[m-1][n-1] || target < matrix[0][0]) {
            return false;
        }
        while(low<=high){ //二分确定在哪一行
            int mid=low+(high-low)/2;
            if (target == matrix[mid][0]) {
                return true;
            }else if(matrix[mid][0]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        int column=low!=0?low-1:low;
        low=0;
        high=n-1;
        while(low<high){
            int mid=low+(high-low)/2;
            if (matrix[column][mid]==target) {
                return true;
            }else if(matrix[column][mid] < target){
                low=mid+1; 
            }else{
                high=mid-1;
            }
        }
        return target==matrix[column][low];
    }

    //将二维的数组拉成一唯的
    // 1 2 3
    // 4 5 6
    // 7 8 9
    // 9 9 9
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length<=0 || matrix[0].length<=0){
            return false;
        }
        int m=matrix.length;
        int n=matrix[0].length;
        int left=0,right=m*n-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(matrix[mid/n][mid%n]<target){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return matrix[left/n][left%n]==target;
    }
}