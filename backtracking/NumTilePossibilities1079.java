import java.util.*;
public class NumTilePossibilities1079{
    public static void main(String[] args) {
        NumTilePossibilities1079 n=new NumTilePossibilities1079();
        int res=n.numTilePossibilities("AAB");
        System.out.println(res);
    }

    //1 1 2: 1,2,11,12,112,
    public int numTilePossibilities(String tiles) {
        boolean[] visit=new boolean[tiles.length()];
        char[] cs=tiles.toCharArray();
        Arrays.sort(cs);
        numTilePossibilities(cs,visit);
        return count;
    }

    int count=-1;

    //排序去重
    public void numTilePossibilities(char[]cs,boolean[] visit) {
        count++;
        for (int i=0;i<cs.length;i++) {
            //这里为啥必须是!visit[i-1]
            if(i>0 && cs[i]==cs[i-1] && !visit[i-1]){ 
                continue;
            }
            if (!visit[i]) {
                visit[i]=true;
                numTilePossibilities(cs,visit);
                visit[i]=false;
            }
        }
    }


    //hash去重
    public void numTilePossibilities2(char[]cs,boolean[] visit) {
        count++;
        HashSet<Character> set=new HashSet<>();
        for (int i=0;i<cs.length;i++) {
            if (!visit[i] && !set.contains(cs[i])) {
                visit[i]=true;
                set.add(cs[i]);
                numTilePossibilities2(cs,visit);
                visit[i]=false;
            }
        }
    }
}