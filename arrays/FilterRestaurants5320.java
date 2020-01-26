public class FilterRestaurants5320{
    public static void main(String[] args) {

    }

    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        return Stream.of(restaurants)
                .filter(r-> (veganFriendly==1?r[2]==veganFriendly:true) && r[4]<=maxDistance && r[3]<=maxPrice)
                .sorted((r1,r2)->r1[1]!=r2[1]?r2[1]-r1[1]:r2[0]-r1[0])
                .map(r->r[0])
                .collect(Collectors.toList());
    }
}