import java.util.*;
class Yanhui119 {
    public static void main(String[] args) {
        System.out.println(getRow(30));
    }
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> res=new ArrayList<>();
        Long cur=1;
        res.add(cur.intVal());
        for(int i=1;i<=rowIndex;i++){
            cur=cur*(rowIndex-i+1)/i;
            res.add(cur.intVal());
        }
        return res;
    }
}