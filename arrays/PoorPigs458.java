public class PoorPigs458{
    // state = p/m+1
    // state^ x > = buckets
    // x= lg(state)bucket
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int state=minutesToTest/minutesToDie+1;
        return (int)Math.ceil(Math.log(buckets)/Math.log(state));
    }
}