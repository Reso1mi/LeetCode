public class NumberOfSubstrings5323{
    public static void main(String[] args) {

    }

    public int numberOfSubstrings(String s) {
        int[] freq=new int[3];
        int left=0,right=0,slen=s.length();
        int res=0;
        while(left<right || right==0){
            while(right<slen && !valid(freq)){
                freq[s.charAt(right++)-'a']++;
            }
            res+=valid(freq)?(slen-right+1):0;
            freq[s.charAt(left)-'a']--;
            left++;
        }
        return res;
    }

    //模板化
    public int numberOfSubstrings(String s) {
        int[] freq=new int[3];
        int left=0,right=-1,slen=s.length();
        int res=0;
        //abc
        while(left<slen-2){
            while(right+1<slen && !valid(freq)){
                freq[s.charAt(++right)-'a']++;
            }
            res+=valid(freq)?(slen-right):0;
            freq[s.charAt(left)-'a']--;
            left++;
        }
        return res;
    }

    public boolean valid(int[] freq){
        return freq[0]!=0 && freq[1]!=0 && freq[2]!=0;
    }
}