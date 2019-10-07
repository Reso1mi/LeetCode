import java.util.*;
/*
    平面上最接近的点
    算法课的题目,没有OJ只有个题目,随手写一下  
 */
public class ClosedPoint{
    public static void main(String[] args) {
       Point p1=new Point(0,0);
       Point[] points={
        new Point(0,0),
        new Point(0,2),
        new Point(0,0),
        new Point(1,4),
        new Point(0,4),
        new Point(1,1),
        new Point(3,3)
        };

       Point[] r=closePoint(points);
       System.out.println(r[0]);
       System.out.println(r[1]);
    }
    


    
    public static Point[] closePoint(Point[] points){
        //boolean[] visit=new boolean[];
        closePoint(points,0);
        return res;
    }    

    private static Point[] res=new Point[2];

    private static int minDis=Integer.MAX_VALUE;

    public static void closePoint(Point[] points,int index){
        for (int i=index;i<points.length;i++) {
            for (int j=i+1;j<points.length;j++) {
                int temp=dis(points[i],points[j]);
                if (dis(points[i],points[j])<minDis) {
                    minDis=temp;
                    res[0]=points[i];
                    res[1]=points[j];
                }
            }
            closePoint(points,i+1);
        }
    }

    public static int dis(Point point1,Point point2){
        return (point1.x-point2.x)*(point1.x-point2.x)+(point1.y-point2.y)*(point1.y-point2.y);
    }

/*    public int closePoint(Point[] points,boolean[] visit){
        Queue<Point> queue=new LinkedList<>();
        queue.add(points[0]);
        while(!queue.isEmpty()) {
            Point top=queue.pop();
            for (int i=0;i<; ) {

            }
        }
    }   */
}

class Point{
    int x;
    int y;
    public Point(int x,int y){
        this.x=x;
        this.y=y;
    }
    public String toString(){
        return x+","+y;
    }
}