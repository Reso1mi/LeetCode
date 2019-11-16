public class LRUTest{
    public static void main(String[] args) {
/*        LRUCache lc= new LRUCache(1);
        lc.put(2,1);
        lc.get(2);
        lc.put(3,2);
        lc.get(2);
        lc.get(3);*/


        LRUCache2 lc= new LRUCache2(1);
        lc.put(2,1);
        lc.get(2);
        lc.put(3,2);
        lc.get(2);
        lc.get(3);
    }
}