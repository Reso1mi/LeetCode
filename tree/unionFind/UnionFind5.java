public class UnionFind5 implements UF{

    private int[] parent; //父ID

    private int[] rank;

    public UnionFind5(int size){
        parent=new int[size];
        rank=new int[size];
        for (int i=0;i<size;i++) {
            parent[i]=i;
            rank[i]=1;
        }
    }

    public int getSize(){
        return parent.length;
    }

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

    private int find2(int index){
        if (index<0 && index>=parent.length) {
            throw new IllegalArgumentException("index is out....");
        }
        if(parent[index]!=index){
            parent[index]=find(parent[index]);
        }
        return parent[index];
    }
    
    //判断集合ID是不是一样的
    public boolean isConnected(int p,int q){
        return find(q)==find(p);
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
}