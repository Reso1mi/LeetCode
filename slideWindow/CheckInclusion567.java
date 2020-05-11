public class CheckInclusion567{
    public static void main(String[] args) {

    }

    public boolean checkInclusion(String s1, String s2) {
        if(s1==null || s2==null || s1.length()>s2.length()){
            return false;
        }
        int n1=s1.length();
        int n2=s2.length();
        int[] freq=new int[26];
        int count=0;
        for(int i=0;i<n1;i++){
            int c=s1.charAt(i)-'a';
            if(freq[c]==0){
                count++;
            }
            freq[c]++;
        }
        int[] window=new int[26];
        int match=0;
        int left=0;
        for(int right=0;right<n2;right++){
            int cr=s2.charAt(right)-'a';
            if(freq[cr]>0){
                window[cr]++;
                if(window[cr]==freq[cr]){
                    match++;
                }
            }
            while(right-left+1>n1){
                int cl=s2.charAt(left)-'a';
                if(freq[cl]>0){
                    //WA点，开始写错了
                    //window[cl]--;
                    if(window[cl]==freq[cl]){
                        match--; //match--的前提是原本是匹配的
                    }
                    window[cl]--;
                }
                left++;
            } 
            if(match==count){
                return true;
            }
        }
        return false;
    }

    //写法2
    public boolean checkInclusion(String s1, String s2) {
        if(s1==null || s2==null || s1.length()>s2.length()){
            return false;
        }
        int n1=s1.length();
        int n2=s2.length();
        int[] freq=new int[26];
        int count=0;
        for(int i=0;i<n1;i++){
            int c=s1.charAt(i)-'a';
            if(freq[c]==0){
                count++;
            }
            freq[c]++;
        }
        int[] window=new int[26];
        int match=0;
        int left=0;
        for(int right=0;right<n2;right++){
            int cr=s2.charAt(right)-'a';
            if(freq[cr]>0){
                window[cr]++;
                if(window[cr]==freq[cr]){
                    match++;
                }
            }
            //主要就是这里不一样
            while(match==count){
                if(right-left+1==n1) return true;
                int cl=s2.charAt(left)-'a';
                if(freq[cl]>0){
                    window[cl]--;
                    if(window[cl]<freq[cl]){
                        match--;
                    }
                }
                left++;
            } 
        }
        return false;
    }
}