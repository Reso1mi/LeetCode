public class LetterCombinations17{
    public static void main(String[] args) {

    }


    String[] letter={" ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    private List<String> res=new LinkedList<>();

    public List<String> letterCombinations(String digits) {
        //空字符串要注意
        if ("".equals(digits)) return res;
        letterCombinations(digits,0,"");
        return res;
    }

    public void letterCombinations(String digits,int index,String str) {
        //递归出口,当index==digits的长度的时候就说明走到尽头了
        //需要回头尝试其他的情况
        if (index==digits.length()) {
            res.add(str);
            return;
        }
        //当前字符对应的字母组合
        char[] ls=letter[digits.charAt(index)-48].toCharArray();
        //遍历每种可能,其实就是DFS
        for (int i=0;i<ls.length;i++) {
            letterCombinations(digits,index+1,str+ls[i]);
        }
        return;
    }
}