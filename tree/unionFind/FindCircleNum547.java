public class FindCircleNum547{
    public static void main(String[] args) {

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

    public void unionElement(int p,int q){
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

    public int findCircleNum(int[][] M) {
        parent=new int[M.length];
        rank=new int[M.length];
        for (int i=0;i<M.length;i++) {
            parent[i]=i;
            rank[i]=1;
        }

        for (int i=0;i<M.length;i++) {
            for (int j=0;j<M.length;j++) {
                if (M[i][j]==1) {
                    unionElement(i,j);
                }
            }
        }
        int res=0;
        for (int i=0;i<parent.length;i++) {
            if (parent[i]==i) {
                res++;
            }
        }
        return res;
    }
}