import java.util.*;
public class WordPattern290{
    public static void main(String[] args) {
        
    }

    //这题的case有问题啊，我下面的代码居然跑过了
    public static boolean wordPattern(String pattern, String str) {
        HashMap<Character,String> map=new LinkedHashMap<>();
        String[] strs=str.split(" ");
        char[] p=pattern.toCharArray();
        if (strs.length!=p.length) {
            return false;
        }
        for (int i=0;i<p.length;i++) {
            if (map.containsKey(p[i])) {
                if (!map.get(p[i]).equals(strs[i])) {
                    return false;
                }
            }else{
                //这里直接和前一个比较的，正确做法是用map.containsValue判断是否已经添加
                /*if (strs[i].equals(strs[i-1])) {
                    return false;
                }*/
                if (map.containsValue(strs[i])) {
                    return false;           
                }
                map.put(p[i],strs[i]);
            }
        }
        return true;
    }
}