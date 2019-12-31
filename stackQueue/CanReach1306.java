public class CanReach1306{

    public static void main(String[] args) {

    }

    //BFS
    public boolean canReach(int[] arr, int start) {
        boolean[] visit=new boolean[arr.length];
        Queue<Integer> queue=new LinkedList<>();
        queue.add(start);
        visit[start]=true;
        while(!queue.isEmpty()){
            int cur=queue.poll();
            if (arr[cur] == 0) {
                return true;
            }
            if (cur-arr[cur]>=0 && !visit[cur-arr[cur]]) {
                queue.add(cur-arr[cur]);
                visit[cur-arr[cur]]=true;
            }
            if (cur+arr[cur]<arr.length && !visit[cur+arr[cur]]) {
                queue.add(cur+arr[cur]);
                visit[cur+arr[cur]]=true;
            }
        }
        return false;
    }

    //DFS
    public boolean canReach(int[] arr,int start){
        boolean[] visit=new boolean[arr.length];
        return dfs(arr,start,visit);
    }

    public boolean dfs(int[] arr,int index,boolean[] visit){
        if (arr[index] == 0) {
            return true;
        }
        visit[index]=true;
        boolean b=false;
        if (index-arr[index] >=0 && !visit[index-arr[index]]) {
            b=dfs(arr,index-arr[index],visit);
        }
        if (index+arr[index] <arr.length && !visit[index+arr[index]]) {
            return b|dfs(arr,index+arr[index],visit);
        }
        return b;
    }
}