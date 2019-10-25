public class FindContentChildren455{
    public static void main(String[] args) {

    }

    public int findContentChildren(int[] g, int[] s) {
        if (g==null || s==null) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int res=0,index=0;
        for (int i=0;i<g.length;i++) {
            while(index<s.length){
                if (g[i]<=s[index]) {
                    res++;
                    index++;
                    break;
                }
                index++;
            }
        }
        return res;
    }
}