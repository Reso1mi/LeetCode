import java.util.*;
public class MainBi29{
    public static void main(String[] args) {

    }

    //11/3 = 4
    public int minNumberOfSemesters(int n, int[][] dependencies, int k) {
        if(dependencies==null) return (n-1)/k+1;
        List<List<Integer>> adjacency=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adjacency.add(new ArrayList<>());
        }
        for(int[] p:dependencies){
            //邻接表,注意这里别搞反了,这里记录的是p[1]所有的入度节点
            adjacency.get(p[1]).add(p[0]); 
        }
        //找出度为0的根节点
        List<Integer> roots=new ArrayList<>();
        for (int i=1;i<=n;i++) {
            boolean flag=true;
            for (int[] d:dependencies) {
                if(d[0]==n){
                    flag=false;
                    break;
                }
            }
            if(flag){
                roots.add(i);
            }
        }
        Queue<Pair> queue=new LinkedList<>();
        int res=0;
        for (int root:roots) {
            queue.add(new Pair(root,0));
        }
        //res+=roots.length()-1/k+1;
        int[] sum=new int[n+1];
        int last=0;
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            sum[pair.step]++;
            for (int tid:adjacency.get(pair.id)) {
                queue.add(new Pair(tid,pair.step+1));
            }
        }
        for (int i=0;i<sum.length;i++) {
            res += (sum[i]-1)/k+1;
        }
        return res;
    }

    class Pair{
        int id;
        int step;
        public Pair(int id,int step){
            this.id=id;
            this.step=step;
        }
    }
}