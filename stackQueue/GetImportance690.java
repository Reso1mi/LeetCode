import java.util.*;
public class GetImportance690{
    public static void main(String[] args) {

    }

    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer,Employee> map=new HashMap<>();
        for (Employee e:employees) {
            map.put(e.id,e);
        }
        Queue<Integer> queue=new LinkedList<>();
        queue.add(id);
        int res=0;
        while(!queue.isEmpty()){
            Employee cur=map.get(queue.poll());
            res+=cur.importance;
            List<Integer> subordinates=cur.subordinates;
            if (!subordinates.isEmpty()) {
                for (int eid:subordinates) {
                    queue.add(eid);
                }
            }
        }
        return res;
    }

    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer,Employee> map=new HashMap<>();
        for (Employee e:employees) {
            map.put(e.id,e);
        }
        return dfs(map,id);
    }

    public int dfs(HashMap<Integer,Employee> map,int id){
        Employee cur=map.get(id);
        int res=cur.importance;
        for (int eid:cur.subordinates) {
            res+=dfs(map,eid);
        }
        return res;
    }
}

class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};