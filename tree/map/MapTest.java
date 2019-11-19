public class MapTest{
    public static void main(String[] args) {
        Map<Integer,Integer> map=new BSTMap<>();
        map.put(1,2);
        map.put(2,2);
        map.put(3,2);
        map.put(4,2);
        map.put(5,2);
        map.put(6,2);
        map.put(7,2);
        map.put(8,2);
        map.put(9,32131);
        map.put(11,2);
        System.out.println(map.contains(13)); //false
        System.out.println(map.getSize()); //10
        System.out.println(map.get(9)); //32131
        map.remove(9);
        System.out.println(map.get(9)); //null
        System.out.println(map.getSize()); //10
        map.set(11,1234567);
        System.out.println(map.get(11)); //1234567
    }
}
