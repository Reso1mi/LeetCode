import java.util.*;
public class EquationsPossible990{
    public static void main(String[] args) {

    }

    int[] parent;

    int[] rank;

    public int find(int p){
        if(parent[p]==p) return p;
        return parent[p]=find(parent[p]);
    }

    public void merge(int a,int b){
        int af=find(a);
        int bf=find(b);
        if(af==bf) return;
        if(rank[af]>rank[bf]){
            parent[bf]=af;
        }else if(rank[af]<rank[bf]){
            parent[af]=bf;
        }else{
            parent[af]=bf;
            rank[bf]++;
        }
    }

    public boolean equationsPossible(String[] equations) {
        parent=new int[128]; //-'a'减来减去太麻烦了,直接设个128完事
        rank=new int[128];
        //排序后先合并==,再判断!=
        //Arrays.sort(equations,(s1,s2)->s2.charAt(1)-s1.charAt(1));
        for (String eq:equations) {
            parent[eq.charAt(0)]=eq.charAt(0);
            rank[eq.charAt(0)]=1;
            parent[eq.charAt(3)]=eq.charAt(3);
            rank[eq.charAt(3)]=1;
        }
        for (String eq:equations) {
            if(eq.charAt(1)=='='){
                merge(eq.charAt(0),eq.charAt(3));
            }
        }
        for (String eq:equations) {
            if(eq.charAt(1)=='!' && find(eq.charAt(0))==find(eq.charAt(3))){
                return false;
            }
        }
        return true;
    }
}