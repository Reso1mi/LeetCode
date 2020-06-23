public class MaxVowels1456{
    public int maxVowels(String s, int k) {
        int left=0;
        int res=0;
        int count=0;
        for(int right=0;right<s.length();right++){
            if(vowel(s.charAt(right))){
                count++;
            }
            while(right-left >= k){
               if(vowel(s.charAt(left))){
                   count--;
               }
               left++;
            }
            res=Math.max(res,count);
        }
        return res;
    }

    public boolean vowel(char ch){
        return ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u';
    }
}