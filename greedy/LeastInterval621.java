import java.util.*;
public class LeastInterval621{
    public static void main(String[] args) {
        
    }

    public int leastInterval(char[] tasks, int n) {
        int[] map=new int[26];
        for (int i=0;i<tasks.length;i++) {
            map[tasks[i]-'A']++;
        }
        int res=0;
        Queue<Integer> queue=new PriorityQueue<>();
        for (int count:map) {
            queue.add(count);
        }
        while(!queue.isEmpty()){
            int len=n+1;
            List<Integer> taskLists=new LinkedList<>();
            for (int i=0;i<len;i++) {
                int task=queue.poll();
                taskLists.add(task);
            }
        }
    }

    public int leastInterval2(char[] tasks, int n) {
        int[] map=new int[26];
        for (int i=0;i<tasks.length;i++) {
            map[tasks[i]-'A']++;
        }
        //找最大值
        int max=-1;
        for (int i=0;i<map.length;i++) {
            max=Math.max(map[i],max);
        }
        int maxCount=0;
        for (int i=0;i<map.length;i++) {
            if (map[i]==max) {
                maxCount++;
            }
        }
        //比如 a b c d e f g
        return Math.max((n+1)*(max-1)+maxCount,tasks.length);
    }
}