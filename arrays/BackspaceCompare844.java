public class BackspaceCompare844 {
    public static void main(String[] args) {

    }

    public boolean backspaceCompare(String S, String T) {
        int i = S.length()-1;
        int j = T.length()-1;
        while (i >= 0 || j >= 0) {
            i = back(S, i);
            j = back(T, j);
            //都匹配完了
            if (i < 0 && j < 0) {
                return true;
            }
            //只有一个匹配完了，两个对位字符不匹配
            if (i < 0 || j < 0 || S.charAt(i) != T.charAt(j)) {
                return false;
            }
            i--; j--;
        }
        //都匹配完了
        return i < 0 && j < 0;
    }
    
    public int back(String s, int i) {
        if (i < 0 || s.charAt(i) != '#') {
            return i;
        }
        int cnt = 0;
        while (i >= 0) {
            if (s.charAt(i) == '#') {
                cnt++;
            } else {
                if (cnt==0) break;
                cnt--;
            }
            i--;
        }
        return i;
    }
}