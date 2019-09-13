import java.util.*;
public class NumberOfBoomerangs447{
    public static void main(String[] args) {
        int[][] points={{0,0},{1,0},{2,0}};
        System.out.println(numberOfBoomerangs(points));
    }

    public static int numberOfBoomerangs(int[][] points) {
        int res=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<points.length;i++) {
            for (int j=0;j<points.length;j++) {
                if (i!=j){
                    int dis=dis(points[i],points[j]);
                    map.put(dis,map.getOrDefault(dis,0)+1);
                }
            }
            //C2m 组合问题
            for (Integer count:map.values()) {
                if (count>1) {
                    res+=count*(count-1);
                }
            }
            map.clear();
        }
        return res;
    }

    public static int dis(int[] a,int[] b){
        return (a[0]-b[0])*(a[0]-b[0])+(a[1]-b[1])*(a[1]-b[1]);
    }
}