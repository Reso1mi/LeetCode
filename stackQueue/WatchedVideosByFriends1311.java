import java.util.*;
public class WatchedVideosByFriends1311{
    public static void main(String[] args) {

    }

    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Queue<Integer> queue=new LinkedList<>();
        int[] levels=new int[friends.length]; //这里没必要,这里用一个变量就ok了
        boolean[] visit=new boolean[friends.length];
        HashMap<String,Integer> map=new HashMap<>();
        List<Integer> flist=new ArrayList<>();
        queue.add(id);
        visit[id]=true;
        while(!queue.isEmpty()){
            int cur=queue.poll();
            int[] cfs=friends[cur];
            for (int i=0;i<cfs.length;i++) {
                if (!visit[cfs[i]]) {
                    queue.add(cfs[i]);
                    levels[cfs[i]]=levels[cur]+1;   
                    visit[cfs[i]]=true;
                    if (levels[cfs[i]] == level) {
                        flist.add(cfs[i]);
                    }
                }
            }
        }
        for (int i=0;i<flist.size();i++) {
            List<String> videos=watchedVideos.get(flist.get(i));
            for (String v:videos) {
                map.put(v,map.getOrDefault(v,0)+1);
            }
        }
        List<String> res=new ArrayList(map.keySet());
        res.sort((v1,v2)->{
            int c1=map.get(v1);
            int c2=map.get(v2);
            return c1==c2?v1.compareTo(v2):c1-c2; //相等的时候按照字典序列排序
        });
        return res;
    }
}