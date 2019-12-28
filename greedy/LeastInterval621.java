public class LeastInterval621{
    public static void main(String[] args) {
        
    }

    public int leastInterval(char[] tasks, int n) {
        int[] map=new int[26];
        for (int i=0;i<tasks.length;i++) {
            map[tasks[i]-'A']++;
        }
        StringBuilder sb=new StringBuilder();
        int res=0;
        while(true){
            int count=0;
            for (int i=0;i<26;i++) {
                if (map[i]!=0) {
                    map[i]--;
                    count++;
                    sb.append(map[i]);
                    if (count==n) {
                        break;
                    }
                }
                res=n;
            }
        }
    }

    public int leastInterval(char[] tasks, int n) {
        int[] map=new int[26];
        for (int i=0;i<tasks.length;i++) {
            map[tasks[i]-'A']++;
        }
        //找最大值
        int max=-1;
        for (int i=0;i<map.length;i++) {
            max=Math.max(map[i],max);
        }
        int maxCount=0;
        for (int i=0;i<map.length;i++) {
            if (map[i]==max) {
                maxCount++;
            }
        }
        //比如 a b c d e f g
        return Math.max((n+1)*(max-1)+maxCount,tasks.length);
    }
}