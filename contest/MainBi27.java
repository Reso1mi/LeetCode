import java.util.*;
public class MainBi27{
    public static void main(String[] args) {

    }

    /*

     */
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        List<Boolean> res=new ArrayList<>();
        if(prerequisites.length==0){
            for(int i=0;i<queries.length;i++){
                res.add(false);
            }
            return res;   
        }
        List<List<Integer>> adjacency=new ArrayList<>();
        for(int i=0;i<n;i++){
            adjacency.add(new ArrayList<>());
        }
        for(int[] p:prerequisites){
            //邻接表,注意这里别搞反了,这里记录的是p[1]所有的出度节点
            adjacency.get(p[0]).add(p[1]); 
        }
        //课程id
        HashMap<Integer,HashSet<Integer>> map=new HashMap<>();
        for (int i=0;i<n;i++) {
            if(map.get(i)==null){
                map.put(i,new HashSet<>());
            }
            map.get(i).addAll(bfs(adjacency,i,n));

        }
        for(int i=0;i<queries.length;i++){
            res.add(map.get(queries[i][0]).contains(queries[i][1]));
        }
        return res;
    }

    Queue<Integer> queue=new LinkedList<>();

    List<Integer> res=new ArrayList<>();

    public List<Integer> bfs(List<List<Integer>> adjacency,int p0,int n){
        boolean[] visit=new boolean[n];
        queue.clear();    
        res.clear();    
        queue.add(p0);
        while(!queue.isEmpty()){
            int cid=queue.poll();
            visit[cid]=true;
            res.add(cid);
            //
            for (int id:adjacency.get(cid)) {
                if(!visit[id])
                queue.add(id);
            }
        }
        return res;
    }



    List<String> res2=new ArrayList<>();

    public boolean hasAllCodes(String s, int k) {
        HashSet<String> set=new HashSet<>();
        for (int i=0;i+k<=s.length();i++) {
            set.add(s.substring(i,i+k));
        }
        dfs(k,"");
        for (String ss:res2) {
            if (!set.contains(ss)) {
                return false;
            }
        }
        return true;
    }

    public void dfs(int k,String s){
        if(s.length()==k){
            res2.add(s);
            return;   
        }
        dfs(k,s+"0");
        dfs(k,s+"1");
    }
}