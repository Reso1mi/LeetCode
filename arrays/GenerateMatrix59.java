public class GenerateMatrix59{
    public static void main(String[] args) {

    }

    //正方形，稍微简单一点
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

    //通用做法，AcWing756
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = 1;
        int[][] res = new int[n][m];
        int la = 0, lb = 0;
        int ra = n-1, rb = m-1;
        while (la <= ra && lb <= rb) {
            int tla = la, tlb = lb;
            int tra = ra, trb = rb;
            if (la == ra) {
                while (tlb <= rb) res[la][tlb++] = v++;
                break;
            }
            if (lb == rb) {
                while (tla <= ra) res[tla++][rb] = v++;
                break;
            }
            while (tlb < rb) res[la][tlb++] = v++;
            while (tla < ra) res[tla++][rb] = v++;
            while (trb > lb) res[ra][trb--] = v++;
            while (tra > la) res[tra--][lb] = v++;
            la++; lb++;
            ra--; rb--;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    } 
}