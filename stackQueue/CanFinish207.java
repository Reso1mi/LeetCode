import java.util.*;
//import java.util.stream.*;
public class CanFinish207{
    public static void main(String[] args) {

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree=new int[numCourses];
        List<List<Integer>> adjacency=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adjacency.add(new ArrayList<>());
        }
        for(int[] p:prerequisites){
            indegree[p[0]]++; //每个节点的入度值
            //邻接表,注意这里别搞反了,这里记录的是p[1]所有的出度节点
            adjacency.get(p[1]).add(p[0]); 
        }
        //课程id
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int cid=queue.poll();
            numCourses--;
            for (int id:adjacency.get(cid)) { //cid --> id
                //该节点的所有邻接节点入度--
                indegree[id]--;
                if(indegree[id]==0){
                    queue.add(id);
                }
            }
        }
        return numCourses==0;
    }
}