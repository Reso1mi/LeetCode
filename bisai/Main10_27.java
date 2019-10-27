import java.util.*;
public class Main10_27{
    public static void main(String[] args) {
        Main10_27 m=new Main10_27();
        System.out.println(m.maxLength(Arrays.asList("jnfbyktlrqumowxd","mvhgcpxnjzrdei")));
    }

/*    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res=new ArrayList<>();
        for (int i=1;i<=1000;i++) {
            List<Integer> temp=new ArrayList<>();
            for (int j=1;j<=1000;j++) {
                if (customfunction.f(i,j)==z) {
                    temp.add(i);
                    temp.add(j);
                }
            }
            if (!temp.isEmpty()) {
                res.add(temp);   
            }
        }
        return res;
    }*/


    int max=-1;

    public int maxLength(List<String> arr) {
        String[] strs=new String[arr.size()];
        for (int i=0;i<arr.size();i++) {
            strs[i]=arr.get(i);
        }
        HashMap<Integer,int[]> hash =new HashMap<>();
        for (int i=0;i<strs.length;i++) {
            int[] temp=new int[26];
            for (int j=0;j<strs[i].length();j++) {
                temp[strs[i].charAt(j)-'a']++;
            }
            if (!isValid(temp)) {
                strs[i]="";
                hash.put(i,new int[26]);
            }else{
                hash.put(i,temp);
            }
        }
        dfs(strs,0,"",hash);
        return max;
    }

    public void dfs(String[] arrs,int index,String str,HashMap<Integer,int[]> hash){
        max=Math.max(max,str.length());
        if (index==arrs.length) {
            return;
        }
        for (int i=index;i<arrs.length;i++) {
            if (!isRep(str,hash.get(i))) {
                dfs(arrs,i+1,str+arrs[i],hash);
            }
        }
    }

    public boolean isValid(int[] s1){
        for (int i=0;i<s1.length;i++) {
            if (s1[i]>1) {
                //System.out.println(s1[i]);
                return false;
            }
        }
        return true;
    }

    public boolean isRep(String s1,int[] s2){
        //System.out.println(s1+"d);
        for (int i=0;i<s1.length();i++) {
            if (s2[s1.charAt(i)-'a']!=0) {
                return true;
            }
        }
        return false;
    }
}