import java.util.*;
public class ReadBinaryWatch401{
    public static void main(String[] args) {
        //System.out.println(Integer.valueOf("01"));
        ReadBinaryWatch401 r= new ReadBinaryWatch401();
        System.out.println(r.readBinaryWatch(2));
    }

    //强的一批
    public List<String> readBinaryWatch(int num) {
        List<String> ret = new ArrayList<String>();
        for(int h = 0;h<12;h++){
            for(int m = 0;m<60;m++){
                if(Integer.bitCount(h<<6|m)==num){
                    ret.add(h+(m<10?":0":":")+m);
                }
            }
        }
        return ret;
    }

    private List<String> res=new ArrayList<>();
    
    List<int[]> clock=new ArrayList(){{
        add(new int[]{1,0});
        add(new int[]{2,0});
        add(new int[]{4,0});
        add(new int[]{8,0});
        add(new int[]{0,1});
        add(new int[]{0,2});
        add(new int[]{0,4});
        add(new int[]{0,8});
        add(new int[]{0,16});
        add(new int[]{0,32});
    }};

    public List<String> readBinaryWatch(int num) {
        readBinaryWatch(num,0,new ArrayList());
        int count=res.size();
        List<String> rr=new ArrayList<>();
        for (int i=0;i<count;i++) {
            String[] temp=res.get(i).split(":");
            if (Integer.valueOf(temp[0]) >= 12) {
                continue;
            }
            rr.add(res.get(i));
        }
        return res;
    }

    public void readBinaryWatch(int num,int index,List<int[]> lis) {
        if (num==0) {
            res.add(getSum(lis));
            return;
        }
        for (int i=index;i<clock.size();i++) {
            lis.add(clock.get(i));
            readBinaryWatch(num-1,i+1,lis);
            //回溯
            lis.remove(lis.size()-1);
        }
    }

    public String getSum(List<int[]> lis){
        int h=0;
        int m=0;
        for (int[] clock:lis) {
            m+=clock[1];
            if (m>=60) {
                m=m/60;
            }
            h+=clock[0];
            h+=m%60;
            if (h==12) {
                h=0;
            }
        }
        return h+":"+(m<10?("0"+m):m);
    }

/*    public String addClock(String c1,String c2){
        if ("".equals(c1)) {
            return c2;
        }
        String[] tempC1=c1.split(":");
        String[] tempC2=c2.split(":");
        return Integer.valueOf(tempC1[0])+Integer.valueOf(tempC2[0])+":"+
        (Integer.valueOf(tempC1[1])+Integer.valueOf(tempC2[1]));
    }

    public String reduceClock(String c1,String c2){
        String[] tempC1=c1.split(":");
        char[] charMins1=tempC1[1].toCharArray();

        String[] tempC2=c2.split(":");
        char[] charMins2=tempC2[1].toCharArray();

        return Integer.valueOf(tempC1[0])-Integer.valueOf(tempC2[0])+":"+
        (Integer.valueOf(charMins1[1])-Integer.valueOf(tempC2[1]));
    }*/
}
