public class Convert6{
    public static void main(String[] args) {
        Convert6 c=new Convert6();
        System.out.println(c.convert("LEETCODEISHIRING",4));
    }

    //LEETCODEISHIRING
    
    /* numRows = 2
    LECEIHRN
    ETODSIIG
    */

    /* numRows = 3
    L * C * I * R *
    E T O E S I I G
    E * D * H * N *
     */
    
    /* numRows = 4 , s.length=16   16 / (numsRow-1)*2
    L * * D * * R
    E * O E * I I
    E C * I H * N
    T * * S * * G
     */
    public String convert(String s, int numRows) {
        if (s==null || s.length()<=0 || numRows==1) {
            return s;
        }
        int len=s.length();
        //足够的空间
        int[][] strs=new int[((len/((numRows-1)*2))+1)*(numRows-1)][numRows];
        int index=0,x=0,y=0;
        boolean flag=false;
        while(index < s.length()) {
            if (!flag) {
                strs[x][y++]=s.charAt(index++);
                if (y==numRows-1) {
                    flag=true;
                }
            }else{
                strs[x++][y--]=s.charAt(index++);
                if (y==0) {
                    flag=false;
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        for (int j=0;j<strs[0].length;j++) {
            for (int i=0;i<strs.length;i++) {
                if (strs[i][j]!=0) {
                    sb.append((char)strs[i][j]);
                }
            }
        }
        return sb.toString();
    }

    public String convert(String s, int numRows) {
        if (s==null || s.length()<=0 || numRows==1) {
            return s;
        }
        int len=s.length();
        List<StringBuilder> row=new ArrayList<>();
        boolean flag=false;
        for (int i=0;i<; ) {
            
        }
        StringBuilder sb=new StringBuilder();
        for (int j=0;j<strs[0].length;j++) {
            for (int i=0;i<strs.length;i++) {
                if (strs[i][j]!=0) {
                    sb.append((char)strs[i][j]);
                }
            }
        }
        return sb.toString();
    }
}