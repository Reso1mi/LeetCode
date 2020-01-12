public class Main1_12{
    public static void main(String[] args) {
        Integer d=8;
        System.out.println(Integer.toBinaryString(23));
    }

    public int[] getNoZeroIntegers(int n) {
        int[] res=new int[2];
        for (int i=1;i<=n;i++) {
            if (!containsZero(i) && !containsZero(n-i)) {
                res[0]=i;
                res[1]=n-i;
            }
        }
        return res;
    }

    public boolean containsZero(int num){
        String s=String.valueOf(num);
        for (char c:s.toCharArray()) {
            if (c=='0') {
                return true;
            }
        }
        return false;
    }

    
    private int[] parent; //父ID

    private int[] rank;

    //p所属的集合ID
    private int find(int index){
        if (index<0 && index>=parent.length) {
            throw new IllegalArgumentException("index is out....");
        }
        while(parent[index]!=index){
            parent[index]=parent[parent[index]];
            index=parent[index];
        }
        return index;
    }

    public void union(int p,int q){
        int pID=find(p);
        int qID=find(q);
        if (qID==pID) {
            return;
        }
        if (rank[pID]>rank[qID]) {
            parent[qID]=pID;    
        }else if(rank[pID]<rank[qID]){
            parent[pID]=qID;
        }else{ //高度相等情况,才会增大树的高度
            parent[pID]=qID; 
            rank[qID]++;
        }
    }

    //判断集合ID是不是一样的
    public boolean isConnected(int p,int q){
        return find(q)==find(p);
    }

    public void initUF(int n){
        parent=new int[n];
        rank=new int[n];
        for (int i=0;i<n;i++) {
            parent[i]=i;
            rank[i]=1;
        }
    }

    public int makeConnected(int n, int[][] connections) {
        initUF(n);
        int more=0;
        for (int i=0;i<connections.length;i++) {
            if (isConnected(connections[i][0],connections[i][1])) {
                more++;
            }else{
                union(connections[i][0],connections[i][1]);
            }
        }
        int count=0;
        for (int i=0;i<n;i++) {
            if (parent[i]==i) {
                count++;
            }
        }
        return count-1<=more?count-1:-1;
    }



    public int minFlips(int a, int b, int c) {
        String bina=Integer.toBinaryString(a);
        String binb=Integer.toBinaryString(b);
        String binc=Integer.toBinaryString(c);
        int len=Math.max(bina.length(),Math.max(binc.length(),binb.length()));
        int res=0;
        for (int i=bina.length()-1,j=binb.length()-1,k=binc.length()-1;i>=0||j>=0||k>=0;i--,j--,k--) {
            int cc=i<0?0:binc.charAt(i)-48;
            int aa=j<0?0:bina.charAt(j)-48;
            int bb=k<0?0:binb.charAt(k)-48;
            if (cc==0) {
                if (aa==1 && bb==1) {
                    res+=2;
                }else if (aa==1 || bb==1) {
                    res+=1;
                }
            }else{
                if (aa==0 && bb==0) {
                    res+=1;
                }
            }
        }
        return res;
    }
}