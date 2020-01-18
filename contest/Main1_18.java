public class Main1_18{
    public static void main(String[] args) {

    }

    String str="class Solution{public String q() {}}";
    
    public String q() {
        return str;
    }

    public String happy(int n, int[][] roads, String[] codes) {
        Queue<Pair> queue=new LinkedList<>();
        boolean[] visit=new boolean[n];
        String res="";
        int min=Integer.MAX_VALUE;
        //11 --> 0
        queue.add(new Pair(11,0,codes[11])); //fix
        visit[11]=true;
        while(!queue.isEmpty()){
            Pair cur=queue.poll();
            for (int i=0;i<roads.length;i++) {
                if (roads[i][0]==cur.cityIndex) {
                    visit[roads[i][1]]=true;
                    if (roads[i][1]==0) {
                        visit[roads[i][1]]=false;
                        if (cur.len+roads[i][2]<min) {
                            min=cur.len+roads[i][2];
                            res=cur.code+codes[roads[i][1]];
                        }
                    }
                    queue.add(new Pair(roads[i][1],cur.len+roads[i][2],cur.code+codes[roads[i][1]]));
                }else if (roads[i][1]==cur.cityIndex && !visit[roads[i][0]]) {
                    visit[roads[i][0]]=true;
                    if (roads[i][0]==0) {
                        visit[roads[i][0]]=false;
                        if (cur.len+roads[i][2]<min) {
                            min=cur.len+roads[i][2];
                            res=cur.code+codes[roads[i][0]];
                        }
                    }
                    queue.add(new Pair(roads[i][0],cur.len+roads[i][2],cur.code+codes[roads[i][0]]));
                }
            }
        }
        return res;
    }

    class Pair{
        int cityIndex;
        int len;
        String code;
        public Pair(int cityIndex,int len,String code){
            this.cityIndex=cityIndex;
            this.len=len;
            this.code=code;
        }
    }

/*    public String happy(int n, int[][] roads, String[] codes) {
        boolean[] visit=new boolean[n];
    }

    public void dfs(int n,int[][] roads,int cityIndex, String[] codes,boolean[] visit){
        for (int i=0;i<roads.length;i++) {
            if (roads[i][0]==cityIndex && !visit[roads[i][1]]) {
                dfs(roads[i][1]);
            }else if (roads[i][1]==cityIndex && !visit[roads[i][0]]) {
                queue.add(roads[i][0]);
            }
        }
    }*/

}   