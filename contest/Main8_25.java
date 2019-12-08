import java.util.*;
public class Main8_25{
    public static void main(String[] args) {
        String[] s={"alice,20,800,mtv","alice,50,100,beijing"};
        invalidTransactions(s);
    }

    public static List<String> invalidTransactions(String[] transactions) {
        Arrays.sort(transactions,(a,b)->{
            String[] as=a.split(",");
            String[] bs=b.split(",");
            return Integer.valueOf(as[1])-Integer.valueOf(bs[1]);
        });
        List<String> res=new ArrayList<>();
        HashMap<String,Integer> map=new HashMap<>();
        for (int i=0;i<transactions.length;i++) {
            String []temp=transactions[i].split(",");
            if(Integer.valueOf(temp[2])>1000){
                res.add(transactions[i]);
            }else if(map.containsKey(temp[0])){
                String[] mapStr=transactions[map.get(temp[0])].split(",");
                if(Math.abs(Integer.valueOf(mapStr[2])-Integer.valueOf(temp[2]))< 60 && !mapStr[3].equals(temp[3])){
                    res.add(transactions[i]);
                    res.add(transactions[map.get(temp[0])]);
                }
                map.remove(temp[0]);
            }else{
                map.put(temp[0],i);    
            }
        }
        return res;
    }

    public static void printArray(String[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

/*    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode temp=head;
    }*/
}