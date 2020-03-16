public class CompressString_01_06{

    /*
    输入："aabcccccaaa"
    输出："a2b1c5a3"
    */
    public String compressString(String S) {
        StringBuilder sb=new StringBuilder();
        int index=0;
        while(index<S.length()){
            sb.append(S.charAt(index));
            int r=1;
            while(index<S.length()-1&&S.charAt(index)==S.charAt(index+1)){
                ++index;
                r++;
            }
            sb.append(r);
            index++;
        }
        return sb.length()<S.length()?sb.toString():S;
    }
}