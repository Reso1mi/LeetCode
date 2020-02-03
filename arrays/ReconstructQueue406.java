public class ReconstructQueue406{
    public static void main(String[] args) {

    }

    /*
    输入:
    [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
    输出:
    [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
     */
    

    public int[][] reconstructQueue(int[][] people) {
        if (people==null ||people.length<=0) {
            return new int[0][0];
        }
        List<int[]> res=new LinkedList<>();
        Arrays.sort(people,(p1,p2)->p1[0]!=p2[0]?p2[0]-p1[0]:p1[1]-p2[1]);
        for (int i=0;i<people.length;i++) {
            res.add(people[i][1],people[i]);
        }
        return res.toArray(new int[0][0]);
    }

    //[5,0] [7,0] [6,1] [7,1] [5,2] [4,4]
    //1.(h,k)<(h+n,k) n>0
    //2.(h,k)<(h,k+n) n>0
    //3.(h,k)之前至少k个数,也就是至少是在people[k]位置
    
    //WRONG
    public int[][] reconstructQueue(int[][] people) {
        int last=0;
        for (int i=0;i<people.length;i++) {
            int min=i;
            for (int j=i;j<people.length;j++) {
                if (people[j][1]>=last) {
                    min=people[j][0]<people[min][0]?j:min;
                }
            }
            last=people[min][1];
            swap(people,i,min);
        }
    }

    public void swap(int[][] num,int a,int b){
        int temp=num[a];
        num[a]=num[b];
        num[b]=temp;
    }
}