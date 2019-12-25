public class SearchMatrix240{
    public static void main(String[] args) {
        SearchMatrix240 s=new SearchMatrix240();
        int[][] m={{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println(s.searchMatrix(m,5));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length<=0 || matrix[0].length<=0){
            return false;
        }
        int m=matrix.length;
        int n=matrix[0].length;
        int  column=0,row=m-1;
        while(column<n && row>=0){
            //System.out.println(row+","+column);
            if (matrix[row][column]==target) {
                return true;
            }
            if (matrix[row][column] > target) {
                row--;
            }else{
                column++;
            }
        }
        return false;
    }
}