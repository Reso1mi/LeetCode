public class CanMeasureWater365 {
    
    HashSet<Long> visit = new HashSet<>();
    
    public boolean canMeasureWater(int x, int y, int z) {
        Queue<int[]> queue = new LinkedList<>();
        int capX = x;
        int capY = y;
        queue.add(new int[]{x, y});
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            if (cx==z || cy==z || cx+cy==z) {
                return true;
            }
            //清空x
            addQueue(0, cy, queue);
            //清空y
            addQueue(cx, 0, queue);
            //装满x
            addQueue(capX, cy, queue);
            //装满y
            addQueue(cx, capY, queue);
            //x-->y
            addQueue(Math.max(0, cx-capY+cy), Math.min(capY, cy+cx), queue);
            //y-->x
            addQueue(Math.min(capX, cy+cx), Math.max(0, cy-capY+cx), queue);
        }
        return false;
    }
    
    public void addQueue(int x, int y, Queue<int[]> queue){
        long hashCode = x * (long)1e9+7 + y;
        if (!visit.contains(hashCode)) {
            queue.add(new int[]{x, y});
            visit.add(hashCode);
        }
    }

    public boolean canMeasureWater(int x, int y, int z) {
        if(x+y<z) return false;
        if(x==0 || y==0) return z==0 || x+y==z;
        return z%gcd(x,y)==0;
    }

    public int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
}