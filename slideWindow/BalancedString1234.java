public class BalancedString1234{
    public static void main(String[] args) {

    }

    public int balancedString(String s) {
        if (s==null|| s.length()<=0) {
            return 0;
        }
        int len=s.length();
        int balance=len/4;
        //映射字符
        int[] count=new int[128];
        //统计4个字符串出现的次数
        for (int i=0;i<len;i++) {
            count[s.charAt(i)]++;
        }
        int left=0,right=0,res=len;
        while(right<len){
            count[s.charAt(right)]--;
            while(left<len && count['Q']<=balance && count['W']<=balance && count['E'] <=balance && count['R']<=balance){
                res=Math.min(res, right-left+1);
                count[s.charAt(left)]++;
                left++;
            }
            right++;
        }
        return res;
    }

    //update: 2020.4.15
    public int balancedString(String s) {
        if(s==null || s.length()<=0) return -1;
        int N=s.length();
        //这里用26有的浪费,为了方便写代码,就这样吧
        int[] need=new int[26]; 
        Arrays.fill(need,-N/4);
        int[] cur=new int[26];
        for(int i=0;i<N;i++){
            need[s.charAt(i)-'A']++;
        }
        //有几个字符多出来了
        int needCount=0; 
        for(int i=0;i<need.length;i++){
            if(need[i]>0) needCount++;
        } 
        if(needCount==0) return 0;
        int res=N;
        int left=0,right=0;
        int matchCount=0;
        //无脑套路滑窗
        while(right<s.length()){
            char c=s.charAt(right);
            if(need[c-'A']>0){
                cur[c-'A']++;
                if(cur[c-'A']==need[c-'A']){
                    matchCount++;
                }
            }
            while(left<=right && matchCount==needCount){
                res=Math.min(right-left+1,res);
                char cl=s.charAt(left);
                if(need[cl-'A']>0){
                    cur[cl-'A']--;
                    if(cur[cl-'A']<need[cl-'A']){
                        matchCount--;
                    }
                }
                left++;
            }
            right++;
        }
        return res;
    }

    //update: 2020.4.15 和上面的第一种差不多，自己重写的改了一点
    //update: 2020.5.16 这个解法的返回有问题
    // public int balancedString(String s) {
    //     if(s==null || s.length()<=0) return -1;
    //     int N=s.length();
    //     int res=N,avg=N/4;
    //     int[] freq=new int[26];
    //     for(int i=0;i<s.length();i++){
    //         freq[s.charAt(i)-'A']++;
    //     }
    //     int left=0,right=0;
    //     while(right<s.length()){
    //         //窗口右边界扩张，freq--
    //         freq[s.charAt(right)-'A']--;
    //         while(left<=right && freq['Q'-'A']<=avg && freq['W'-'A']<=avg && freq['E'-'A']<=avg && freq['R'-'A']<=avg){
    //             res=Math.min(res,right-left+1);
    //             //窗口左边界收缩，freq++
    //             freq[s.charAt(left)-'A']++;
    //             left++;
    //         }
    //         right++;
    //     }
    //     return left==right?0:res;
    // }
    
    //正确解法
    public int balancedString(String s) {
        if(s==null || s.length()<=0){
            return 0;
        }
        int N=s.length();
        int left=0;
        int res=N;
        int[] freq=new int[26];
        for(int i=0;i<N;i++) {
            freq[s.charAt(i)-'A']++;
        }
        for(int right=0;right<N;right++){
            freq[s.charAt(right)-'A']--;
            while(left<N && freq['Q'-'A']<=N/4 && freq['W'-'A']<=N/4 && freq['E'-'A']<=N/4 && freq['R'-'A']<=N/4){
                res=Math.min(res,right-left+1);
                freq[s.charAt(left++)-'A']++;
            }
        }
        return res;
    }
}