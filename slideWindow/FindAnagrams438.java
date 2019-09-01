public class FindAnagrams438{
    public static void main(String[] args) {


    }

    /*
            输入:
                s: "cbaebabacd" p: "abc"
            输出:
                [0, 6]
            解释:
                起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
                起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
    */
    public List<Integer> findAnagrams1(String s, String p) {
        int[] target=new int[256];
        int[] window=new int[256];
        int l=0,r=0;
        int plen=p.length();
        int slen=s.length();
        int count=0,match=0;
        List<Integer> res=new ArraysList<>();
        for (int i=0;i<plen;i++) {
            target[p.charAt(i)]++;
        }
        for (int a:target) {
            if(a!=0){
                count++;
            }
        }

        while(r<slen){
            char right=s.charAt(r);
            if (target[right]!=0) {
                window[right]++;
                if (window[right]==target[right]) {
                    match++;
                }
            }
            r++;   
            while(l<r && count==match){
                char left=s.charAt(l);
                if (r-l==res) {
                    res.add(l);
                }
                l++;
                //不满足了
                if (target[left]!=0) {
                    window[left]--;
                    if (window[left]<target[left]) {
                        match--;
                    }
                }
            }
        }
        return res;
    }

    //wrong
    public List<Integer> findAnagrams2(String s, String p) {
        int[] target=new int[256];
        int[] window=new int[256];
        int l=0,r=0;
        int plen=p.length();
        int slen=s.length();
        int count=0,match=0;
        List<Integer> res=new ArraysList<>();
        for (int i=0;i<plen;i++) {
            target[p.charAt(i)]++;
        }
        for (int a:target) {
            if(a!=0){
                count++;
            }
        }

        while(r<slen){
            char right=s.charAt(r);
            if (target[right]!=0) {
                window[right]++;
                if (window[right]==target[right]) {
                    match++;
                }
                r++;
            }else{
                if (match==count) {
                    res.add(l);
                }
                l=r+1;
                r=l;
                match=0;
            }
        }
        return res;
    }
}
