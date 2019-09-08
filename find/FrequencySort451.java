import java.util.*;
public class FrequencySort451{
    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));

    }

    //TLE
    public static String frequencySort(String s) {
        if (s==null || s.length()<1) {
            return s;
        }
        HashMap<Character,Integer> map=new HashMap<>();
        for (int i=0;i<s.length();i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        ArrayList<HashMap.Entry> list=new ArrayList<>();
        for(HashMap.Entry entry:map.entrySet()){
            list.add(entry);
        }
        list.sort((e1,e2)->(Integer)e2.getValue()-(Integer)e1.getValue());
        StringBuilder res=new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            Integer value = (Integer)list.get(i).getValue();
            while (value>0){
                res.append(list.get(i).getKey());
                value--;
            }
        }
        return res.toString();
    }

    public  static String frequencySort2(String s) {
        if (s==null || s.length()<1) {
            return s;
        }
        int[] freq=new int[256];
        for (int i=0;i<s.length();i++) {
            freq[s.charAt(i)]++;
        }
        int[] freq_bak=freq.clone();
        Arrays.sort(freq);
        StringBuilder res=new StringBuilder();
        for (int i = 255; i>=0 && freq[i]!=0; i--) {
            for (int j=0;j<255;j++) {
                if(freq_bak[j]==freq[i]){
                    //根据freq_bak[j]构造结果
                    while(freq_bak[j]>0){
                        res.append((char)j);
                        freq_bak[j]--;
                    }
                    break;
                }
            }
        }
        return res.toString();
    }
}