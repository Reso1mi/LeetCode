public class MinWindow76{
    public static void main(String[] args) {
        String s="bbaa";
        String p="aba";

        System.out.println(minWindow(s,p));
    }

    public static String minWindow(String s, String t) {
        int slen=s.length();
        int tlen=t.length();
        int l=0,r=0; //初始都为0
        int[] target=new int[256]; //A:1 B:1 C:1
        int[] window=new int[256];
        int count=0;
        for (int i=0;i<tlen;i++) {
            target[t.charAt(i)]++;
        }
        for (int a:target) {
            if (a!=0) {
                count++;
            }
        }
        int match=0;
        int[] res=new int[]{0,Integer.MAX_VALUE};
        while(r<slen){
            char c=s.charAt(r); //c=a
            if(target[c]!=0){ //在目标子串中存在
                window[c]++; //window对应的char++
                if(window[c]==target[c]){
                    match++;
                }
            }
            r++;
            while(l<r&&count==match) { //满足子串
                char d=s.charAt(l);
                if (r-l<res[1]-res[0]) { //统计最小值
                    res[0]=l;
                    res[1]=r;
                }
                l++;
                if (target[d]!=0) {
                    window[d]--;
                    if (window[d]<target[d]) {
                        match--;
                    }
                }
            }
        }
        return res[1]==Integer.MAX_VALUE?"":s.substring(res[0],res[1]);
    }

    //update: 2020.4.15
    public String minWindow(String s, String t) {
        if(s==null || t==null) return "";
        int[] needMap=new int[128]; //需要的字符map
        int[] curMap=new int[128];  //已经匹配的字符map
        int needCount=0; //需要匹配的字符个数
        for(int i=0;i<t.length();i++){
            if(needMap[t.charAt(i)]==0){
                needCount++;
            }
            needMap[t.charAt(i)]++;
        }
        int matchCount=0; //已经匹配的个数
        int left=0,right=0;
        int minLeft=0,maxRight=Integer.MAX_VALUE;
        while(left<=right && right<s.length()){
            char c=s.charAt(right);
            if(needMap[c]!=0){
                curMap[c]++;
                if(curMap[c]==needMap[c]){
                    matchCount++;
                }
            }
            while(left<=right && right<s.length() && matchCount==needCount){
                if(right-left<maxRight-minLeft){
                    maxRight=right;
                    minLeft=left;
                }
                char cl=s.charAt(left);
                if(curMap[cl]!=0){
                    curMap[cl]--;
                    //这里注意，WA点
                    if(curMap[cl]<needMap[cl]){
                        matchCount--;
                    }
                }
                left++;
            }
            right++;
        }
        return Integer.MAX_VALUE==maxRight?"":s.substring(minLeft,maxRight+1);
    }
}