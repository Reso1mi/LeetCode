import java.util.*;
public class Main10_20{
    public static void main(String[] args) {

    }

    public boolean checkStraightLine(int[][] coordinates) {
        for (int i=2;i<coordinates.length;i++) {
            if((coordinates[i][1]-coordinates[i-1][1])*(coordinates[i-1][0]-coordinates[i-2][0])!=
                (coordinates[i][0]-coordinates[i-1][0])*(coordinates[i-1][1]-coordinates[i-2][1])){
                return false;
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
        Arrays.sort(folder);
        List<String> res=new LinkedList<>();
        int root=0;
        res.add(folder[0]);
        for (int i=1;i<folder.length;i++) {
            if (!folder[i].startsWith(folder[root]+"/")) {
                res.add(folder[i]);
                root=i;
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
    }

    //放到滑动窗口专题中去了
    public int balancedString(String s) {
/*        int max = 0, start = 0, end = 0, cur = -1;
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
        return max;*/
    }
}