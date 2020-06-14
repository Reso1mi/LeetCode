public class ReplaceSpaceJZ_05{
    public static void main(String[] args) {

    }

    public String replaceSpace(String s) {
        char[] res=new char[s.length()*3];
        int idx=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                res[idx++]='%';
                res[idx++]='2';
                res[idx++]='0';
            }else{
                res[idx++]=s.charAt(i);
            }
        }
        return new String(res,0,idx);
    }

    //原题目的要求应该是在O(1)空间下,但是Java的String是不可变的
    //所以不可能O(1),我们需要改一下函数签名
    public String replaceSpace(/*StringBuilder*/ String ss) {
        StringBuilder s=new StringBuilder(ss); //这里是为了验证
        int oldLen=s.length();
        for (int i=0;i<oldLen;i++) {
            if(s.charAt(i)==' ') s.append("xx"); //扩充字符长度
        }
        int newLen=s.length();
        //逆序,避免覆盖
        int i=oldLen-1,j=newLen-1;
        while(i>=0){
            char c=s.charAt(i--);
            if(c==' '){
                s.setCharAt(j--,'0');
                s.setCharAt(j--,'2');
                s.setCharAt(j--,'%');
            }else{
                s.setCharAt(j--,c);
            }
        }
        return s.toString();
    }
}