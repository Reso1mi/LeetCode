import java.util.*;
public class LetterCasePermutation784{
    public static void main(String[] args) {

    }

    private List<String> res=new ArrayList<>();

    public List<String> letterCasePermutation(String S) {
        letterCasePermutation(S,0,new StringBuilder(S));
        return res;
    }

    public void letterCasePermutation(String S,int index,StringBuilder cur) {
        res.add(cur.toString()); //变化一次就添加一次
        for (int i=index;i<S.length();i++) {
            char c=S.charAt(i);
            if (c>='0' && c<='9') {
                continue;
            }
            cur.replace(i,i+1,letterCase(c));
            letterCasePermutation(S,i+1,cur);
            cur.replace(i,i+1,letterCase(cur.charAt(i))); //状态重置
        }
    }

    //这里其实有一个小技巧：c^(1<<5)就可以使大写变小写,小写变大写
    public String letterCase(char c){
        if (c>='a' && c<='z') { //65:A 97:a
            c-=32;
        }else if (c>='A' && c<='Z') {
            c+=32;
        }
        return c+"";
    }

    //虽然看起来简洁点,但是感觉还是循环好理解一点啊
    public void letterCasePermutation(String S,int index,StringBuilder cur){
        if (index==S.length()) {
            res.add(cur.toString());
            return;
        }
        char c=S.charAt(index);
        if (c>='0' && c<='9') {
            letterCasePermutation(S,index+1,cur);   
        }else{
            cur.replace(index,index+1,letterCase(c));
            letterCasePermutation(S,index+1,cur);
            cur.replace(index,index+1,letterCase(cur.charAt(index)));
            letterCasePermutation(S,index+1,cur);
        }
    }
}