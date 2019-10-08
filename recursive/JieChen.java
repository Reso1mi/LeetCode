public class JieChen{
    public static void main(String[] args) {
        //System.out.println(jieChen(6));
        //System.out.println(ack(2,1));
        int nDisks = 3;
        doTowers(nDisks, 'A', 'B', 'C');
    }
    
    public static void doTowers(int topN, char from, char inter, char to) {
        if (topN == 1){
            System.out.println("Disk 1 from "+ from + " to " + to);
        }else {
            doTowers(topN - 1, from, to, inter);
            System.out.println("Disk "+ topN + " from " + from + " to " + to);
            doTowers(topN - 1, inter, from, to);
        }
    }



    public static int jieChen(int n){
        if (n==1) {
            return 1;
        }
        return n*jieChen(n-1);
    }

    public static int ack(int n,int m){
        if (n==1&&m==0)
            return 2;
        else if (n==0&&m>=0)
            return 1;
        else if (n>=2&&m==0)
            return n+2;
        return ack(ack(n-1,m),m-1);
    }
}