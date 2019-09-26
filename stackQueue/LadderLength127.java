import java.util.*;
public class LadderLength127{
    public static void main(String[] args) {

    }
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList){
        //visit数组
        boolean[] visit=new boolean[wordList.size()];
        if (!wordList.contains(endWord)) {
            return 0;
        }

        Queue<Pair> queue=new LinkedList<>();
        queue.add(new Pair(beginWord,1));
        //int flag=0;
        while (!queue.isEmpty()) {
            Pair pair=queue.poll();
            // 统计最小步数
            /*if (pair.word.equals(endWord)) {
                return pair.step;
            }*/
            // 遍历字典
            for (int i = 0; i < wordList.size(); i++) {
                if (!visit[i] && cmp(wordList.get(i),pair.word)) {
                    if (wordList.get(i).equals(endWord)) {
                        //这里加1 是因为取的是pair的step
                        //到当前这个单词还要多走一步
                        return pair.step+1;
                    }
                    queue.add(new Pair(wordList.get(i),pair.step+1));
                    //标记为已经走过
                    visit[i] = true;
                }
            }
        }
        return 0;
    }
    
    //是否只变化了一个字符
    private boolean cmp(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
                if (count>1) {
                    return false;
                }
            }
        }
        return count == 1;
    }
    
    //Pair
    class Pair {
        String word;
        int step;
        public Pair(String word,int step){
            this.word=word;
            this.step=step;
        }
    }


    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0) return 0;
        HashSet<String> start = new HashSet<>();
        HashSet<String> end = new HashSet<>();
        HashSet<String> dic = new HashSet<>(wordList);
        start.add(beginWord);
        end.add(endWord);
        int step=1;
        if (!dic.contains(endWord)) return 0;
        while(!start.isEmpty()){
            step++;
            HashSet<String> tmpSet=new HashSet<>();
            dic.removeAll(start);
            for(String s:start){
                char[] arr=s.toCharArray();
                for(int i=0;i<arr.length;i++){
                    char tmp=arr[i];
                    for(char c='a';c<='z';c++){
                        if(tmp==c) continue;
                        arr[i]=c;
                        String strTmp=new String(arr);
                        if(dic.contains(strTmp)){
                            if(end.contains(strTmp)){
                                return step;
                            }else{
                                tmpSet.add(strTmp);
                            }
                        }
                    }
                    arr[i]=tmp;
                }
            }
            if(tmpSet.size()<end.size()){
                start=tmpSet;
            }else{
                start=end;
                end=tmpSet;
            }
        }
        return 0;
    }
}