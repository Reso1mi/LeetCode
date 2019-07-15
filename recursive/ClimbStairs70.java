public class ClimbStairs70{
	public static void main(String[] args) {
		//System.out.println(climbStairs(10));
		System.out.println(climbStairsDp(10));
	}


	private static int[] cache=null;

	public static int climbStairs(int n) {
		cache=new int[n+1];
		return climbStairs(0,n);
	}

	//记忆化递归
	public static int climbStairs(int cur,int n) {
		if(cur>n){
			return 0;
		}
		if(n==cur){
			return 1;
		}
		if (cache[cur]>0) {
			return cache[cur];
		}
		cache[cur]=climbStairs(cur+1,n)+climbStairs(cur+2,n);;
		return cache[cur];
	}

	//dp （第一次接触dp）
	public static int climbStairsDp(int n){
		int []dp=new int[n+1];
		dp[0]=1;
		dp[1]=1;
		for (int i=2;i<=n;i++) {
			dp[i]=dp[i-1]+dp[i-2];
		}
		return dp[n];
	}
}