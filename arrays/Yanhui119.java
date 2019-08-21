import java.util.*;
class Yanhui119 {
    public static void main(String[] args) {
        System.out.println(getRow(30));
    }
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> res=new ArrayList<>();
        long cur=1;
        res.add((int)cur);
        for(int i=1;i<=rowIndex;i++){
            cur=cur*(rowIndex-i+1)/i;
            res.add((int)cur);
        }
        return res;
    }


    public static List<Integer> getRow(int rowIndex) {
        List<Integer> res=new ArrayList<>();
        long cur=1;
        res.add((int)cur);
        //C(i-1,rowIndex-1)
        for(int i=1;i<=rowIndex;i++){
            cur=cur*(cur-i+1)/i;
            res.add((int)cur);
        }
        return res;
    }
}