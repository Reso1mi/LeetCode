import java.util.*;
public class HasGroupsSizeX914{
    public static void main(String[] args) {

    }

    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<deck.length;i++){
            map.put(deck[i],map.getOrDefault(deck[i],0)+1);
        }
        int g=-1;
        for (Integer key:map.keySet()) {
            int freq=map.get(key);
            if(g==-1) {
                g=freq;
            }else{
                if(freq<2) return false;
                g=gcd(freq,g);
            }
        }
        return g>=2;
    }

    public int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }

    public boolean hasGroupsSizeX2(int[] deck) {
        int[] hash=new int[10001];
        for(int i=0;i<deck.length;i++){
            hash[deck[i]]++;
        }
        int g=-1;
        for (int i=0;i<hash.length-1;i++) {
            if(hash[i]!=0){
                if(hash[i]<2) return false;
                g= g!=-1?gcd(g,hash[i]):hash[i];
                if(g==1) return false; //优化,提前终止
            }
        }
        return g>=2;
    }
}