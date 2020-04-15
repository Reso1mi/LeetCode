public class PrintDiamond{
    public static void main(String[] args) {
        int N=9;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                //曼哈顿距离小于(N+1/2)
                if( Math.abs(i-N/2)+Math.abs(j-N/2)<((N+1)/2)){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }   
    }
}