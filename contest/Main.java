import java.io.*;// petr的输入模板
import java.util.*; 
import java.math.*; // 不是大数题可以不要这个

//笔试专用
public class Main {

    public static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        //write your code
        InputReader in = new InputReader(System.in);
        //InputReader in = new InputReader(new FileInputStream("./input.txt"));
        while(!in.EOF()) {
            int n = in.nextInt();
            int k = in.nextInt();
        }
        out.println(res);
        //别忘了flush
        out.flush();
        out.close();
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