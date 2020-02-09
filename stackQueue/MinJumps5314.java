import java.util.*;
public class MinJumps5314{
    public static void main(String[] args) {

    }

    public int minJumps(int[] arr) {
        Queue<Pair> queue=new LinkedList<>();
        boolean[] visit=new boolean[arr.length];
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        //构建等值的索引 连续相同的只保留头尾
        for (int i=0;i<arr.length;i++) {
            List<Integer> lis=map.computeIfAbsent(arr[i],k->new ArrayList<>());
            if (!((i-1>=0&&arr[i-1]==arr[i]) && (i+1<arr.length&&arr[i+1]==arr[i]))){
                lis.add(i);
            }
        }
        queue.add(new Pair(0,0));
        visit[0]=true;
        while(!queue.isEmpty()){
            Pair pair=queue.poll();
            if (pair.index==arr.length-1) {
                return pair.step;
            }
            if(pair.index+1<arr.length && !visit[pair.index+1]){
                queue.add(new Pair(pair.index+1,pair.step+1));
                visit[pair.index+1]=true;
            }
            if (pair.index-1>=0 && !visit[pair.index-1]) {
                queue.add(new Pair(pair.index-1,pair.step+1));
                visit[pair.index-1]=true;
            }
            List<Integer> list=map.get(arr[pair.index]);
            for (int i=list.size()-1;i>=0;i--) {
                int idx=list.get(i);
                if (!visit[idx]) {
                    queue.add(new Pair(idx,pair.step+1));
                    visit[idx]=true;
                }
            }
        }
        return -1;
    }

    class Pair{
        int index;
        int step;
        public Pair(int index,int step){
            this.index=index;
            this.step=step;
        }
    }
}