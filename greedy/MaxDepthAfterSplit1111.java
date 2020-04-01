public class MaxDepthAfterSplit1111{
    public static void main(String[] args) {

    }

    public int[] maxDepthAfterSplit(String seq) {
        //Deque<Character> stack=new ArrayDeque<>();
        int depth=0;
        int[] res=new int[seq.length()];
        for (int i=0;i<seq.length();i++) {
            if(seq.charAt(i)=='('){
                res[i]=depth++%2;
            }else{
                //根据左括号奇偶判断
                res[i]=--depth%2;
            }
        }
        return res;
    }
}