public class UnionFind1 implements UF{

    private int[] id; //集合ids

    public UnionFind1(int size){
        id=new int[size];
        for (int i=0;i<size;i++) {
            id[i]=i;
        }
    }

    public int getSize(){
        return id.length;
    }

    //p所属的集合ID
    private int find(int p){
        if (p<0 && p>=id.length) {
            throw new IllegalArgumentException("p is out....");
        }
        return id[p];
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
        for (int i=0;i<id.length;i++) {
            if (id[i]==qID) {
                id[i]=pID;
            }
        }
    }
}