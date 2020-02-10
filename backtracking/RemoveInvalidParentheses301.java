import java.util.*;
public class RemoveInvalidParentheses301{
    public static void main(String[] args) {

    }

    //)(()))
    private HashSet<String> res=new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        int left=0,right=0;
        //()))()
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i)=='(') {
                left++;
            }else if (s.charAt(i)==')') {
                if (left>0) {
                    left--;
                }else{
                    right++;
                }
            }
        }
        //dfs(s,0,left,right,"");
        dfs(new StringBuilder(s),left,right);
        if (res.isEmpty()) {
            res.add(""); //空值处理
        }
        return new LinkedList<>(res);
    }

    //TLE,这个解法有点问题
    public void dfs(StringBuilder s,int left,int right){
        if (left==0 && right==0) {
            if (isValid(s.toString())) {
                res.add(s.toString());
            }
            return;
        }
        for (int i=0;i<s.length();i++) {
            if (i-1>=0 && s.charAt(i)==s.charAt(i-1)) {
                continue;
            }
            char c=s.charAt(i);
            if (c=='(' && left>0) {
                s.deleteCharAt(i);
                dfs(s,left-1,right);
                s.insert(i,c);
            }else if (c==')' && right>0) {
                s.deleteCharAt(i);
                dfs(s,left,right-1);
                s.insert(i,c);
            }
        }
    }

    public void dfs(String s,int index,int left,int right,String cur){
        if (index==s.length()) {
            if (left==0 && right==0 && isValid(cur)) {
                res.add(cur);
            }
            return;
        }
        char c=s.charAt(index);
        if (c=='(' && left>0) {
            dfs(s,index+1,left-1,right,cur); //删除左括号
            dfs(s,index+1,left,right,cur+c); //保留左括号
        }else if (c==')' && right>0) {
            dfs(s,index+1,left,right-1,cur);
            dfs(s,index+1,left,right,cur+c);
        }else{
            dfs(s,index+1,left,right,cur+c);
        }
    }

    //BFS的解法
    public List<String> removeInvalidParentheses(String s) {
        List<String> res=new ArrayList<>();
        Queue<String> queue=new LinkedList<>();
        HashSet<String> visit=new HashSet<>();
        visit.add(s);
        queue.add(s);
        boolean flag=false;
        while(!queue.isEmpty()){
            String cur=queue.poll();
            if (isValid(cur)) {
                res.add(cur);
                flag=true;
            }
            if (flag) {
                continue;
            }
            for (int i=0;i<cur.length();i++) {
                if (cur.charAt(i)=='(' || cur.charAt(i)==')') {
                    String temp=cur.substring(0,i)+cur.substring(i+1,cur.length());
                    if (!visit.contains(temp)) {
                        queue.add(temp);
                        visit.add(temp);
                    }
                }
            }
        }
        if(res.isEmpty()) res.add("");
        return res;
    }

    public boolean isValid(String s){
        int left=0,right=0;
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i)=='(') {
                left++;
            }else if (s.charAt(i)==')') {
                if (left>0) {
                    left--;
                }else{
                    return false;
                }
            }
        }
        return left==0;
    }
}