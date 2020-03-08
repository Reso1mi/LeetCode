import java.io.*;// petr的输入模板
import java.util.*; 
import java.math.*; // 不是大数题可以不要这个
public class FastScanner{

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));//需要抛出 IOException
        String[] line0 = reader.readLine().split(" ");
        int n = Integer.parseInt(line0[0]);
        int m = Integer.parseInt(line0[1]);
        //...line0[2]...
        while(m-- > 0){
            String[] line = reader.readLine().split(" ");
            //......
        }
    }
}