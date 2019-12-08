import java.util.*;
public class Main10_13{
    public static void main(String[] args) {
        System.out.println(balancedStringSplit("LLLLRRRR"));
    }

    public static int balancedStringSplit(String s) {
        if (s.length()%2==1) {
            return 0;
        }
        Stack<Character> stack=new Stack<>();
        int count=0;
        for(int i=0;i<s.length();i++){
            if (!stack.isEmpty() ){
                if(s.charAt(i)==stack.peek()) {
                    stack.push(s.charAt(i));    
                }else{
                    stack.pop();
                    if (stack.isEmpty()) {
                        count++;
                    }
                }
            }else{
                stack.push(s.charAt(i));
            }
        }
        return count;
    }


    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int x=king[0];
        int y=king[1];
        int a=-1,b=-1,c=0,d=0,e=0,f=0,g=0,h=0;
        for (int i=0;i<queens.length;i++) {
            //右
            if (queens[i][0] == x && queens[i][1] >y) {
                if (a==-1) {
                    a=i;
                }else{
                    a=queens[i][1]-y>queens[a][1]-y?a:i;
                }
            }

            //左
            if (queens[i][0] == x && queens[i][1] <y) {
                if (b==-1) {
                    b=i;
                }else{
                    b=y-queens[i][1]>y-queens[b][1]?b:i;
                }
            }

            //上
            if (queens[i][1] == y && queens[i][0]<x) {
                if (c==-1) {
                    c=i;
                }else{
                    c=x-queens[i][0]>x-queens[c][0]?c:i;
                }
            }

            //下
            if (queens[i][1] == y && queens[i][0]>x) {
                if (d==-1) {
                    d=i;
                }else{
                    d=x-queens[i][0]>x-queens[d][0]?d:i;
                }
            }

            //左上
            if (queens[i][0]-queens[i][1] == x-y && queens[i][0]<x && queens[i][1]<y) {
                if (e==-1) {
                    e=i;
                }else{
                    e=dis(queens[i][0],queens[i][1],x,y)>dis(queens[e][0],queens[e][1],x,y)?e:i;
                }
            }

            //左下
            if (queens[i][0]-queens[i][1] == x-y && queens[i][0]>x && queens[i][1]<y) {
                if (f==-1) {
                    f=i;
                }else{
                    f=dis(queens[i][0],queens[i][1],x,y)>dis(queens[f][0],queens[f][1],x,y)?f:i;
                }
            }

            //右上
            if (queens[i][0]+queens[i][1] == x+y && queens[i][0]<x && queens[i][1]>y) {
                if (g==-1) {
                    g=i;
                }else{
                    g=dis(queens[i][0],queens[i][1],x,y)>dis(queens[g][0],queens[g][1],x,y)?g:i;
                }
            }

            if (queens[i][0]+queens[i][1] == x+y && queens[i][0]>x && queens[i][1]>y) {
                if (h==-1) {
                    h=i;
                }else{
                    h=dis(queens[i][0],queens[i][1],x,y)>dis(queens[h][0],queens[h][1],x,y)?h:i;
                }
            }
        }
        List<List<Integer>> res=new ArrayList<>();
        
        return res;
    }

    public int dis(int x,int y,int kx,int ky){
        return (y-ky)*(y-ky)+(x-kx)*(x-kx);
    }
}