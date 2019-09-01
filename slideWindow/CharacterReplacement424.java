public class CharacterReplacement424{
    public static void main(String[] args) {
        
    }

    public int characterReplacement(String s, int k) {
        int[] freq=new int[256];
        int l=0,r=0;
        int replace=0;
        int res=0;
        while(l<s.length()){
            char c=s.charAt(r);
            if(freq[c]!=0){
                replace++;
            }
            r++;
            while(replace>=k){
                if (replace==k) {
                    res=r-l;
                }
            }
        }
    }

    public int characterReplacement(String s, int k) {
        int max = 0, start = 0, end = 0, cur = -1;
        int[] count = new int[256];
        while (end < s.length()) {
            //当前窗口出现最多的字符
            cur = Math.max(cur, ++count[s.charAt(end)]);
            //不能替换了,不同字符太多了
            while (end - start + 1 - cur > k){
                //缩减左边界
                count[s.charAt(start)]--;
                start++;//不能替换了，start++
            }
            //统计最大值
            max = Math.max(max, end - start + 1);
            end++;
        }
        return max;
    }
}