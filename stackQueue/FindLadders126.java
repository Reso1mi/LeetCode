public class FindLadders126{
    
    // 标记数组
    // 默认都是0
    //private static int[] mark;
    
    private static int[] markDfs;
    
    int min = Integer.MAX_VALUE;
    
    //返回值
    //private  List<List<String>> res=new ArrayList<>();
    
    // 写一个函数判段没吃是否只变化了一个字母
    private boolean cmp(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        //返回值
        List<List<String>> res=new ArrayList<>();

        boolean[] visit=new boolean[wordList.size()+1];
        
        // 不存在
        if (!wordList.contains(endWord)) {
            return res;
        }
        // BFS
/*        int head = 0, tail = 0;
        // 初始化队列
        Que[] que = new Que[wordList.size() + 1];
        // 循环促使话述祖
        for (int i = 0; i < que.length; i++) {
            que[i] = new Que();
        }*/
        Queue<Pair> queue=new LinkedList<>();
        //先把第一个单词放进去
        queue.add(new Pair(beginWord,1));

        List<Que> list=new LinkedList<>();
        
        while (!queue.isEmpty()) {
            Pair pair=queue.poll();
            for (int i = 0; i < wordList.size(); i++) {
                if (!visit[i] && cmp(wordList.get(i), que[head].word)) {
                    visit[i] = true;
                    if (wordList.get(i).equals(endWord)) {    
                        //记录最小值
                        min=pair.step+1;
                        //将队列变成list
                        for(int j=0;j<=tail;j++){
                            list.add(que[j]);
                        }
                        markDfs= new int[wordList.size() + 1]; 
                        // 1. 用DFS试一下
                        dfsBfs(que[0],endWord,quelist);
                    }
                    tail++;
                }
            }
            // 每次检查完一个单词就将其出队列
            head++;
        }
        return res;
    }

    private void dfsBfs(Que beginWord,String endWord,List<Que> ques){
        int step = 0;
        for (int i = 0; i < markDfs.length; i++) {
            if (markDfs[i] == 1) {
                step++;
            }
        }
        if(step>=min) return;
        if(step+1==min&&endWord.equals(beginWord.word)){
            List<String> list=new ArrayList<>();
            Stack<String> stack=new Stack<>();
            System.out.println(beginWord.word+":"+step);
            Que temp=beginWord;
                //找到一条
            for(int i=0;i<min;i++){
                stack.push(temp.word);
                    //System.out.print(temp.word+"<--");
                temp=temp.prev;
            }
            System.out.println();
            for(int i=0;i<min;i++){
                list.add(stack.pop());
            }
            res.add(list);
            //System.out.println(res);
            return;
        }

        for (int i = 0; i < ques.size(); i++) {
            if (markDfs[i] == 0 && cmp(beginWord.word,ques.get(i).word)){
                markDfs[i] = 1;
                //连接两个节点
                //beginWord.next=ques.get(i);
                ques.get(i).prev=beginWord;
                dfsBfs(ques.get(i), endWord, ques);
                markDfs[i] = 0;
            }
        }
        return;
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
}