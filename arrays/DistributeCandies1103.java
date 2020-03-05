public class DistributeCandies1103{
    public static void main(String[] args) {

    }

    //暴力模拟
    public int[] distributeCandies(int candies, int num_people) {
        int[] res=new int[num_people];
        int index=0;
        for (int i=1;candies>0;i++) {
            res[index%num_people]+=Math.min(candies,i);
            candies-=i;
            index++;
        }
        return res;
    }
}