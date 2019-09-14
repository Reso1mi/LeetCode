import java.util.*;
public class LengthOfLongestSubstring3{

    public static void main(String[] args) {
        String s2="adadasdsadddd";
        String s3="abba";
        String s="tmmzuxt";
        System.out.println("----"+lengthOfLongestSubstring6(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        //边界问题永远不能忽略
        //LinkedList<Integer> list=new LinkedList<>();
        int length=s.length();
        if(length==0) return 0;
        int [] list=new int[length];
        int head=0,tail=0;
        list[tail]=0;
        int max=1;
        for (int i=1;i<length;i++) {
            int index=i-1; //当前元素前一个元素下标
            while(index>=list[head]){
                if(s.charAt(i)!=s.charAt(list[index])){
                    index--;
                }else{
                    //按思路应该是把相等前所有元素移除，但是那样效率好低，所以这里我决定用数组模拟队列
                    head=index+1;
                    list[++tail]=i;
                    break;
                }

                //从尾遍历到头仍然没有相等，可以添加到队列中
                if(index==list[head]-1){
                    list[++tail]=i;
                    break;
                }
            }
            //每次结束循环后 尾index-头index
            max=list[tail]-list[head]+1 > max?list[tail]-list[head]+1:max;
            //System.out.println(max);
        }
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        char [] chars = s.toCharArray();
        if (chars.length == 0) {
            return 0;
        }
        int length = 1;
        String temp=new String();
        for (int i = 0; i <s.length()-1; i++) {
            if(chars[i] != chars[i+1]) {
              temp=s.substring(i, i+2);
          }else continue;

          for (int j = i+2; j < s.length(); j++) {
            if (!temp.contains(chars[j]+"")) {
                temp = s.substring(i, j+1);
            }else break;
        }
            //Break出来后判断是否是最长的k
        length=temp.length()>length?temp.length():length;
    }
    return length;
}

public int lengthOfLongestSubstring3(String s) {
    int n = s.length(), ans = 0;
        //索引为元素值，这里因为元素都是字符转过来就是askll码，所以可以直接这样
    int[] index = new int[128]; 
    for (int j = 0, i = 0; j < n; j++) {
            //如果字符 char 在没有出现过，index[char]为0，出现则index[char]是遍历出现的最后的char的位置
            //i是当前字符上一次出现的位置
        i = Math.max(i,index[s.charAt(j)]);
            //i= index[s.charAt(j)]==0?0:index[s.charAt(j)];
            //j - i + 1 就是舍弃s.charAt(j)重复出现之前字符的长度  如abca,当s.charAt(j) == a时，j - i + 1就是bca的长度
            //如果字符没有重复出现过，则ans等于j+1,出现过则是ans，j-i+1的最大值
        ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;//+1是为了区分第一个字符j = 0,和数组默认值0
        }
        return ans; 
    }

    public static int lengthOfLongestSubstring4(String s) {
        //边界问题永远不能忽略
        //LinkedList<Integer> list=new LinkedList<>();
        int length=s.length();
        if(length==0) return 0;
        int head=0,tail=0;
        int max=1;
        for (int i=1;i<length;i++) {
            int index=i-1; //当前元素前一个元素下标
            while(index>=head){
                if(s.charAt(i)!=s.charAt(index)){
                    index--;
                }else{
                    //按思路应该是把相等前所有元素移除，但是那样效率好低，所以这里我决定用数组模拟队列
                    head=index+1;
                    tail++;
                    break;
                }
                //从尾遍历到头仍然没有相等，可以添加到队列中
                if(index==head-1){
                    tail++;
                    break;
                }
            }
            //每次结束循环后 尾index-头index
            max=tail-head+1 > max?tail-head+1:max;
            //System.out.println(max);
        }
        return max;
    }

    public static int lengthOfLongestSubstring5(String s) {
        int length=s.length();
        if(length==0) return 0;
        //ASCII码表
        int[] freq=new int[256]; 
        freq[s.charAt(0)]=1;
        int head=0,tail=0;
        int max=1;
        while(head<length){
            if(tail+1<length&&freq[s.charAt(tail+1)]==0){
                tail++;
                freq[s.charAt(tail)]++;
            }else{
                freq[s.charAt(head)]--;
                head++;
            }
            max=max<tail-head+1?tail-head+1:max;
        }
        return max;
    }
    
    public static int lengthOfLongestSubstring6(String s) {
        if(s==null||s.length()<1) return 0;
        if(s.length()==1) return 1;
        int[] freq=new int[256];
        int left=0,right=0,res=0;
        Arrays.fill(freq,-1);
        while(right<s.length()){
            char sr=s.charAt(right);
            //已经存在,并且在窗口内
            if(freq[sr]!=-1 && freq[sr]>=left){
                //System.out.println(left+","+right+","+freq[sr]);
                res=Math.max(res,right-left);
                left=freq[sr]+1;
                freq[sr]=right;
            }else{
                res=Math.max(res,right-left+1);
                freq[sr]=right;
            }
            
            right++;
        }
        return res;
    }
}
