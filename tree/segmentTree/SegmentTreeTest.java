public class SegmentTreeTest{
    public static void main(String[] args) {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        SegmentTree<Integer> segTree = new SegmentTree<>(nums,(a,b) -> a + b);
        System.out.println(segTree);
        System.out.println(segTree.searchRange(1,5));
    }
}