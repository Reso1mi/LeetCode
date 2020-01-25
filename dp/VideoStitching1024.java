public class VideoStitching1024{
    public static void main(String[] args) {
        
    }

    public int videoStitching(int[][] clips, int T) {
        Arrays.sort(clips,(a,b)->a[0]-b[0]);
        int i=0,res=0,last=0;
        while(i<clips.length) {
            int temp=last;
            while(i<clips.length&&clips[i][0]<=temp) {
                last=Math.max(last,clips[i][1]);
                i++;
            }
            if (last==temp) { //没有找到能覆盖的
                return -1;
            }
            res++;
            if (last>=T) {
                return res;
            }
        }
        return -1;
    }
}