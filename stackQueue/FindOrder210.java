import java.util.*;
public class FindOrder210{

    public static void main(String[] args) {

    }

    //BFS拓扑排序
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree=new int[numCourses]; //入度数
        List<List<Integer>> adjacency=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adjacency.add(new ArrayList<>());
        }
        for(int[] pre:prerequisites){
            indegree[pre[0]]++;
            adjacency.get(pre[1]).add(pre[0]);
        }
        int k=0;
        int[] res=new int[numCourses];
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int cur=queue.poll();
            res[k++]=cur;
            for(int c:adjacency.get(cur)){
                indegree[c]--;
                if(indegree[c]==0){
                    queue.add(c);
                }
            }
        }
        return k==numCourses?res:new int[0];
    }

    //DFS的解法
    int k=0;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adjacency.add(new ArrayList<>());
        }
        int[] mark=new int[numCourses];
        int[] res=new int[numCourses];
        for(int[] pre:prerequisites){
            adjacency.get(pre[0]).add(pre[1]); //注意这个区别
        }
        for (int i=0;i<numCourses;i++) {
            if(dfs(adjacency,i,mark,res)) return new int[0];
        }
        return res;
    }

    public boolean dfs(List<List<Integer>> adj,int cur,int[] mark,int[] res){
        if(mark[cur]==1) return true;  //正在访问
        if(mark[cur]==2) return false; //节点已经访问完
        mark[cur]=1;
        for(int c:adj.get(cur)){
            if(dfs(adj,c,mark,res)){
                return true;
            }
        }
        mark[cur]=2;
        res[k++]=cur;
        return false;
    }
}