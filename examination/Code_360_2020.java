import java.io.*;// petr的输入模板
import java.util.*; 
import java.math.*; // 不是大数题可以不要这个

/*

搬家公司正在帮助一家人将小物体装箱。一个箱子的大小是有限的
公司可以把一个箱子分成最多k个独立的隔间，将一个箱子分成r个隔间需要r-1个隔板
（这一个箱子没有放隔板也拥有一个本身的隔间）。而这一次搬家工作只携带了b个隔板。
在每一个隔间中，由于物件放多了容易损坏，最多只能放v个物体。现在这家人有a个物体，
请问最少需要多少个箱子，才能将所有的物体装箱？

 */
//笔试专用
public class Code_360_2020 {

    public static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        //write your code
        //InputReader in = new InputReader(System.in);
        InputReader in = new InputReader(new FileInputStream("./input.txt"));
        while(!in.EOF()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int s = in.nextInt();
            int t = in.nextInt();
            HashMap<Integer, List<Integer[]>> map = new HashMap<>();
            for (int i = 0; i < m; i++) {
                int a = in.nextInt();
                int b = in.nextInt();
                int c = in.nextInt();
                if (!map.containsKey(a)) {
                    List<Integer[]> lis = new ArrayList<>();
                    lis.add(new Integer[]{b, c});
                    map.put(a, lis);
                } else {
                    map.get(a).add(new Integer[]{b, c});
                }

                if (!map.containsKey(b)) {
                    List<Integer[]> lis = new ArrayList<>();
                    lis.add(new Integer[]{a, c});
                    map.put(b, lis);
                } else {
                    map.get(b).add(new Integer[]{a, c});
                }
            }
            boolean[] vis = new boolean[n+1];
            Integer[] cache = new Integer[n+1];
            int res = Integer.MAX_VALUE;
            for (Integer[] c : map.get(s)) {
                vis[s] = true;
                int max = Math.max(c[1], dfs(cache, map, c[0], t, vis));
                res = Math.min(res, max);
            }
            out.println(res);
        }
        //别忘了flush
        out.flush();
        out.close();
    }

        
    public static int dfs(Integer[] cache, HashMap<Integer, List<Integer[]>> map, int s, int t, boolean[] vis) {
        if (s == t) {
            return 0;
        }
        if (cache[s] != null) {
            return cache[s];
        }
        vis[s] = true;
        int max = 0;
        for (Integer[] c : map.get(s)) {
            if (!vis[c[0]]) {
                max = Math.max(c[1], dfs(cache, map, c[0], t, vis));
            }
        }
        vis[s] = false;
        return cache[s] = max;
    }

    //一个隔监放v个物体，一个xz k个隔间，消耗k个隔板
    public static int solve1(int a, int b, int k, int v) {
        int res = 0;
        while (b > 0) {
            if (b >= k-1) {
                a -= v*k;
                b -= k-1;
            } else {
                a -= (b+1)*v;
                b = 0;
            }
            res++;
            if (a <= 0) {
                return res;
            }
        }
        return res + (a+v-1)/v;
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