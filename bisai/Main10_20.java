import java.util.*;
public class Main10_20{
    public static void main(String[] args) {

    }

    public boolean checkStraightLine(int[][] coordinates) {
        HashSet<String> set=new HashSet<>();
        String slope=null;
        for (int i=0;i<coordinates.length;i++) {
            for (int j=i;j<coordinates.length;j++) {
                int dx=coordinates[i][0]-coordinates[j][0];
                int dy=coordinates[i][1]-coordinates[j][1];
                if (dx==0 && dy==0) {
                    continue;
                }
                int g=gcd(dx,dy);
                if (g!=0) {
                    dx/=g;
                    dy/=g;
                }
                if (slope==null) {
                    slope=dx+"/"+dy;
                }else if (!(dx+"/"+dy).equals(slope)) {
                    return false;
                }   
            }
        }
        return true;
    }

    public int gcd(int p,int q){
        if(q==0)return p;
        int r=p%q;
        return gcd(q,r);
    }


    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder,(s1,s2)->{
            int temp1=s1.split("/").length;
            int temp2=s2.split("/").length;
            return temp2-temp1;
        });
        List<String> res=new LinkedList<>();
        for (int i=0;i<folder.length;i++) {
            boolean flag=false;
            for (int j=i;j<folder.length;j++) {
                if (i!=j) {
                    if(startsWith(folder[i],folder[j])){
                        flag=true;
                    }
                }
            }
            if (!flag && !"/".equals(folder[i])) {
               res.add(folder[i]);  
           }
       }
       return res;
   }

    //a.startsWith(b)
   public boolean startsWith(String a,String b){
    String[] as=a.split("/");
    String[] bs=b.split("/");
    if (a.startsWith(b) && as[bs.length-1].equals(bs[bs.length-1])) {
        return true;
    }
    return false;
/*        String[] as=a.split("/");
        String[] bs=b.split("/");
        if (as.length<bs.length) {
            return false;
        }
        for (int i=0;i<bs.length; i++) {
            if (!as[i].equals(bs[i])) {
                return false;
            }
        }
        return true;*/
        
    }

    public int balancedString(String s) {
        int max = 0, start = 0, end = 0, cur = -1;
        int[] count = new int[256];
        while (end < s.length()) {
            //当前窗口出现最多的字符
            cur = Math.max(cur, ++count[s.charAt(end)]);
            //不能替换了,不同字符太多了,需要缩减窗口
            while (end - start + 1 - cur > k){
                //缩减左边界的count
                count[s.charAt(start)]--;
                start++;//不能替换了，start++
            }
            //统计最大值
            max = Math.max(max, end - start + 1);
            end++;
        }
        return max;
    }
}