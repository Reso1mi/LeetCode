import java.util.*;
public class DecodeString394{
    public static void main(String[] args) {

    }

    /*
    s = "3[a]2[bc]", 返回 "aaabcbc".
    s = "3[a2[c]]", 返回 "accaccacc".
    s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
     */
    //留下来好好反思下为什么这样写是错的！！！！！
    public String decodeStringWrong(String s) {
        StringBuilder sb=new StringBuilder(s);
        Stack<Integer>  stack=new Stack<>();
        for (int i=0;i<sb.length();i++) {
            if (sb.charAt(i)=='[') {
                stack.push(i);
            }else if(sb.charAt(i)==']'){
                int left=stack.pop();
                String temp=sb.substring(left+1,i);
                int repeat=sb.charAt(left-1)-'0';
                sb.delete(left-1,Math.min(i+1,sb.length()));
                for (int j=0;j<repeat;j++) {
                    sb.insert(left-1,temp);
                }
            }
        }
        return sb.toString();
    }

    public String decodeString(String s) {
        if (s==null || s.length()<=0) {
            return "";
        }
        //转换为StringBuilder比较好处理,且效率较高
        StringBuilder sb=new StringBuilder(s);
        Stack<Integer>  stack=new Stack<>();
        int i=0;//遍历索引
        while(i<sb.length()) {
            if (sb.charAt(i)=='[') {
                stack.push(i);
            }else if(sb.charAt(i)==']'){
                int left=stack.pop();//对应左括号索引
                String temp=sb.substring(left+1,i);//相邻括号中的字符
                int preInt=left;
                //'['前的数字,一开始以为只是个位数,还是挺麻烦的
                while(preInt-1>=0 && sb.charAt(preInt-1)>='0' && sb.charAt(preInt-1) <='9'){
                    preInt--;
                }
                //repeat次数
                int repeat=Integer.valueOf(sb.substring(preInt,left));
                //删除 k[encoded_string] 
                sb.delete(preInt,Math.min(i+1,sb.length()));
                for (int j=0;j<repeat;j++) {
                    //从k位置重新插入字符
                    sb.insert(preInt,temp);
                }
                //重新定位索引到尾部
                i=preInt+(repeat*temp.length())-1;
            }
            i++;
        }
        return sb.toString();
    }

    public String decodeString(String s) {
        if (s==null || s.length()<=0) {
            return "";
        }
        return dfs(s,0).toString();
    }

    //明天再改
    public String dfs(String s,int index){
        String sb="";
        while(index<s.length()){
            if (s.charAt(index)==']') {
                return sb;
            }else if(s.charAt(index)>='0' && s.charAt(index)<='9'){
                int temp=index;
                while(index<s.length() && s.charAt(index)!='['){
                    index++;
                }
                int repeat=Integer.valueOf(s.substring(temp,index));
                index++;
                String rs=dfs(s,index); //跳过'['
                for (int i=0;i<repeat;i++) {
                    sb+=rs;
                }
            }else{
                sb+=s.charAt(index++);
            }
        }
        return sb;
    }
}