import java.util.*;
public class IsSubsequence392{
    public static void main(String[] args) {
        IsSubsequence392 is=new IsSubsequence392();
        System.out.println(is.isSubsequence3("acb","ahbgdc"));
    }

    public boolean isSubsequence1(String s, String t) {
        if (s==null || t==null) {
            return false;
        }
        int sindex=0,tindex=0;
        while(sindex<s.length()) {
            while(tindex<t.length() && sindex<s.length()){
                if (s.charAt(sindex)==t.charAt(tindex)) {
                    sindex++;
                }
                tindex++;
            }
            if (tindex==t.length()) {
                break; 
            }
        }
        return sindex==s.length();
    }

    //递归处理
    public boolean isSubsequence2(String s,String t){
        return subsequence(s,t,0,0);
    }

    public boolean subsequence(String s,String t,int sindex,int tindex){
        if (sindex == s.length()) {
            return true;
        }
        //上下if不能交换
        if (tindex == t.length()) {
            return false;
        }
        return s.charAt(sindex)==t.charAt(tindex)?subsequence(s,t,sindex+1,tindex+1):subsequence(s,t,sindex,tindex+1);
    }

    //大量的s字符串 处理
    public boolean isSubsequence3(String s, String t) {
        //预处理
        ArrayList<ArrayList<Integer>> hash=new ArrayList<>();
        for (int i=0;i<26;i++) {
            hash.add(new ArrayList());
        }
        for (int i=0;i<t.length();i++) {
            hash.get(t.charAt(i)-'a').add(i);
        }
        //经过上面的预处理,后面的处理就会很快,不用再遍历t字符串
        int lastIndex=-1;
        for (int i=0;i<s.length();i++) {
            List<Integer> indexList=hash.get(s.charAt(i)-'a');
            int temp=binarySearch(indexList,lastIndex);
            if (temp==indexList.size()) {
                return false;
            }
            lastIndex=indexList.get(temp);
        }
        return true;
    }

    //找到第一个比target大的元素
    public int binarySearch(List<Integer> list,int target){
        int left=0,right=list.size()-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if (list.get(mid)<=target) {
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return left;
    }
}