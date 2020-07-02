import java.util.*;
public class KthSmallest378{
    public static void main(String[] args) {

    }

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1,p2)->matrix[p1.x][p1.y] - matrix[p2.x][p2.y]);
        for(int i = 0;i < matrix.length; i++){
            pq.add(new Pair(i, 0));  
        } 
        while(k > 1){
            Pair pair = pq.poll();
            if(pair.y + 1 < matrix[0].length){
                pq.add(new Pair(pair.x, pair.y+1));   
            }
            k--;
        }
        return matrix[pq.peek().x][pq.peek().y];
    }
    
    class Pair{
        int x, y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n-1][n-1];
        int res = left;
        while(left <= right){
            int mid = left + (right - left)/2;
            //注意这个地方，很关键，xd，应该在大于等于的时候缩减右边界，而不是小于等于的时候缩减左边界
            //其实举个例子就懂了，假设k=2，对于结果应该是5，但是我们现在mid=8
            //这里8和5在矩阵中小于等于它们的数量是相同的，这个时候很明显应该缩短right去逼近5
            //所以我们应该在二分的大于等于区间记录答案，并且缩短right
            if (check(matrix, mid) >= k){
                res = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return res;
    }

    //检查数组中小于等于mid的个数
    public int check(int[][] matrix, int mid){
        int row = matrix.length-1, column = 0;
        int count = 0;
        int lastRow = 0; 
        while(row >= 0){
            while (column < matrix[0].length && matrix[row][column] <= mid){
                column++;
                lastRow++;
            }
            count += lastRow;
            row--;
        }
        return count;
    }
}