import java.io.*;// petr的输入模板
import java.util.*; 
import java.math.*; // 不是大数题可以不要这个
public class StringTokenizerInput{
    
    public static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception{
        InputReader in = new InputReader(System.in);
        //InputReader in = new InputReader(new FileInputStream("./input.txt"));
        while(!in.EOF()) {
            int n = in.nextInt();
            int v1 = in.nextInt();
            int v2 = in.nextInt();
            int k = in.nextInt();
            int[][] cost = new int[n][3];
            for (int i = 0; i < n; i++) {
                cost[i][0] = in.nextInt();
                cost[i][1] = in.nextInt();
                cost[i][2] = in.nextInt();
            }
            solve(n, v1, v2, k, cost);
        }
        //别忘了flush
        out.flush();
        out.close();
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