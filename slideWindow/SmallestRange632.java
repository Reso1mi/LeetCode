public class SmallestRange632{
    class Node {
        int i, j;
        public Node (int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    
    //k组链表，平均m个元素，时间复杂度 O(kmlog(k))
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> nums.get(a.i).get(a.j)-nums.get(b.i).get(b.j));
        int INF = (int) 1e5+1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            pq.add(new Node(i, 0));
            max = Math.max(max, nums.get(i).get(0));
        }
        int [] res = {-INF, INF};
        while (true) {
            Node cur = pq.poll();
            //应该把val也存进去的，懒得改了
            if (max-nums.get(cur.i).get(cur.j) < res[1]-res[0]) {
                res[0] = nums.get(cur.i).get(cur.j);
                res[1] = max;
            }
            if (cur.j+1 >= nums.get(cur.i).size()) {
                break;
            }
            pq.add(new Node(cur.i, cur.j+1));
            max = Math.max(max, nums.get(cur.i).get(cur.j+1));
        }
        return res;
    }
}