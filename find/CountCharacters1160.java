public class CountCharacters1160{
    public static void main(String[] args) {

    }

    public int countCharacters(String[] words, String chars) {
        int[] map=new int[26];
        for (int i=0;i<chars.length();i++) {
            map[chars.charAt(i)-'a']++;
        }
        int res=0;
        for (int i=0;i<words.length;i++) {
            String word=words[i];
            int[] temp=new int[26];
            boolean flag=true;
            System.arraycopy(map,0,temp,0,26);
            for (int j=0;j<word.length();j++) {
                if(temp[word.charAt(j)-'a']==0){
                    flag=false;
                    break;
                }
                temp[word.charAt(j)-'a']--;
            }
            if(flag){
                res+=word.length();
            }
        }
        return res;
    }

    public int countCharacters(String[] words, String chars) {
        int[] hash=new int[26];
        for (int i=0;i<chars.length();i++) {
            hash[chars.charAt(i)-'a']++;
        }
        int res=0;
        int[] temp=new int[26];
        for (int i=0;i<words.length;i++) {
            String word=words[i];
            Arrays.fill(temp,0);
            boolean flag=true;
            for (int j=0;j<word.length();j++) {
                temp[word.charAt(j)-'a']++;
                if(temp[word.charAt(j)-'a']>hash[word.charAt(j)-'a']){
                    flag=false;
                    break;
                }
            }
            res+=flag?word.length():0;
        }
        return res;
    }
}