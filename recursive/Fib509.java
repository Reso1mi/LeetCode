public class Fib509{
	public static void main(String[] args) {
		
	}

	public int fib(int N) {
		if(N==0||N==1){
			return N;
		}
		return fib(N-1)+fib(N-2);
	}

    public static Map map=new HashMap();
    //HashMap记忆化
    public int fib1(int N) {
    	if(N==0||N==1){
    		return N;
    	}
    	if(map.containsKey(N)){
    		return map.get(N);
    	}
    	int res=fib(N-1)+fib(N-2);
    	map.put(N,res);
    	return res;
    }

    int index=0;
    //数组记忆化
    public int fib(int N) {
    	int [] cache=new int[N];
    	return fib(N,cache);
    }

    public int fib(int N,int []cache) {
    	if(N==0||N==1){
    		return N;
    	}
    	if(cache[N-1]!=0){
    		return cache[N];
    	}
    	int res=fib(N-1)+fib(N-2);
    	cache[N-1]=res;
    	return res;
    }    

}