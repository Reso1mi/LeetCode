public class UnionFind3 implements UF{

    private int[] parent; //父ID

    private int[] sz;

    public UnionFind3(int size){
        parent=new int[size];
        sz=new int[size];
        for (int i=0;i<size;i++) {
            parent[i]=i;
            sz[i]=1;
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
            index=parent[index];
        }
        return index;
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
        if (sz[pID]>sz[qID]) {
            parent[qID]=pID;
            sz[pID]+=sz[qID];    
        }else{
            parent[pID]=qID;
            sz[qID]+=sz[pID];
        }
    }
}