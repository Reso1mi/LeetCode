public class UnionFind1 implements UF{

    private int[] id;

    public UnionFind1(int size){
        id=new int[size];
        for (int i=0;i<size;i++) {
            id[i]=i;
        }
    }

    public int getSize(){
        return id.length;
    }

    private int find(int p){
        if (p<0 && p>=id.length) {
            throw new IllegalArgumentException("p is out....");
        }
        return id[p];
    }
 
    public boolean isConnected(){
        
    }
}