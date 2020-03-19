public class IsRectangleOverlap836{
    public static void main(String[] args) {

    }

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x=Math.max(rec2[2]-rec1[0],rec1[2]-rec2[0]);
        int y=Math.max(rec2[3]-rec1[1],rec1[3]-rec2[1]);
        long maxX=((long)rec1[2]-(long)rec1[0]+(long)rec2[2]-(long)rec2[0]);
        long maxY=((long)rec1[3]-(long)rec1[1]+(long)rec2[3]-(long)rec2[1]);
        return x<maxX && y <maxY;
    }

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !(rec1[3]<=rec2[1]||rec2[3]<=rec1[1]||rec1[2]<=rec2[0]||rec2[2]<=rec1[0]);
    }
}