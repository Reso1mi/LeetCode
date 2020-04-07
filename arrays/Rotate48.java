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

    //新解法
    public void rotate(int[][] matrix) {
        if(matrix==null || matrix.length<=0) return;
        int N=matrix.length;
        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0,k=N-1;j<k;j++,k--){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][k];
                matrix[i][k]=temp;
            }
        }
    }
}