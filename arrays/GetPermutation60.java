public class GetPermutation60{
	
	public static void main(String[] args) {
		
	}

	//1234n ---n4321 
	public String getPermutation(int n, int k) {
     	
     	//逆康托展开式
     	//https://juejin.im/entry/5943b9c88d6d810058d49311
     	StringBuilder sb = new StringBuilder();
        // 候选数字
        List<Integer> candidates = new ArrayList<>();
     	int[] factorials = new int[n+1];
        factorials[0] = 1;
        int fact = 1;
        for(int i = 1; i <= n; ++i) {
            candidates.add(i);
            fact *= i;
            factorials[i] = fact; //保存 每一位的阶乘
        }
        k-= 1; // k!/k = (k-1)! 分片最后要除以k
        for(int i = n-1; i >= 0; --i) {
            // 计算候选数字的index
            int index = k / factorials[i];
            sb.append(candidates.remove(index));
            k -= index*factorials[i];
        }
        return sb.toString();

    }
}