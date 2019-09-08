import java.util.*;
public class IsAnagram242{
    public static void main(String[] args) {

    }


    /*
    给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

    示例 1:

    输入: s = "anagram", t = "nagaram"
    输出: true
    示例 2:

    输入: s = "rat", t = "car"
    输出: false
    说明:
    你可以假设字符串只包含小写字母。

    进阶:
    如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
     */
    
    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length())return false;
        int[] freq=new int[256];
        for (int i=0;i<s.length();i++) {
            freq[s.charAt(i)]++;
        }
        int count=0,match=0;
        for (int a:freq) {
            if(a!=0){
                count++;
            }
        }
        for (int i=0;i<t.length();i++) {
            if(freq[t.charAt(i)]>0){
                freq[t.charAt(i)]--;
                if(freq[t.charAt(i)]==0){
                    match++;
                }
            }
        }
        return match==count;
    }

    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length())return false;
        int[] freq=new int[256];
        for (int i=0;i<s.length();i++) {
            freq[s.charAt(i)]++;
        }
        for (int i=0;i<t.length();i++) {
            freq[t.charAt(i)]--;
        }
        for (int i:freq) {
            if(i!=0){
                return false
            }
        }
        return true;
    }
}