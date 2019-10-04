import java.util.*;
public class RestoreIpAddresses93{
    public static void main(String[] args) {
        RestoreIpAddresses93 r= new RestoreIpAddresses93();
        System.out.println(r.restoreIpAddresses("1111"));
    }

    public List<String> restoreIpAddresses(String s) {
        restoreIpAddresses(s,0,"",0);
        return res;
    }

    LinkedList<String> res=new LinkedList<>();

    public void restoreIpAddresses(String s,int index,String des,int count) {
        if (count>4) {
            return;
        }
        //到字符串末尾了
        if (index==s.length()) {
            if (count==4) {
                res.add(des.substring(0,des.length()-1));    
            }
            return;
        }
        //如果为0就不用切分了,这里就相当于直接跳过
        if (s.charAt(index)=='0') {
            restoreIpAddresses(s,index+1,des+"0.",count+1);
        }else{
            //不为0就需要继续切分为1，2，3
            //切分过程中需要注意要小于255,同时需要一个计数器来判度是否终止
            for (int i=1;i<4;i++) {
                if (index+i<=s.length()) {
                    String temp=s.substring(index,index+i);
                    if (Integer.valueOf(temp)<=255){
                        restoreIpAddresses(s,index+i,des+temp+".",count+1);    
                    }
                }
            }
        }
    }
}