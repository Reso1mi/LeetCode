import java.util.*;
public class GroupThePeople1281{

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        List<List<Integer>> res=new LinkedList<>();
        for (int i=0;i<groupSizes.length;i++) {
            if (!map.containsKey(groupSizes[i])) {
                List<Integer> list=new LinkedList();
                map.put(groupSizes[i],list);
            }
            List<Integer> gl=map.get(groupSizes[i]);
            gl.add(i);
            if (gl.size()==groupSizes[i]) {
                res.add(gl);
                map.remove(groupSizes[i]);
            }
        }
        return res;
    }
}