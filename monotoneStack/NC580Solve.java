public class NC580Solve{
    public static void main(String[] args) {

    }

    //5 4 3 4 1
    //一开始被例子给误导了，搞了一手单调递增栈....
    public long solve (int n, int[] a) {
        Deque<Integer> stack = new ArrayDeque<>();
        long res = 0l;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && a[stack.peek()] <= a[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                res += stack.peek()+1;
            }
            stack.push(i);
        }
        return res;
    }
}