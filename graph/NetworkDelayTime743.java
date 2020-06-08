public class NetworkDelayTime743{
    public static void main(String[] args) {
        
    }

    //Floyd
    public int networkDelayTime(int[][] times, int N, int K) {
        int[][] dis=new int[N][N];
        int INF = 0x3f3f3f3f;
        for(int i=0;i<N;i++) Arrays.fill(dis[i],INF);
        for(int i=0;i<N;i++) dis[i][i]=0;
        for(int[] t:times) dis[t[0]-1][t[1]-1]=t[2];
        for(int k=0;k<N;k++){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    dis[i][j]=Math.min(dis[i][j],dis[i][k]+dis[k][j]);
                }
            }
        }
        int res=0;
        K-=1; //从0开始！从1开始的都是邪教
        for(int i=0;i<N;i++){
            if(dis[K][i]==INF) return -1;
            res=Math.max(dis[K][i],res);
        }
        return res;
    }
}