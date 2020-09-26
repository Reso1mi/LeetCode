import java.io.*;// petr的输入模板
import java.util.*; 
import java.math.*; // 不是大数题可以不要这个

//笔试专用
public class KeDa {

    public static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        //write your code
        InputReader in = new InputReader(System.in);
        //InputReader in = new InputReader(new FileInputStream("./input.txt"));
        while(!in.EOF()) {
            int str = in.next();
            StringBuilder sb = new StringBuilder(str);
            int idx = 0;
            while (idx < str.length() && str.charAt(idx) == '_') {
                idx++;
            }
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '_') {
                    sb.append(str);
                }
            }
            out.println(sb.toString());
        }
        //别忘了flush
        out.flush();
        out.close();
    }


        //快排 (不具有稳定性或者难以实现)
    private static void QuickSort(int []nums,int l,int r){
        if(l>=r){
            return;
        }
        //随机一个数和r交换 ---随机快排
        swap(nums, l + (int) (Math.random() * (r - l + 1)), r);     
        /*int []index=partition2(nums,l,r);
        QuickSort(nums,l,index[0]-1);
        QuickSort(nums,index[1]+1,r);*/

        int base=partition1(nums,l,r);
        QuickSort(nums,l,base-1);
        QuickSort(nums,base+1,r);
    }

    public static int partition1(int []nums ,int l,int r){      
        int base = l;
        //双指针
        int lo = l, hi = r;

        //这种partition的实现细节有点不好理解
        //这种partition不能随机基准元素。。。。
        //参照了左神的代码发现其实可以在partition之前随机一个变量和lo交换，也有同样的效果也消除了输入的影响
        while (lo < hi) {
            //必须先从右往左,主要是为了归位的时候不出现问题
            //比如这里选取的基准元素是 lo 也就是子数组的第一个元素，如果先从左往右最后交换的就是lo和一个比lo大的数然而比lo大的数应该放在右边
            //反之如果选的是hi为基准就要先从左往右
            // 7  0  1  2    10  11  22
            while (nums[hi] > nums[base] && lo < hi) {
                hi--;
            }
            while (nums[lo] <= nums[base] && lo < hi) {
                lo++;
            }
            if (lo < hi) {
                swap(nums, lo, hi);
            }
        }
        //归位 lo==hi
        swap(nums, hi, base);
        return lo;
    }

    private static void swap(int []nums,int a,int b){
        //不知道为啥快排交换的时候这样写会出现很多0
        //查询知道，当a==b时自己和直接交换，a异或自己4次后a==0.....
        /*nums[a]=nums[a]^nums[b];
        nums[b]=nums[a]^nums[b];
        nums[a]=nums[a]^nums[b];*/
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }

    //荷兰国旗优化的快排
    public static int[] partition2(int []arr ,int l,int r){
        // 7  0  1  2    10  11  22     
        //小于区为空
        int less=l-1;
        //l ----> more 为待定区
        int more=r;
        while(l<more){
            if(arr[l]<arr[r]){
                swap(arr,++less,l++);
            }else if(arr[l]>arr[r]){
                //大于基准时 , 大于区扩大(大于区的前一个元素和当前元素交换，但是不知道大于区的前一个元素是什么情况，所以不能l++)
                swap(arr,--more,l);
            }else{
                l++;
            }
        }
        //和大于区间的第一个交换 保证归位正确,如果选取的是以最左边为基准元素 这里就应该和less交换
        //到这里  [less+1,more-1]之间都是等于 基准元素 arr【r】 的
        swap(arr,more,r);
        //到这  [less+1,more]之间都是等于 基准元素 arr【r】 的
        return new int[]{less+1,more};
    }

    //随机正数
    public static int[] generateRandomOpArray(int maxSize, int maxValue) {
        int[] arr = new int[maxSize];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (maxValue * Math.random()+1);
        }
        return arr;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    //C(5,2)
    public static long C(int n, int k) {
        long a = 1, b = 1;
        //C(10,9)转换成C(10,1)
        if (k > n/2) {
            k = n-k;
        }
        for (int i = 1; i <= k; i++) {
            a *= (n-i+1);
            b *= i;
        }
        return a/b;
    }
}

class InputReader {

    public BufferedReader reader;
    
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        //char[32768]
        reader = new BufferedReader(new InputStreamReader(stream), 32768);
        tokenizer = null;
    }

    //默认以" "作为分隔符，读一个
    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    //有的题目不给有多少组测试用例，只能一直读，读到结尾，需要自己判断结束
    //该函数也会读取一行，并初始化tokenizer，后序直接nextInt..等就可以读到该行
    public boolean EOF() {
        String str = null;
        try {
            str = reader.readLine();
            if (str == null) {
                return true;
            }
            //创建tokenizer
            tokenizer = new StringTokenizer(str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    int nextInt(){
        return Integer.parseInt(next());
    }
    
    long nextLong(){
        return Long.parseLong(next());
    }
    
    double nextDouble(){
        return Double.parseDouble(next());
    }
    
    BigInteger nextBigInteger(){
        return new BigInteger(next());
    }

    BigDecimal nextBigDecimal(){
        return new BigDecimal(next());
    }
}