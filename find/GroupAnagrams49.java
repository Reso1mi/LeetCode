import java.util.*;
public class GroupAnagrams49{
    public static void main(String[] args) {

    }

    /*
     输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
     输出:
     [
       ["ate","eat","tea"],
       ["nat","tan"],
       ["bat"]
     ]
     说明：

     所有输入均为小写字母。
     不考虑答案输出的顺序。
     */

    /*public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<List<String>> res=new ArrayList<>();
        for (int i=0;i<strs.length;i++) {
            if ("7".equals(strs[i])) {
                continue;
            }
            ArrayList<String> group=new ArrayList<String>();
            group.add(strs[i]);
            for (int j=i+1;j<strs.length;j++) {
                if ("7".equals(strs[j])) {
                    continue;
                }
                if(isAnagram(strs[i],strs[j])){
                    group.add(strs[j]);
                    strs[j]="7";
                }
            }
            res.add(group);
        }
        return res;
    }*/
    
    //垃圾做法
    public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<List<String>> res=new ArrayList<>();
        for (int i=0;i<strs.length;i++) {
            if ("7"==strs[i]) {
                continue;
            }
            ArrayList<String> group=new ArrayList<String>();
            group.add(strs[i]);
            for (int j=i+1;j<strs.length;j++) {
                if ("7"==strs[j]) {
                    continue;
                }
                if(isAnagram(strs[i],strs[j])){
                    group.add(strs[j]);
                    strs[j]="7";
                }
            }
            res.add(group);
        }
        return res;
    }

    //垃圾做法2
    public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<List<String>> res=new ArrayList<>();
        boolean[] flag=new boolean[strs.length()];
        for (int i=0;i<strs.length;i++) {
            if (flag[i]) continue;
            ArrayList<String> group=new ArrayList<String>();
            group.add(strs[i]);
            for (int j=i+1;j<strs.length;j++) {
                if(flag[j])continue;
                if(isAnagram(strs[i],strs[j])){
                    group.add(strs[j]);
                    flag[j]=true;
                }
            }
            res.add(group);
        }
        return res;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();
        int[] freq=new int[26];
        for (int i=0;i<strs.length;i++) {
            char[] char_s=strs[i].toCharArray();
            //统计字符出现的频次
            for (int j=0;j<char_s.length;j++) {
                freq[char_s[j]-'a']++;
            }
            //构建唯一映射的key
            StringBuilder key=new StringBuilder();
            for (int j=0;j<26;j++) {
                key.append(freq[j]);
                //这个#很关键,为了防止重复,因为有的字符可能出现两位数的次数,仅仅对比数字是无法确定的
                key.append("#");
                //重置为0方便后面重复使用
                freq[j]=0;
            }
            String skey=key.toString();
            if(map.containsKey(skey)){
                map.get(skey).add(strs[i]);
            }else{
                map.put(skey,new ArrayList());
                map.get(skey).add(strs[i]);
            }
        }
        return new ArrayList(map.values());
    }

    //排序解法
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();
        for (int i=0;i<strs.length;i++) {
            char[] strs_i=strs[i].toCharArray();
            Arrays.sort(strs_i);
            String key=String.valueOf(strs_i);

            if(map.containsKey(key)){
                map.get(key).add(strs[i]);
            }else{
                map.put(key,new ArrayList<>());
                map.get(key).add(strs[i]);
            }
        }
        return new ArrayList(map.values());
    }

    //数组优化的
    public boolean isAnagram(String str1,String str2){
        if(str1.length()!=str2.length()){
            return false;
        }
        int[] freq=new int[26];
        for (int i=0;i<str1.length();i++) {
            freq[str1.charAt(i)-'a']++;
        }
        for (int i=0;i<str2.length();i++) {
            freq[str2.charAt(i)-'a']--;
        }
        for (int i=0;i<freq.length;i++) {
            if (freq[i]!=0) {
                return false;
            }
        }
        return true;
    }

    //通用的异构词判断
    public boolean isAnagram(String str1,String str2){
        if(str1.length()!=str2.length()){
            return false;
        }
        HashMap<Character,Integer> map=new HashMap<>();
        for (int i=0;i<str1.length();i++) {
            map.put(str1.charAt(i),map.getOrDefault(str1.charAt(i),0)+1);
        }

        for (int i=0;i<str2.length();i++) {
            if (map.get(str1.charAt(i))==0) {
                return false;
            }
            map.put(str1.charAt(i),map.get(str1.charAt(i))-1);    
        }

        for (int i=0;i<str1.length();i++) {
            if(map.get(str1.charAt(i))!=0){
                return false;
            }
        }
        return true;
    }
}