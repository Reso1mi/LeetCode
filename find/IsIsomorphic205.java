import java.util.*;
public class IsIsomorphic205{
    public static void main(String[] args) {

    }

    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map=new HashMap<>();
        if (s.length()!=t.length()) {
            return false;
        }

        for (int i=0;i<s.length();i++) {
            Character cs=s.charAt(i);
            Character ct=t.charAt(i);
            if(map.containsKey(cs)){
                if (map.get(cs)!=ct) {
                    return false;
                }
            }else{
                if (map.containsValue(ct)) {
                    return false;
                }
                map.put(cs,ct);
            }
        }
        return true;
    }

    public boolean isIsomorphic2(String s, String t) {
        if (s.length()!=t.length()) {
            return false;
        }
        int[] key=new int[256];
        int[] value=new int[256];

        for (int i=0;i<s.length();i++) {
            int cs=s.charAt(i);
            int ct=t.charAt(i);
            if(key[cs]!=0){ //cs出现过
                if (key[cs]!=ct) {
                    return false;
                }
            }else{//cs没出现过
                if (value[ct]!=0) {
                    return false;
                }
                key[cs]=ct;
                value[ct]=cs;
            }
        }
        return true;
    }
}