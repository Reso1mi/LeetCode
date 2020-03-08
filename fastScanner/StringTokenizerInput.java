import java.io.*;// petr的输入模板
import java.util.*; 
import java.math.*; // 不是大数题可以不要这个
public class StringTokenizerInput{
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in); // 如果是文件读入这里就不是System.in而是File了
        int n = in.nextInt();
        int m = in.nextInt();
        while(m-- >0){
            int a = in.nextInt();
            //......
            System.out.println(a);
        }   
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

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                //默认以" "作为分隔符
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
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