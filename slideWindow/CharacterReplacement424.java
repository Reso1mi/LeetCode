public class CharacterReplacement424{
    public static void main(String[] args) {
        
    }

/*    public int characterReplacement(String s, int k) {
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
        return res;
    }*/

    public int characterReplacement(String s, int k) {
        int max = 0, left = 0, right = 0, cur = -1;
        int[] count = new int[256];
        while (right < s.length()) {
            //当前窗口出现最多的字符出现次数
            cur = Math.max(cur, ++count[s.charAt(right)]);
            //不能替换了,不同字符太多了
            while (right - left + 1 - cur > k){
                //缩减左边界
                count[s.charAt(left)]--;
                left++;//不能替换了，left++
            }
            //统计最大值
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}