public class Rotate48{
    public static void main(String[] args) {

    }

    public void rotate(int[][] matrix) {
        if (matrix==null || matrix.length==0) {
            return;
        }
        int len=matrix.length-1;
        int lx=0,ly=0,rx=len,ry=len;
        while(lx<=rx){
            //len=ry-ly;
            for (int i=0;i<len;i++) {
                int temp=matrix[lx][ly+i];
                matrix[lx][ly+i]=matrix[rx-i][ly];
                matrix[rx-i][ly]=matrix[rx][ry-i];
                matrix[rx][ry-i]=matrix[lx+i][ry];
                matrix[lx+i][ry]=temp;
            }
            len-=2;
            lx++;ly++;
            rx--;ry--;
        }
    }
}