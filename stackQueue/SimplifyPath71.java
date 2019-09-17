public class SimplifyPath71{
    public static void main(String[] args) {
        String s="/home//foo/";
        String s2="/a/../../b/../c//.//";
        String s3="/..";
        System.out.println(simplifyPath(s3));
    }


    public static String simplifyPath(String path) {
        MyStack<String> stack=new MyStack<>(path.length());
        StringBuilder str=new StringBuilder(path);
        //这里划分出来部分是空的 ""
        String[] s=path.split("/");
        for (int i=0;i<s.length;i++) {
            if (!stack.isEmpty() && s[i].equals("..")) {
                stack.pop();
            }else if (!".".equals(s[i]) && !"".equals(s[i]) && !s[i].equals("..") ) {
                stack.push(s[i]);
            }
        }
        if (stack.isEmpty) {
            return "/";
        }
        StringBuilder res=new StringBuilder();
        for (int i=0;i<stack.size(); i++) {
            res.append("/"+stack.get(i));   
        }
        return res.toString();
    }

    public static String simplifyPath2(String path) {
        MyStack<String> stack=new MyStack<>(path.length());
        StringBuilder str=new StringBuilder(path);
        int left=1,right=1;
        for(int j=1,i=1;i<str.length();i++) {
            if(str.charAt(i)=='/'){
                j=i;
                continue;
            }
            
            stack.push(str.substring(j,i));

            if(!stack.isEmpty() && i+1<str.length() && str.charAt(i)=='.' && str.charAt(i+1)=='.'){
                stack.pop();
                break;
            }
            
        }

        StringBuilder res=new StringBuilder();
        for (int i=0;i<stack.size(); i++) {
            res.append("/"+stack.get(i));   
        }
        return res.toString();
    }
}